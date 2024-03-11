package l1.main;
import java.util.ArrayList;
import java.util.List;
/*
* To jest klasa abstrakcyjna, będąca bazą dla klas typu tabela z zamówieniami, tabela z klientami itp.
* Klasa ta może, choć nie musi posiadać metod abstrakcyjnych oraz może choć nie musi nadpisywać metod z implementowanego interfejsu
* Dostarcza ona ogólne implementacje operacji bazodanowych i może zawierać dodatkowe metody lub logikę, która jest wspólna dla różnych rodzajów tabel.
*/
public abstract class Tabela<T> implements BazaDanychOperacje<T> {

    private String nazwaTabeli; // *nazwa tabeli w bazie danych
    protected List<T> listaObiektow; // *tutaj będziemy zapisywać obiekty, usuwać je lub wyświetlać.

    public Tabela(String nazwaTabeli ) {
        this.nazwaTabeli = "Tabela";
        this.listaObiektow = new ArrayList<>();
    }

    @Override //* dopisujemy adnotację Override w celu poinformowania kompilatora, że
    //* nadpisujemy metodę z implementowanego interfejsu. W celu nadpisania metody musimy podać jej dokładny typ, nazwę oraz ilość parametrów z interfejsu
    public void zapiszDoTabeli(T obiekt){
        System.out.println("Zapisywanie danych do tabeli " + obiekt.getClass().getName() + "...");
        listaObiektow.add(obiekt);
    }

    @Override
    public void usunZTabeli(T obiekt){
        System.out.println("Usuwanie danych z tabeli ...");
        listaObiektow.remove(obiekt);
    }

    @Override
    public void wyswietlDaneNaKonsoliZTabeli(){
        System.out.println("Wyświetlanie danych z tabeli ...");
    }


}

