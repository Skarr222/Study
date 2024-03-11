package l2.main;

public class Osoba {
    private String imie, nazwisko, dataUrodzenia, adresZamieszkania;

    public Osoba(String imie, String nazwisko, String dataUrodzenia, String adresZamieszkania) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.adresZamieszkania = adresZamieszkania;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getAdresZamieszkania() {
        return adresZamieszkania;
    }

    public void wyswietlOsobe(){
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Data urodzenia: " + dataUrodzenia);
        System.out.println("Adres zamieszkania: " + adresZamieszkania);
    }
}
