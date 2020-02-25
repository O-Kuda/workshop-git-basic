package academy.everyonecodes.java.week10.set1.validator;

import academy.everyonecodes.java.week5.reflection.exercise2.LinesCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LengthValidatorTest {
    LengthValidator validator = new LengthValidator(List.of("0","10"));

    @ParameterizedTest
    @CsvSource({
            "true,1234567890",
            "true, ''",
            "false, 12345"
    })
    void isValid(boolean expected, String input) {
        boolean result = validator.isValid(input);
        Assertions.assertEquals(expected,result);
    }
}