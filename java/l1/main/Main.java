package l1.main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Laboratorium 1");
        Towar t1 = new Towar("Mleko", "A1", "Mleko bez laktozy ", 2.5, 100 );
        Towar t2 = new Towar("Kakao", "A2", "Deco Moreno", 4.56, 10 );
        System.out.println("==================================");
        //tworzymy obiekt typu Adres, który przekażemy w konstruktorze Klienta
        Adres a1 = new Adres("Polska", "Warszawa", "00-001");
        Klient k1 = new Klient("Jan", "Kowalski", a1, "Klient1", "Blik");
//        k1.wyswietlKlienta();
        System.out.println("==================================");
        Klient k2 = new Klient("Andrzej", "Kowalski", a1, "Klient2", "Karta");
//        k2.wyswietlKlienta();
//        System.out.println("==================================");
//
        Zamowienie z1 = new Zamowienie("ZAM/1/11/23", k1);
//        k1.wyswietlKlienta();
        Zamowienie z2 = new Zamowienie("ZAM/2/11/23", k1);
//        System.out.println("==================================");
//        k1.wyswietlKlienta();
//
//        z1.dodajTowarDoZamowienia(t1);
//        System.out.println("Łączna suma wszystkich zamówień to: " + Ksiegowosc.sumaWszystkichZamowien);
//        z1.dodajTowarDoZamowienia(t2);
//        System.out.println("Łączna suma wszystkich zamówień to: " + Ksiegowosc.sumaWszystkichZamowien);
//        z1.wyswietlZamowienie();
//        System.out.println("==================================");
//        System.out.println("Łączna liczba klientów w systemie to: " + Ksiegowosc.liczbaKlientow);
//
//        System.out.println("================Projekcja Bazy Danych==================");

        TabelaKlient tabelaKlient = new TabelaKlient("Klienci");
        tabelaKlient.zapiszDoTabeli(k1);
        tabelaKlient.zapiszDoTabeli(k2);
        tabelaKlient.wyswietlDaneNaKonsoliZTabeli();

        TabelaZamowienia tabelaZamowienia = new TabelaZamowienia("Zamowienia");
        tabelaZamowienia.zapiszDoTabeli(z1);
        tabelaZamowienia.zapiszDoTabeli(z2);

    }


    /*
     *   Chcemy w naszej aplikacji zaimplementować(naśladować) zachowanie bazy danych w postaci odpowiednich klas i interfejsu
     *   Musimy umożliwić zapis do naszej bazy, usuwać wybrane elementy i wyświetlać dane z bazy
     *   Każda baza posiada tabele , więc my także sobie je wprowadzimy. Będą tabele takie jak:
     *   - TabelaKlient,
     *   - TabelaZamowienie,
     *   - TabelaTowar,
     *   - TabelaAdres

     *   Będziemy potrzebować :
     *   - zestawu instrukcji typu zapiszDoTabeli(T obiekt), usunZTabeli(T obiekt) i wyswietlDaneNaKonsoliZTabeli(),
     *   które będą dostępne w każdej tabeli - będzie to zestaw metod zdefiniowanych w interfejsie BazaDanychOperacje
     *   - klasy bazowej typu abstract class Tabela, która będzie podstawą do utworzenia konkretnych klas
     *   - klas , które będą przechowywać w formie listy obiekty o poszczególnych typach w formie bazodanowej tabeli
     */
}
