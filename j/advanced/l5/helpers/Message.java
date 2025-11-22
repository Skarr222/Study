package j.advanced.l5.helpers;

import static j.advanced.l5.helpers.Configure.RodzajWiadmosci;

public class Message {
    private RodzajWiadmosci rodzajMessagei;
    private String zawartosc;

    public Message(RodzajWiadmosci rodzajMessagei, String zawartosc) {
        this.rodzajMessagei = rodzajMessagei;
        this.zawartosc = zawartosc;
    }

    public RodzajWiadmosci getRodzajMessagei() {
        return rodzajMessagei;
    }

    public void setRodzajMessagei(RodzajWiadmosci rodzajMessagei) {
        this.rodzajMessagei = rodzajMessagei;
    }

    public String getZawartosc() {
        return zawartosc;
    }

    public void setZawartosc(String zawartosc) {
        this.zawartosc = zawartosc;
    }

    public String serializuj() {
        return rodzajMessagei.name() + ";" + zawartosc;
    }

    public static Message deserializuj(String MessageString) {
        String[] zdeserializowanaMessage = MessageString.split(";");
        return new Message(Configure.RodzajWiadmosci.valueOf(zdeserializowanaMessage[0]),
                zdeserializowanaMessage[1]);
    }
}
