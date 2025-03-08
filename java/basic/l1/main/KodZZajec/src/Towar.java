package l1.main.KodZZajec.src;
public class Towar {
    private String nazwa, kodTowaru, opis;
    private double cena;
    private int ilosc;

    public Towar(String nazwa, String kodTowaru, String opis, double cena, int ilosc) {
        //inicjalizujemy wartości zmiennych klasy Towar wewnątrz konstruktora, słówko kluczowe this jest potrzebne do bezpośredniego odwołania do atrybutu klasy
        this.nazwa = nazwa;
        this.kodTowaru = kodTowaru;
        this.cena = cena;
        this.ilosc = ilosc;
        this.opis = opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getKodTowaru() {
        return kodTowaru;
    }

    public String getOpis() {
        return opis;
    }

    public double getCena() {
        return cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void wyswietlTowar() {
        System.out.println("Towar=[Nazwa: " + getNazwa());
        System.out.println("Kod towaru: " + getKodTowaru());
        System.out.println("Opis: " + getOpis());
        System.out.println("Cena jednostkowa: " + getCena());
        System.out.println("Ilosc: " + getIlosc() );
        System.out.println("Wartość: " + getCena()*getIlosc()+"]");
    }
}
