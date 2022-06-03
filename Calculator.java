import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Example: 1+5-2*8");
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Enter: ");
            String example = scan.next();
            int[] numbers = Arrays.stream(example.split("([-+*/])")).mapToInt(Integer::parseInt).toArray();
            char[] chars = example.replaceAll("([0-9])", "").toCharArray();
            int result = 0;

            for (int i = 0; i < chars.length; i++) {
                switch (chars[i]) {
                    case '+' -> result += numbers[i] + numbers[i = i + 1];
                    case '-' -> result += numbers[i] - numbers[i = i + 1];
                    case '*' -> result += numbers[i] * numbers[i = i + 1];
                    case '/' -> result += numbers[i] / numbers[i = i + 1];
                    case 'e' -> System.exit(0);
                }
            } System.out.println("Result: " + result);
        }
    }
}
