package j.advanced.l5.helpers;

public class Wiadomosc {
    private RodzajWiadomosciEnum rodzajWiadomosci;
    private String zawartosc;

    public Wiadomosc(RodzajWiadomosciEnum rodzajWiadomosci, String zawartosc) {
        this.rodzajWiadomosci = rodzajWiadomosci;
        this.zawartosc = zawartosc;
    }

    public String getZawartosc() {
        return zawartosc;
    }

    public RodzajWiadomosciEnum getRodzajWiadomosci() {
        return rodzajWiadomosci;
    }

    public void setRodzajWiadomosci(RodzajWiadomosciEnum rodzajWiadomosci) {
        this.rodzajWiadomosci = rodzajWiadomosci;
    }

    public void setZawartosc(String zawartosc) {
        this.zawartosc = zawartosc;
    }

    public String serializuj() {
        return rodzajWiadomosci.name() + ";" + zawartosc;
    }

    public static Wiadomosc deserializuj(String wiadmoscString) {
        String[] zdeserializowanaWiadomosc = wiadmoscString.split(";");

        return new Wiadomosc(RodzajWiadomosciEnum.valueOf(zdeserializowanaWiadomosc[0]), zdeserializowanaWiadomosc[1]);
    }

}
