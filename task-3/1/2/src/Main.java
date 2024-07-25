import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = 100 + random.nextInt(900);
        System.out.println("Three digit number = " + randomNumber);
        System.out.println("Sum first digit = " + sumFirstDigit(randomNumber));
    }

    public static int sumFirstDigit(int num) {
        String numStr = Integer.toString(num);
        int firstDigit = Character.getNumericValue(numStr.charAt(0));
        int secondDigit = Character.getNumericValue(numStr.charAt(1));
        return firstDigit + secondDigit;
    }
}
