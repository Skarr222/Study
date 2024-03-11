package w7.main;

import java.util.ArrayList;
import java.util.List;

//* Nasz zbiór działa na typie generycznym T będzie mógł przechowywać różne typy danych
public class Zbior <T>{
    private List<T> lista;

    public Zbior() {
        lista = new ArrayList<T>();
    }
    public List<T> getLista() {
        return lista;
    }

}
