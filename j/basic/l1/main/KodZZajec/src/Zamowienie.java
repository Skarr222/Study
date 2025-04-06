package l1.main.KodZZajec.src;
public class Zamowienie {
    private final String numerZamowienia;
    private double wartoscZamowienia;
    private  Towar[] listaTowarow;
    private Klient klient;

    public Zamowienie(String numerZamowienia,  Klient klient ){
        this.numerZamowienia = numerZamowienia;
        this.klient = klient;
        //w konstruktorze nadajemy wartości początkowe listy towarów oraz wartości zamówienia
        listaTowarow = new Towar[100];
        wartoscZamowienia = 0;
    }
    public String  getNumerZamowienia() {
        return numerZamowienia;
    }
    // ! Nie można ustawić numeru zamówienia ponieważ jest on final
    // *  public void setNumerZamowienia(String numer) {
    // *      numerZamowienia = numer;
    // *  }

    public double getWartoscZamowienia() {
        return wartoscZamowienia;
    }

    public void getListaTowarow() {
        for(int i=0;i<listaTowarow.length;i++){
            //! Jest to katastroficzne rozwiązanie, jest ono tymczasowe. Poprawimy je
            if(listaTowarow[i] != null){
                listaTowarow[i].wyswietlTowar();
            }
        }
    }
    public void setListaTowarow(Towar[] towary) {
        this.listaTowarow = towary;
    }

    public void getKlient() {
         klient.wyswietlKlienta();
    }

    public void setKlient(Klient k) {
        this.klient = k;
    }

    public void dodajTowarDoZamowienia(int index, Towar t) {
        if (index >= 0 && index < listaTowarow.length) { /* podając wartość indexu w parametrze musi zabezpieczyć się
            przed niepożądanym wyjściem poza rozmiar tablicy. Tworzymy warunek za pomocą operatora logicznego AND czyli &&, obydwa warunki muszą byc spełnione */
            this.listaTowarow[index] = t; // przypisujemy wartość pod wskazany indeks tablicy
            this.wartoscZamowienia += t.getCena() * t.getIlosc(); // każdorazowo aktualizujemy łączną kwotę zamówienia po dodaniu towaru.
        }
    }

    public void wyswietlZamowienie() {
        System.out.println("=======Dane zamowienia=======");
        System.out.println("Numer zamowienia: " + getNumerZamowienia() );
        System.out.println("Wartosc zamowienia: " + getWartoscZamowienia() +"zł" );
        getKlient();
        System.out.println("Towary: ");
        getListaTowarow();
        System.out.println("\n");
    }
}
