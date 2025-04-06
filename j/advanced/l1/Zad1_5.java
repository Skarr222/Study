package j.advanced.l1;

import java.util.Scanner;
import java.util.Vector;

class AnalizatorTekstu {
    public void wyswietlDane(String phrase) {
        System.err.println("______________________________________________");
        System.err.println("Text: " + phrase);
        System.err.println("Length: " + phrase.length());
        System.err.println("First char: " + phrase.charAt(0));
        System.err.println("Last char: " + phrase.charAt(phrase.length() - 1));
        System.err.println("______________________________________________");

    }

    public void wyswietlDane(Vector<String> phrases) {
        for (String phrase : phrases) {
            if ((phrases.indexOf(phrase) == phrases.indexOf(phrase + 1)) && phrases.size() == 2) {
                System.err.println("Takie same słowa");
            }
            wyswietlDane(phrase);
        }
    }
}

class Zad1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnalizatorTekstu analizator = new AnalizatorTekstu();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("0 – Zamknij program");
            System.out.println("1 – Wyświetl „Witaj świecie!” i przeanalizuj");
            System.out.println("2 – Wczytaj tekst i przeanalizuj");
            System.out.println("3 – Wczytaj kilka tekstów i przeanalizuj");

            System.out.print("Wybierz opcję: ");

            String wybor = scanner.nextLine();

            switch (wybor) {
                case "0":
                    System.out.println("Zamykanie programu...");
                    scanner.close();
                    return;
                case "1":
                    analizator.wyswietlDane("Witaj świecie!");
                    break;
                case "2":
                    System.out.print("Wprowadź tekst do analizy: ");
                    String input = scanner.nextLine();
                    analizator.wyswietlDane(input);
                    break;
                case "3":

                    System.out.print("Wprowadź ile tekstów chcesz przekazać do analizy: ");
                    Integer howMany = scanner.nextInt();
                    scanner.nextLine();
                    Vector<String> inputs = new Vector<>();
                    for (int i = 0; i < howMany; i++) {
                        String phrase = scanner.nextLine();
                        inputs.add(phrase);
                    }
                    analizator.wyswietlDane(inputs);
                    break;

                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }

    }
}