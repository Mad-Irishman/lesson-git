import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = 100 + random.nextInt(900);
        System.out.println("Three digit number = " + randomNumber);
        System.out.println("Difference = " + difference(randomNumber));
        System.out.println("Three digit number = " + randomNumber);
        System.out.println("Difference length = " + differenceLength(randomNumber));

    }

    //For a three-digit number
    public static int difference(int num) {
        return (num / 100 % 10) + (num / 10 % 10) - (num % 10);
    }

    //For any number of lengths
    public static int differenceLength(int num) {
        String numStr = Integer.toString(num);
        int firstDigit = Character.getNumericValue(numStr.charAt(0));
        int secondDigit = Character.getNumericValue(numStr.charAt(1));
        int thirdDigit = Character.getNumericValue(numStr.charAt(2));
        return firstDigit + secondDigit - thirdDigit;
    }
}