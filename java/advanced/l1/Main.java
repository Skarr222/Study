class AnalizatorTekstu {
    public void wyswietlDane(String phrase) {
        System.err.println("Text: " + phrase);
        System.err.println("Length: " + phrase.length());
        System.err.println("First char: " + phrase.charAt(0));
        System.err.println("Last char: " + phrase.charAt(phrase.length() - 1));
    }
}

public class Main {
    public static void main(String[] args) {
        AnalizatorTekstu analizator = new AnalizatorTekstu();
        analizator.wyswietlDane("Witaj świecie!");

        if (args.length > 0) {
            analizator.wyswietlDane(args[0]);
        } else {
            System.out.println("Nie podano tekstu jako argumentu.");
        }
    }
}