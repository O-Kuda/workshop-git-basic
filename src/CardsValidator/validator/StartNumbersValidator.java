package academy.everyonecodes.java.week10.set1.validator;

import java.util.List;

public class StartNumbersValidator implements Validator {
    private List<String> startNumbers;


    public StartNumbersValidator(List<String> startNumbers) {
        this.startNumbers = startNumbers;
    }

    @Override
    public boolean isValid(String number) {
        return startNumbers.stream().
                anyMatch(e -> number.startsWith(e));
    }
}
