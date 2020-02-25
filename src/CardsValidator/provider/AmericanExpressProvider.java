package academy.everyonecodes.java.week10.set1.provider;

import academy.everyonecodes.java.week10.set1.validator.LengthValidator;
import academy.everyonecodes.java.week10.set1.validator.StartNumbersValidator;

import java.util.List;

public class AmericanExpressProvider extends Provider {
    public AmericanExpressProvider() {
        super("AMERICAN EXPRESS",
                List.of(
                        new StartNumbersValidator(List.of("34", "37")),
                        new LengthValidator(List.of("15"))
                )
        );
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
