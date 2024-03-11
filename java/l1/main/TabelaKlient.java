package l1.main;

//* klasa ta ma być rozumiana jako tabela w bazie danych, przechowująca obiekty typu Klient
public class TabelaKlient extends Tabela<Klient> {
    //*  tu jest nasza docelowa klasa przechowująca tabelę z klientami
    public TabelaKlient(String nazwaTabeli) {
        super(nazwaTabeli);
    }

    @Override
    public void zapiszDoTabeli(Klient klient) {
        System.out.println("Zapis z klasy TabelaKlient");
        super.zapiszDoTabeli(klient);
    }

    @Override
    public void usunZTabeli(Klient klient){
        super.usunZTabeli(klient);
        System.out.println("Usuwanie danych z kolekcji ...");
    }

    @Override
    public void wyswietlDaneNaKonsoliZTabeli() {
        System.out.println("Wyświetlanie danych z kolekcji ...");
        listaObiektow.forEach(klient -> klient.wyswietlKlienta());
    }

}