package academy.everyonecodes.java.optionals.exceptions.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ChatBotTest {
    ChatBot chatBot = new ChatBot();

    private static Stream<Arguments> chatParameters() {
        return Stream.of(
                Arguments.of("temperature bla", "Argument not supported: bla"),
                Arguments.of("temperature 2", "Temperature raised by 2"),
                Arguments.of("temperature -5", "Temperature lowered by 5"),
                Arguments.of("lights meh", "Argument not supported: meh"),
                Arguments.of("lights on", "Lights switched on"),
                Arguments.of("lights off", "Lights switched off"),
                Arguments.of("bla bla", "Argument not supported: bla"),
                Arguments.of("", "Argument not supported: "),
                Arguments.of("12345", "Argument not supported: "),
                Arguments.of("123 456", "Argument not supported: 123")
        );
    }

    @ParameterizedTest
    @MethodSource("chatParameters")
    void chatTest(String input, String expected) {
        String result = chatBot.handle(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void chatDoesNotThrow() {
        Assertions.assertDoesNotThrow(()->{
            chatBot.handle("temperature 2");
        });
    }

    @Test
    void handleAllCommands() {
        String inputCommandOne = "bla";
        String inputCommandTwo = "bla";
        Assertions.assertThrows(WrongFirstArgumentException.class, () -> {
            chatBot.handleAllCommands(inputCommandOne,inputCommandTwo);
        });
    }

    @Test
    void handleTemperature() {
        String inputCommandOne = "temperature";
        String inputCommandTwo = "bla";
        Assertions.assertThrows(WrongSecondArgumentException.class, () -> {
            chatBot.handleTemperature(inputCommandOne,inputCommandTwo);
        });
        Assertions.assertDoesNotThrow(()->{
            chatBot.handleTemperature(inputCommandOne, "5");
            chatBot.handleTemperature(inputCommandOne, "-5");
        });
    }

    @Test
    void handleLight() {
        String inputCommandOne = "lights";
        String inputCommandTwo = "meh";
        Assertions.assertThrows(WrongSecondArgumentException.class, () -> {
            chatBot.handleLight(inputCommandOne,inputCommandTwo);
        });
        Assertions.assertDoesNotThrow(()->{
            chatBot.handleLight(inputCommandOne, "on");
            chatBot.handleLight(inputCommandOne, "off");
        });
    }
}