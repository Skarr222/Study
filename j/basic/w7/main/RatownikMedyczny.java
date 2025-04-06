package w7.main;

public class RatownikMedyczny extends Osoba{
    private String opisUprawnien;

    public RatownikMedyczny(String imie, String nazwisko, String opisUprawnien) {
        super(imie, nazwisko);
        this.opisUprawnien = opisUprawnien;
    }

    public String getOpisUprawnien() {
        return opisUprawnien;
    }

    public String wyswietlRatownika(){
        return "Imie: " + getImie() + " Nazwisko: " + getNazwisko() + " Nr legitymacji: " + getOpisUprawnien();
    }

    public float Wynagrodzenie (int godzinyPracy){
        return godzinyPracy * Parametry.GetStawkeGodzinowaRatownika();
    }
}
