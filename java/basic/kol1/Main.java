package kol1;

public class Main {
    public static void main(String[] args) {
        SklepTelefon sklepTelefon = new SklepTelefon();
        Telefon telefon = new Telefon(100.0, "Galaxy S21", "Samsung");
        Smartfon smartfon = new Smartfon(200.0, "Redmi", "Xiaomi", "android", 4000);
        sklepTelefon.dodajProdukt(telefon);
        sklepTelefon.dodajProdukt(smartfon);
        sklepTelefon.wyswietlProdukty();
        Zamowienie zamowienie = new Zamowienie(telefon, 2, smartfon, 3);
        zamowienie.wyswietlZamowienie();
    }
}
