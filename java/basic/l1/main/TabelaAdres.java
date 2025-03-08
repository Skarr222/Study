package l1.main;

public class TabelaAdres extends Tabela<Adres>{

    public TabelaAdres(String nazwaTabeli) {
        super(nazwaTabeli);
    }
    @Override
    public void zapiszDoTabeli(Adres adres) {
        super.zapiszDoTabeli(adres);
        System.out.println("Witam z klasy TabelaAdres");
    }

    @Override
    public void usunZTabeli(Adres adres) {
        super.usunZTabeli(adres);
        System.out.println("Usuwanie danych z kolekcji ...");
    }

    @Override
    public void wyswietlDaneNaKonsoliZTabeli() {
        System.out.println("Wyświetlanie danych z kolekcji ...");
    }
}
