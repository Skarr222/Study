package l1.main;

import java.util.ArrayList;
import java.util.List;

public class Klient extends Osoba {
    private String numerKlienta;
    private String typPlatnosci;
    private int liczbaZamowien = 0;
    private List<String> historiaZamowien; //* tutaj przechowujemy listę wszystkich złożonych dotychczas zamówień, a dokładniej numery zamówień
    {
        System.out.println("Witam z bloku inicjalizacyjnego!");
        Ksiegowosc.liczbaKlientow++;
    }

    public Klient(String imie, String nazwisko, Adres adres, String numerKlienta, String typPlatnosci) {
        super(imie, nazwisko, adres);
        this.numerKlienta = numerKlienta;
        this.typPlatnosci = typPlatnosci;
        this.historiaZamowien = new ArrayList<>();
        System.out.println("Witam z konstruktora!");
    }

    public String getNumerKlienta() {
        return numerKlienta;
    }

    public String getTypPlatnosci() {
        return typPlatnosci;
    }

    public void getHistoriaZamowien() {
        System.out.println("===========Historia zamówień klienta=============");
        for(int i=0;i<historiaZamowien.size();i++) {
            System.out.println("Zamówienie nr:" + historiaZamowien.get(i));
        }
        /*
        * poniżej wydajniejszy sposób zapisu metody wypisującej na konsolę przy użyciu metody forEach oraz wyrażenia lambda
        * historiaZamowien.forEach(numerZamowienia -> System.out.println("Zamówienie nr:" + numerZamowienia));
        */
    }

    public int getLiczbaZamowien(){
        return this.liczbaZamowien;
    }

    public void zwiekszLiczbeZamowien(){
        this.liczbaZamowien++;
    }

    public void zwiekszHistorieZamowienKlienta(int indeks, String numerZamowienia) {
        this.historiaZamowien.add(numerZamowienia);
    }

    public void wyswietlKlienta() {
        System.out.println("=======Dane klienta: =======");
        super.wyswietlOsobe();
        System.out.println("Numer klienta: " + getNumerKlienta());
        System.out.println("Typ platnosci: " + getTypPlatnosci());
        System.out.println("Historia zamowien: ");
        getHistoriaZamowien();
        System.out.println("Łączna liczba zamówień klienta: " + getLiczbaZamowien());
    }


}
