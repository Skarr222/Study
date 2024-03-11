package w6.main;

public class BazaDanych {

    private Towary zbiorTowarow;
//* private Samochody zbiorSamochodow;
//* private Pracownicy zbiorPracownikow;
//* inne kolekcje....
   public BazaDanych() {
       zbiorTowarow = new Towary("Towary", "Towary", 0);
        //* inne kolekcje....
   }
   public Towary getZbiorTowarow() {
       return zbiorTowarow;
   }
}
