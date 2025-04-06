package homeWork.l2;

public class Lekarz extends Pracownik{
    private String specjalizacja;
    private int numerPWZ;

    public Lekarz(String imie, String nazwisko, String pesel, String adres, String identyfikator, String stanowisko, String specjalizacja, int numerPWZ) {
        super(imie, nazwisko, pesel, adres, identyfikator, stanowisko);
        this.specjalizacja = specjalizacja;
        this.numerPWZ = numerPWZ;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }
    public int getNumerPWZ() {
        return numerPWZ;
    }



    public void wyswietlLekarza() {
        super.wyswietlPracownika();
        System.out.println("Specjalizacja: " + specjalizacja);
        System.out.println("Numer PWZ: " + numerPWZ);
    }
}
