package homeWork.l1;

public class Samochod extends Pojazd {
    private String marka, model ;
    private int rokProdukcji;
    private double cena;
    private double obnizkaProcentowa;
    private Silnik silnik;

    public Samochod(String marka, String model, int rokProdukcji, double cena , String typPojazdu, String nrRejestracyjny ,double obnizkaProcentowa , Silnik silnik) {
        super(typPojazdu,nrRejestracyjny);
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.cena = cena;
        this.obnizkaProcentowa = 0;
        this.silnik = silnik;
    }
    public String getMarka() {
        return marka;
    }
    public String getModel() {
        return model;
    }
    public int getRokProdukcji() {
        return rokProdukcji;
    }
    public double getCena() {
        return cena;
    }
    public void ustawObnizke(double nowaObnizka) {
        if (nowaObnizka >= 0 && nowaObnizka <= 1) {
            obnizkaProcentowa = nowaObnizka;
            System.out.println("Nowa obniżka ustawiona na: " + (nowaObnizka * 100) + "%");
        } else {
            System.out.println("Błędna wartość obniżki. Podaj wartość pomiędzy 0 a 1.");
        }
    }
    public double getCenaPoObnizce() {
        return cena * ( 1 - obnizkaProcentowa);
    }

    public void wyswietlSamochod() {
        super.wyswietlPojazd();
        System.out.println("Samochód marki: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Rok produkcji: " + getRokProdukcji());
        System.out.println("Cena regularna: " + getCena() );
        System.out.println("Cena po obniżce: " + getCenaPoObnizce());
        System.out.println("Dane silnika: ");

        silnik.wyswietlSilnik();
    }
}
