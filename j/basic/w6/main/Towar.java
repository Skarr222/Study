package w6.main;
public class Towar {
    private String kod;
    private String nazwa;
    private float cena;
    public Towar(String kod, String nazwa, float cena) {
        this.kod = kod;
        this.nazwa = nazwa;
        this.cena = cena;
    }
    public void DrukujTowar() {
        System.out.println("Kod: " + kod);
        System.out.println("Nazwa: " + nazwa);
        System.out.println("Cena: " + cena);
    }

}
