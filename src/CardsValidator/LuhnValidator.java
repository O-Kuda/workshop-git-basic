package academy.everyonecodes.java.week10.set1;

public class LuhnValidator {
    public boolean isLuhnValid(String number) {
        int sum = 0;
        boolean isAlternate = false;
        int n;
        for (int i = number.length() - 1; i >= 0; i--) {
            try {
                 n = Integer.parseInt(number.substring(i, i + 1));
            }catch (NumberFormatException e){
                e.printStackTrace();
                return false;
            }
            if (isAlternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            isAlternate = !isAlternate;
        }
        return (sum % 10 == 0);
    }
}
