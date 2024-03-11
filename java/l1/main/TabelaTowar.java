package l1.main;

public class TabelaTowar extends Tabela<Towar>{

    public TabelaTowar(String nazwaTabeli) {
        super(nazwaTabeli);
    }
    @Override
    public void zapiszDoTabeli(Towar towar) {
        super.zapiszDoTabeli(towar);
        System.out.println("Witam z klasy TabelaTowar");
    }

    @Override
    public void usunZTabeli(Towar towar) {
        super.usunZTabeli(towar);
        System.out.println("Usuwanie danych z kolekcji ...");
    }

    @Override
    public void wyswietlDaneNaKonsoliZTabeli() {
        System.out.println("Wyświetlanie danych z kolekcji ...");
    }
}
