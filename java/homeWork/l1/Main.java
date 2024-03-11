package homeWork.l1;
public class Main {
    public static void main(String[] args) {
        // Zadanie 1
        System.out.println("----------------Przed Obniżką----------------");
        Silnik silnik = new Silnik("Diesel", 300, 1.9);
        Samochod samochod = new Samochod("BMW", "E46", 2001, 10000, "Samochód", "DW 12345", 0, silnik);
        samochod.wyswietlSamochod();
        System.out.println();
        // Zadanie 2
        System.out.println("----------------Po Obniżce----------------");
        samochod.ustawObnizke(0.1);
        samochod.wyswietlSamochod();
    }
}
