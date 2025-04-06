package j.advanced.l2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*Simple calculator*");
        System.out.println("*1 - Prosty kalkulator");
        System.out.println("*2 - Rozbudowany kalkulator");
        System.out.println("*3 - Wybór kolorów");
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                new SimpleCalculator();
                break;
            case 2:
                new ExtendedCalculator();
                break;
            case 3:
                new ColorMixer();
                break;
            default:
                break;
        }
        scanner.close();

    }
}
