package l1.main;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie{
    private final String numerZamowienia;
    private double wartoscZamowienia;
    private List<Towar> listaTowarow; //* zmiana z talbicy Towar[] na bardziej dynamiczną i elastyczną kolekcję List
    private Klient klient;
    {
        Ksiegowosc.liczbaZamowien++;
    }

    public Zamowienie(String numerZamowienia, Klient klient) {
        this.numerZamowienia = numerZamowienia;
        this.klient = klient;
        //* implementujemy w postaci ArrayList, ponieważ List jest interfejsem
        listaTowarow = new ArrayList<>();
        wartoscZamowienia = 0;
        this.klient.zwiekszHistorieZamowienKlienta(this.klient.getLiczbaZamowien(), this.numerZamowienia);
        this.klient.zwiekszLiczbeZamowien();
    }

    public String getNumerZamowienia() {
        return numerZamowienia;
    }

    public double getWartoscZamowienia() {
        return wartoscZamowienia;
    }

    public void getListaTowarow() {
        for(int i=0;i<listaTowarow.size();i++) {
            listaTowarow.get(i).wyswietlTowar(); //* odwołujemy się do wybranego indeksu listy poprzez metodę get(int index)
        }
        //*listaTowarow.forEach(towar -> towar.wyswietlTowar());  bardziej wydajna wersja powyższej pętli do wyświetlania danych towaru w konsoli z użyciem metody forEach oraz wyrażenia lambda
    }

    public void getKlient() {
        klient.wyswietlKlienta();
    }

    public void setKlient(Klient k) {
        this.klient = k;
    }
    //* Poniższe metoda dodajTowarDoZamowienia wypada , dodawanie elementów do listy jest znacznie prostsze
//    public void dodajTowarDoZamowienia(int index, Towar t) {
//        if (index >= 0 && index < listaTowarow.length) { /* podając wartość indexu w parametrze musi zabezpieczyć się
//            przed niepożądanym wyjściem poza rozmiar tablicy. Tworzymy warunek za pomocą operatora logicznego AND czyli &&, obydwa warunki muszą byc spełnione */
//            this.listaTowarow[index] = t; // przypisujemy wartość pod wskazany indeks tablicy
//            double wartoscLacznaTowaru = t.getCena() * t.getIlosc();
//            this.wartoscZamowienia += wartoscLacznaTowaru;
//            Ksiegowosc.sumaWszystkichZamowien += wartoscLacznaTowaru;
//        }
//    }

    public void dodajTowarDoZamowienia(Towar t){
        listaTowarow.add(t);
    }

    public void wyswietlZamowienie() {
        System.out.println("=======Dane zamowienia=======");
        System.out.println("Numer zamowienia: " + getNumerZamowienia() );
        System.out.println("Wartosc zamowienia: " + getWartoscZamowienia() + " zł" );
        getKlient();
        System.out.println("Towary: ");
        getListaTowarow();
        System.out.println("\n");
    }
}
