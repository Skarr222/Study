package kol1;

public class Telefon {
    private Double cena;
    private String model;
    private String producent;
    public Telefon(Double cena, String model, String producent ) {
        this.cena = cena;
        this.model = model;
        this.producent = producent;
    }

    public Double getCena() {
        return cena;
    }

    public String getModel() {
        return model;
    }

    public String getProducent() {
        return producent;
    }

    public String WyswietlTelefon() {
        return "Telefon: " + producent + " " + model + " " + cena + "zł";
    }
}
