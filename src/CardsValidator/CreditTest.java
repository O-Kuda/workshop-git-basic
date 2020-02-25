package academy.everyonecodes.java.week10.set1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CreditTest {
    Credit credit = new Credit();

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("INVALID", "123123123123"),
                Arguments.of("INVALID", ""),
                Arguments.of("INVALID", "asdkjksGFD123GG"),
                Arguments.of("AMERICAN EXPRESS", "378734493671000"),
                Arguments.of("AMERICAN EXPRESS", "378282246310005"),
                Arguments.of("MASTERCARD", "5105105105105100"),
                Arguments.of("MASTERCARD", "5204105105105100"),
                Arguments.of("MASTERCARD", "5376089889547459"),
                Arguments.of("MASTERCARD", "5456209173095287"),
                Arguments.of("MASTERCARD", "5555555555554444"),
                Arguments.of("VISA", "4111111111111111"),
                Arguments.of("VISA", "4012888888881881")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void evaluate(String expected, String  input) {
        String result = credit.evaluate(input);
        Assertions.assertEquals(expected,result);
    }
}