package l2.main;

public class Opinia {

    private final String idOpinii;
    private String trescKomentarza, dataKomentarza;
    private Uzytkownik uzytkownik;
    private Produkt produkt;

    public Opinia(String idOpinii, String trescKomentarza, String dataKomentarza, Uzytkownik uzytkownik, Produkt produkt) {
        this.idOpinii = idOpinii;
        this.trescKomentarza = trescKomentarza;
        this.dataKomentarza = dataKomentarza;
        this.uzytkownik = uzytkownik;
        this.produkt = produkt;
    }

    public String getIdOpinii() {
        return idOpinii;
    }
    public String getTrescKomentarza() {
        return trescKomentarza;
    }
    public String getDataKomentarza() {
        return dataKomentarza;
    }

    public void wyswietlOpinie(){
        System.out.println("--------------Opinia--------------"  );
        System.out.println("ID opinii: " + idOpinii);
        System.out.println("Data wystawienia: " + dataKomentarza);
        System.out.println("Opinia: " + trescKomentarza);
        uzytkownik.wyswietlUzytkownika();
        System.out.println("--------------Produkt--------------");
        produkt.wyswietlProdukt();
    }

}
