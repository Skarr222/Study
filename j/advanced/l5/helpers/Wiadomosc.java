package j.advanced.l5.helpers;

import static j.advanced.l5.helpers.Configure.RodzajWiadmosci;

public class Wiadomosc {
    private RodzajWiadmosci rodzajWiadomosci;
    private String zawartosc;

    public Wiadomosc(RodzajWiadmosci rodzajWiadomosci, String zawartosc) {
        this.rodzajWiadomosci = rodzajWiadomosci;
        this.zawartosc = zawartosc;
    }

    public RodzajWiadmosci getRodzajWiadomosci() {
        return rodzajWiadomosci;
    }

    public void setRodzajWiadomosci(RodzajWiadmosci rodzajWiadomosci) {
        this.rodzajWiadomosci = rodzajWiadomosci;
    }

    public String getZawartosc() {
        return zawartosc;
    }

    public void setZawartosc(String zawartosc) {
        this.zawartosc = zawartosc;
    }

    public String serializuj() {
        return rodzajWiadomosci.name() + ";" + zawartosc;
    }

    public static Wiadomosc deserializuj(String wiadomoscString) {
        String[] zdeserializowanaWiadomosc = wiadomoscString.split(";");
        return new Wiadomosc(Configure.RodzajWiadmosci.valueOf(zdeserializowanaWiadomosc[0]),
                zdeserializowanaWiadomosc[1]);
    }
}
