package l1.main.KodZZajec.src;
public class Osoba  {
    private String imie;
    private String nazwisko;
    private Adres adres;

    public Osoba(String imie, String nazwisko, Adres adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void getAdres() {
        adres.wyswietlAdres();
    }

    public void wyswietlOsobe() {
        System.out.println("Imie: " + getImie() );
        System.out.println("Nazwisko: " + getNazwisko() );
        getAdres();
    }
}
