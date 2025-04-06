package l2.main;

public class Uzytkownik extends Osoba {
    private final String idUzytkownika;
    private String dataRejestracji, opis;
    private int iloscOpinii;
    private Opinia[] listaOpinii;

    public Uzytkownik(String idUzytkownika, String dataRejestracji, String opis, Osoba osoba, Opinia opinia) {
        super(osoba.getImie(), osoba.getNazwisko(), osoba.getDataUrodzenia() , osoba.getAdresZamieszkania());
        this.idUzytkownika = idUzytkownika;
        this.dataRejestracji = dataRejestracji;
        this.opis = opis;
        this.iloscOpinii = 0;
        this.listaOpinii = new Opinia[10];
        this.zwiekszHistorieWystawionychOpinii(iloscOpinii, opinia);
    }
    public String getIdUzytkownika() {
        return idUzytkownika;
    }

    public String getDataRejestracji() {
        return dataRejestracji;
    }

    public String getOpis() {
        return opis;
    }

    public void zwiekszHistorieWystawionychOpinii(int indeks, Opinia opinia) {
        if (indeks >= 0 && indeks < listaOpinii.length) {
            listaOpinii[indeks] = opinia;
            iloscOpinii++;
        } else {
            System.out.println("Błędny indeks opinii.");
        }
    }

    public void wyswietlWszystkieOpinie(){
        for (int i = 0; i < listaOpinii.length; i++) {
            if(listaOpinii[i] != null){
                listaOpinii[i].wyswietlOpinie();
            }
        }
    }

    public void wyswietlUzytkownika(){
        System.out.println("--------------Dane Osobowe--------------");
        super.wyswietlOsobe();
        System.out.println("--------------Dane Użytkownika--------------");
        System.out.println("ID użytkownika: " + idUzytkownika);
        System.out.println("Data rejestracji: " + dataRejestracji);
        System.out.println("Opis: " + opis);
    }

}
