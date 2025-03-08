package kol1;

public class Smartfon extends Telefon {
    private String systemOperacyjny;
    private Integer pojemnoscBaterii;
    public Smartfon(Double cena, String model, String producent, String systemOperacyjny, Integer pojemnoscBaterii) {
        super(cena, model, producent);
        this.systemOperacyjny = systemOperacyjny;
        this.pojemnoscBaterii = pojemnoscBaterii;
    }

    public String getSystemOperacyjny() {
        return systemOperacyjny;
    }

    public Integer getPojemnoscBaterii() {
        return pojemnoscBaterii;
    }
    public String  WyswietlSmartfon() {
        return "Smartfon: " + getProducent() + " " + getModel() + " " + getCena() + "zł" + " " + systemOperacyjny + " " + pojemnoscBaterii + "mAh";
    }

}
