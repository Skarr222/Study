package l1.main;

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
        System.out.println("Nazwisko: " + getNazwisko());
        getAdres();
    }
}
 /*
  * interface BazaDanych -> metody: dodajKsiazke, usunKsiazke, wyswietlKsiazki
  * abstract class BazaKsiazek implements BazaDanych -> gatunek, (...metody z interfejsu)
  * abstract class Ksiazka extends BazaKsiazek -> autor, tytul, rokWydania, cena
  * class Fantasy extends Ksiazka -> typFantastyki(HighFantasy, LowFantasy, UrbanFantasy, ...)
  * class Horror extends Ksiazka -> typHorroru(Groza, HorrorKomediowy, ...)
 */