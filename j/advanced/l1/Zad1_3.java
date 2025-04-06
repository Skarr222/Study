package j.advanced.l1;

import java.util.Scanner;

class AnalizatorTekstu {
    public void wyswietlDane(String phrase) {
        System.err.println(phrase);
        System.err.println(phrase.length());
        System.err.println(phrase.charAt(0));
        System.err.println(phrase.charAt(phrase.length() - 1));
    }
}

class Przelicznik {
    public Przelicznik() {
    }

    public void calculateKmToMiles(Float numberToCalculate) {

    }
}

class Zad1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnalizatorTekstu analizator = new AnalizatorTekstu();
        String input = null;

        while (input == null || input.length() <= 0) {
            System.out.print("Imput phrase to analyze: ");
            input = scanner.nextLine();
        }

        analizator.wyswietlDane(input);

        scanner.close();
    }
}