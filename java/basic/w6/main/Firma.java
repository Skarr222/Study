package w6.main;

public class Firma  extends BazaDanych{

    private String nazwa;
    private BazaDanych db;
    public Firma(String nazwa) {
        this.nazwa = nazwa;
        db = new BazaDanych();
    }
    public BazaDanych getDb() {
        return db;
    }

}
