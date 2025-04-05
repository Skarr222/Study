import java.util.Scanner;

class AnalizatorTekstu {
    public void wyswietlDane(String phrase) {
        System.out.println(phrase);
        System.out.println(phrase.length());
        System.out.println(phrase.charAt(0));
        System.out.println(phrase.charAt(phrase.length() - 1));
    }
}

class Zad1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnalizatorTekstu analizator = new AnalizatorTekstu();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("0 – Zamknij program");
            System.out.println("1 – Wyświetl „Witaj świecie!” i przeanalizuj");
            System.out.println("2 – Wczytaj tekst i przeanalizuj");
            System.out.print("Wybierz opcję: ");

            String wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    analizator.wyswietlDane("Witaj świecie!");
                    break;
                case "2":
                    System.out.print("Wprowadź tekst do analizy: ");
                    String input = scanner.nextLine();
                    analizator.wyswietlDane(input);
                    break;
                case "0":
                    System.out.println("Zamykanie programu...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }

    }
}