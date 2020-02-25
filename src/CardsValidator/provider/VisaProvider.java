package academy.everyonecodes.java.week10.set1.provider;

import academy.everyonecodes.java.week10.set1.validator.LengthValidator;
import academy.everyonecodes.java.week10.set1.validator.StartNumbersValidator;

import java.util.List;

public class VisaProvider extends Provider {
    public VisaProvider() {
        super("VISA", List.of(
                new StartNumbersValidator(List.of("4")),
                new LengthValidator(List.of("13", "16"))
                )
        );
    }

    @Override
    public String getName() {
        return super.getName();
    }

}
