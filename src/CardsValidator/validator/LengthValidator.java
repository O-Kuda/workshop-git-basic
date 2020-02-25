package academy.everyonecodes.java.week10.set1.validator;

import java.util.List;

public class LengthValidator implements Validator {
    private List<String> lengths;

    public LengthValidator(List<String> lengths) {
        this.lengths = lengths;
    }

    @Override
    public boolean isValid(String number) {
        return lengths.contains(String.valueOf(number.length()));
    }
}
