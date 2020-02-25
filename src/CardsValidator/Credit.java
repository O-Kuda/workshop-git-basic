package academy.everyonecodes.java.week10.set1;

import academy.everyonecodes.java.week10.set1.provider.AmericanExpressProvider;
import academy.everyonecodes.java.week10.set1.provider.MasterCardProvider;
import academy.everyonecodes.java.week10.set1.provider.Provider;
import academy.everyonecodes.java.week10.set1.provider.VisaProvider;

import java.util.List;
import java.util.Optional;

public class Credit {
    private List<Provider> providers;
    private LuhnValidator luhnValidator = new LuhnValidator();

    public Credit() {
        this.providers = List.of(
                new AmericanExpressProvider(),
                new MasterCardProvider(),
                new VisaProvider()
        );
    }

    public String evaluate(String number) {
        if (luhnValidator.isLuhnValid(number)) {
            Optional<Provider> oProvider = getProvider(number);
            if (oProvider.isPresent()) {
                return oProvider.get().getName();
            }
        }
        return "INVALID";
    }

    private Optional<Provider> getProvider(String number) {
        return providers.stream()
                .filter(e -> e.isValid(number))
                .findFirst();
    }
}
