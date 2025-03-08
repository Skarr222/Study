package l1.main;

public class TabelaZamowienia extends Tabela<Zamowienie> {

    public TabelaZamowienia(String nazwaTabeli) {
        super(nazwaTabeli);
    }

    @Override
    public void zapiszDoTabeli(Zamowienie zamowienie) {
        super.zapiszDoTabeli(zamowienie);
        System.out.println("Zapis z klasy TabelaZamowienia");
    }

    @Override
    public void usunZTabeli(Zamowienie zamowienie) {
        super.usunZTabeli(zamowienie);
        System.out.println("Usuwanie danych z kolekcji ...");
    }

    @Override
    public void wyswietlDaneNaKonsoliZTabeli() {
        System.out.println("Wyświetlanie danych z kolekcji ...");

    }
}