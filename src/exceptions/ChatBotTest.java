package academy.everyonecodes.java.optionals.exceptions.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ChatBotTest {
    ChatBot chatBot = new ChatBot();

    private static Stream<Arguments> parameters() {
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
    @MethodSource("parameters")
    void chat(String input, String expected) {
        String result = chatBot.handle(input);
        Assertions.assertEquals(expected,result);
    }
}