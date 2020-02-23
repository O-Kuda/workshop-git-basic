package academy.everyonecodes.java.optionals.exceptions.exercise1;

import java.util.List;
import java.util.Optional;

public class ChatBot {
    private int beginIndex = 0;
    private int endIndex = 1;

    public String handle(String inputMessage) {
        List<String> messageWords = List.of(inputMessage.split(" "));
        String commandOne = messageWords.get(beginIndex).toLowerCase();
        String commandTwo;
        try {
            commandTwo = messageWords.get(endIndex).toLowerCase();
        } catch (IndexOutOfBoundsException e) {
            return "Argument not supported: ";
        }
        try {
            return handleAllCommands(commandOne, commandTwo);
        } catch (WrongFirstArgumentException | WrongSecondArgumentException e) {
            return "Argument not supported: " + e.getMessage();
        }
    }

    String handleAllCommands(String commandOne, String commandTwo) throws WrongSecondArgumentException, WrongFirstArgumentException {
        Optional<String> oTemperature = handleTemperature(commandOne, commandTwo);
        if (oTemperature.isPresent()) {
            return oTemperature.get();
        }
        Optional<String> oLight = handleLight(commandOne, commandTwo);
        if (oLight.isPresent()) {
            return oLight.get();
        }
        throw new WrongFirstArgumentException(commandOne);
    }

    Optional<String> handleTemperature(String commandOne, String commandTwo) throws WrongSecondArgumentException {
        if (commandOne.toLowerCase().equals("temperature")) {
            try {
                int temperatureNumber = Integer.valueOf(commandTwo);
                if (temperatureNumber <= 0) {
                    return Optional.of("Temperature lowered by " + Math.abs(temperatureNumber));
                }
                return Optional.of("Temperature raised by " + temperatureNumber);
            } catch (NumberFormatException e) {
                throw new WrongSecondArgumentException(commandTwo);
            }
        }
        return Optional.empty();
    }

    Optional<String> handleLight(String commandOne, String commandTwo) throws WrongSecondArgumentException {
        if (commandOne.toLowerCase().equals("lights")) {
            if (commandTwo.toLowerCase().equals("on")) {
                return Optional.of("Lights switched on");
            }
            if (commandTwo.toLowerCase().equals("off")) {
                return Optional.of("Lights switched off");
            }
            throw new WrongSecondArgumentException(commandTwo);
        }
        return Optional.empty();
    }
}
