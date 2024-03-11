package kol1;

import l1.main.Ksiegowosc;

import java.util.ArrayList;

class SklepTelefon {
    private ArrayList<Telefon> produkty;

    public SklepTelefon() {
        this.produkty = new ArrayList<>();
    }

    public void dodajProdukt(Telefon telefon) {
        produkty.add(telefon);
    }

    public void wyswietlProdukty() {
        for (Telefon telefon : produkty) {
            System.out.println(telefon.WyswietlTelefon());
        }
    }

}
