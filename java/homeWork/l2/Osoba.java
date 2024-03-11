package homeWork.l2;

public abstract class Osoba {
    private String imie;
    private String nazwisko;
    private String pesel;
    private String adres;

    public Osoba(String imie, String nazwisko, String pesel, String adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
    }
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public String getPesel() {
        return pesel;
    }
    public String getAdres() {
        return adres;
    }

    public void wyswietlOsobe() {
        System.out.println("Imie: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Pesel: " + pesel);
        System.out.println("Adres: " + adres);
    }
}
