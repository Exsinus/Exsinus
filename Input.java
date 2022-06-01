import java.util.Scanner;

public class Input {
    static Scanner scan = new Scanner(System.in);

    public static String s(String text) {
        System.out.print(text);
        return scan.next();
    }

    public static Integer i(String text) {
        System.out.print(text);
        return scan.nextInt();
    }
}
