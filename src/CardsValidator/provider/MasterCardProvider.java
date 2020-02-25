package academy.everyonecodes.java.week10.set1.provider;

import academy.everyonecodes.java.week10.set1.validator.LengthValidator;
import academy.everyonecodes.java.week10.set1.validator.StartNumbersValidator;

import java.util.List;

public class MasterCardProvider extends Provider {
    public MasterCardProvider() {
        super("MASTERCARD", List.of(
                new StartNumbersValidator(List.of("51", "52", "53", "54", "55")),
                new LengthValidator(List.of("16"))
                )
        );
    }

    @Override
    public String getName() {
        return super.getName();
    }
}