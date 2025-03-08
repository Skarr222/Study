package l2.main;

public class Produkt {

    private final String idProduktu;
    private String nazwaProduktu, typProduktu, opisProduktu;
    private double cenaProduktu;

    public Produkt(String idProduktu, String nazwaProduktu, String typProduktu, String opisProduktu, double cenaProduktu) {
        this.idProduktu = idProduktu;
        this.nazwaProduktu = nazwaProduktu;
        this.typProduktu = typProduktu;
        this.opisProduktu = opisProduktu;
        this.cenaProduktu = cenaProduktu;
    }


    public String getIdProduktu() {
        return idProduktu;
    }

    public String getNazwaProduktu() {
        return nazwaProduktu;
    }

    public String getTypProduktu() {
        return typProduktu;
    }

    public double getCenaProduktu() {
        return cenaProduktu;
    }

    public String getOpisProduktu() {
        return opisProduktu;
    }
    public void wyswietlProdukt(){
        System.out.println("ID produktu: " + idProduktu);
        System.out.println("Nazwa produktu: " + nazwaProduktu);
        System.out.println("Typ produktu: " + typProduktu);
        System.out.println("Opis produktu: " + opisProduktu);
        System.out.println("Cena produktu: " + cenaProduktu);
    }
}
