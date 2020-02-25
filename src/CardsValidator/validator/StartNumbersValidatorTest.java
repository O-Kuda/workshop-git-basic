package academy.everyonecodes.java.week10.set1.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class StartNumbersValidatorTest {
    StartNumbersValidator validator = new StartNumbersValidator(List.of("33", "0", "A"));

    @ParameterizedTest
    @CsvSource({
            "true,33fhrie4675",
            "true, 0khr6323",
            "true, 033",
            "true, Akhg765",
            "false, 303234jjk",
            "false, ddfgdk"
    })
    void isValid(boolean expected, String input) {
        boolean result = validator.isValid(input);
        Assertions.assertEquals(expected, result);
    }
}