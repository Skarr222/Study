package homeWork.l2;

public  class Pacjent extends Osoba {
    private String numerUbezpieczenia;

    public Pacjent(String imie, String nazwisko, String pesel, String adres, String numerUbezpieczenia) {
        super(imie, nazwisko, pesel, adres);
        this.numerUbezpieczenia = numerUbezpieczenia;
    }

    public void wyswietlPacjenta() {
        super.wyswietlOsobe();
        System.out.println("Numer ubezpieczenia: " + numerUbezpieczenia);
    }
}
