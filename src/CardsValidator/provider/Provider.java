package academy.everyonecodes.java.week10.set1.provider;


import academy.everyonecodes.java.week10.set1.validator.Validator;

import java.util.List;

public abstract class Provider {
    private String name;
    private List<Validator> validators;

    public Provider(String name, List<Validator> validators) {
        this.name = name;
        this.validators = validators;
    }

    public String getName() {
        return name;
    }

    public List<Validator> getValidators() {
        return validators;
    }

    public boolean isValid(String number) {
        return getValidators().stream().allMatch(e -> e.isValid(number));

        /*
        boolean result = true;
        for (Validator val : getValidators()) {
            result = result && val.isValid(number);
        }
         */
    }
}
