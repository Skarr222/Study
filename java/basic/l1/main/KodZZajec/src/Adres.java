package l1.main.KodZZajec.src;
public class Adres  {
    private String miasto;
    private String kraj;
    private String kodPocztowy;

    public Adres(String kraj, String miasto, String kodPocztowy) {
        this.kraj = kraj;
        this.miasto = miasto;
        this.kodPocztowy = kodPocztowy;
    }

    public String getKraj() {
        return kraj;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void wyswietlAdres() {
        System.out.println("=======Dane adresowe=======");
        System.out.println("Kraj: " + getKraj() );
        System.out.println("Miasto: " + getMiasto() );
        System.out.println("Kod pocztowy: " + getKodPocztowy() );
        System.out.println("===========================");
    }
}

