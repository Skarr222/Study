import java.util.InputMismatchException;
import java.util.Scanner;

class UjemnaLiczbaException extends Exception {
    public UjemnaLiczbaException(String message) {
        super(message);
    }
}

class AnalizatorTekstu {
    public void wyswietlDane(String phrase) {
        System.out.println(phrase);
        System.out.println(phrase.length());
        System.out.println(phrase.charAt(0));
        System.out.println(phrase.charAt(phrase.length() - 1));
    }
}

class Przelicznik {
    public Przelicznik() {
    }

    public void calculateKmToMiles(Scanner scanner) {
        try {
            System.out.println("Wprowadź liczbę kilometrów: ");
            Integer input = scanner.nextInt();
            if (input <= 0) {
                throw new UjemnaLiczbaException("Liczba kilometrów nie może być ujemna!");
            }

            System.out.println("Mile " + (input / 1.852));

        } catch (InputMismatchException e) {
            System.err.println("Wprowadzono niepoprawną liczbę");
            System.err.println(e.getMessage() == null ? e.getClass().getName() : e.getMessage());

            return;
        } catch (UjemnaLiczbaException e) {
            System.err.println(e.getMessage());
            return;
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // * String input = null;
        // * AnalizatorTekstu analizator = new AnalizatorTekstu();
        // * while (input == null || input.length() <= 0) {
        // * System.out.print("Imput phrase to analyze: ");
        // * input = scanner.nextLine();
        // * analizator.wyswietlDane(input);

        Przelicznik calulate = new Przelicznik();

        calulate.calculateKmToMiles(scanner);

        scanner.close();
    }
}