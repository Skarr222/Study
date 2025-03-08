package kol1;

public class Zamowienie {
    private Telefon telefon;
    private Integer iloscTelefonow;
    private Smartfon smartfon;
    private Integer iloscSmartfonow;

    public Zamowienie(Telefon telefon, Integer iloscTelefonow, Smartfon smartfon, Integer iloscSmartfonow) {
        this.telefon = telefon;
        this.iloscTelefonow = iloscTelefonow;
        this.smartfon = smartfon;
        this.iloscSmartfonow = iloscSmartfonow;
    }

    public Telefon getTelefon() {
        return telefon;
    }

    public Integer getIloscTelefonow() {
        return iloscTelefonow;
    }

    public Smartfon getSmartfon() {
        return smartfon;
    }

    public Integer getIloscSmartfonow() {
        return iloscSmartfonow;
    }
    public double obliczCeneZamowienia() {
        double suma = 0;
        if (telefon != null) {
            suma += telefon.getCena() * iloscTelefonow;
        }
        if (smartfon != null) {
            suma += smartfon.getCena() * iloscSmartfonow;
        }
        return suma;
    }

    public void wyswietlZamowienie() {
        System.out.println("Zamówienie:");

        if (telefon != null) {
            System.out.println(telefon.WyswietlTelefon());
            System.out.println("Ilość: " + iloscTelefonow);
        }

        if (smartfon != null) {
            System.out.println(smartfon.WyswietlSmartfon());
            System.out.println("Ilość: " + iloscSmartfonow);
        }

        System.out.println("Cena zamówienia: " + obliczCeneZamowienia());
    }
}
