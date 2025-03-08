package l1.main.KodZZajec.src;
public class Klient extends Osoba {
    private String numerKlienta;
    private String typPlatnosci;
    private String[] historiaZamowien; //tutaj przechowujemy listę wszystkich złożonych dotychczas zamówień, a dokładniej numery zamówień

    public Klient(String imie, String nazwisko, Adres adres, String numerKlienta, String typPlatnosci) {
        super(imie, nazwisko, adres);
        this.numerKlienta = numerKlienta;
        this.typPlatnosci = typPlatnosci;
        this.historiaZamowien = new String[100]; // inicjalizujemy wartość początkową historii zamówień

    }

    public String getNumerKlienta() {
        return numerKlienta;
    }

    public String getTypPlatnosci() {
        return typPlatnosci;
    }

    public void getHistoriaZamowien() {

        for(int i=0;i<historiaZamowien.length;i++) {
            //! Jest to katastroficzne rozwiązanie, jest ono tymczasowe. Poprawimy je jak poznamy kolekcje
            if (historiaZamowien[i] != null) {
                System.out.println("Zamówienie nr:" + historiaZamowien[i] + "\n");
            }
        }
    }

    public void wyswietlKlienta() {
        System.out.println("=======Dane klienta: =======");
        super.wyswietlOsobe();
        System.out.println("Numer klienta: " + getNumerKlienta() );
        System.out.println("Typ platnosci: " + getTypPlatnosci() );
        System.out.println("Historia zamowien: ");
        getHistoriaZamowien();
    }


}
