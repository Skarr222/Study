package homeWork.l2;

public abstract class Pracownik extends Osoba{
    private String identyfikator;
    private String stanowisko;

    public Pracownik(String imie, String nazwisko, String pesel, String adres, String identyfikator, String stanowisko) {
        super(imie, nazwisko, pesel, adres);
        this.identyfikator = identyfikator;
        this.stanowisko = stanowisko;
    }
    public String getIdentyfikator() {
        return identyfikator;
    }
    public String getStanowisko() {
        return stanowisko;
    }
    public void wyswietlPracownika() {
        super.wyswietlOsobe();
        System.out.println("Identyfikator: " + identyfikator);
        System.out.println("Stanowisko: " + stanowisko);
    }

}
