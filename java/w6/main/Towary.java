package w6.main;

import java.util.ArrayList;
import java.util.List;

//* Ta klasa będzie zawierała kolekcje obiektów klasy Towar
//* Użyjemy do przechowywania obiektów klasy Towar listy
public class Towary  extends Towar{

    private List<Towar> listaTowarow;
    {
        listaTowarow = new ArrayList<Towar>();
    }
    public Towary(String kod, String nazwa, float cena) {
        super(kod, nazwa, cena);
    }
    public void DodajTowar(Towar towar) {
        listaTowarow.add(towar);
    }
    public List<Towar> getListaTowarow() {
        return listaTowarow;
    }
    public void DrukujTowary() {
        for(int index = 0 ; index< listaTowarow.size() ; index++) {
            listaTowarow.get(index).DrukujTowar(); //* z listy pobieram obiekt Towar i wywołuję jego metodę DrukujTowar
        }
    }

}
