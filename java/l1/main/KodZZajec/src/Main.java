package l1.main.KodZZajec.src;


public class Main {
    public static void main(String[] args) {
        System.out.println("Laboratorium 1");
        Towar t1 = new Towar("Mleko", "A1", "Mleko bez laktozy ", 2.5, 100 );
        Towar t2 = new Towar("Kakao", "A2", "Deco Moreno", 4.56, 10 );
        System.out.println("==================================");
        //tworzymy obiekt typu Adres, który przekażemy w konstruktorze Klienta
        Adres a1 = new Adres("Polska", "Warszawa", "00-001");
        Klient k1 = new Klient("Jan", "Kowalski", a1, "Klient1", "Blik");
        k1.wyswietlKlienta();
        System.out.println("==================================");
        Klient k2 = new Klient("Andrzej", "Kowalski", a1, "Klient2", "Karta");
        k2.wyswietlKlienta();
        System.out.println("==================================");
        Zamowienie z1 = new Zamowienie("ZAM/1/11/23", k1);
        z1.dodajTowarDoZamowienia(0, t1);
        z1.dodajTowarDoZamowienia(1, t2);
        z1.wyswietlZamowienie();
        System.out.println("==================================");
    }
}
