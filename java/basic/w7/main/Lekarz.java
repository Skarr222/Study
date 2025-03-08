package w7.main;

public class Lekarz extends Osoba{
    private String specjalizacja;

    public Lekarz(String imie, String nazwisko, String specjalizacja) {
        super(imie, nazwisko);
        this.specjalizacja = specjalizacja;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }
    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    public float Wynagrodzenie (int godzinyPracy){
        return godzinyPracy * Parametry.GetStawkeGodzinowaLekarza();
    }


}
