import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = 100 + random.nextInt(900);
        System.out.println("Three digit number = " + randomNumber);
        System.out.println("Sum digit = " + sumDigit(randomNumber));
    }

    public static int sumDigit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}