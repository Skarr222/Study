package w6.main;

public class Main {
public static void main(String[] args) {
        System.out.println("Wykład 6 - Main");
        System.out.println("Przykład listy");
        Firma firma = new Firma("Firma");
        Towar t1 = new Towar("1", "Towar 1", 1);
        firma.getDb().getZbiorTowarow().getListaTowarow().add(t1);
        Towar t2 = new Towar("2", "Towar 2", 2);
        firma.getDb().getZbiorTowarow().getListaTowarow().add(t2);
        Towar t3 = new Towar("3", "Towar 3", 3);
        firma.getDb().getZbiorTowarow().getListaTowarow().add(t3);
        firma.getDb().getZbiorTowarow().DrukujTowary();
    }
}
