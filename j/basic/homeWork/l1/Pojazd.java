package homeWork.l1;

public class Pojazd {
    private String typPojazdu, nrRejestracyjny;

    public Pojazd(String typPojazdu, String nrRejestracyjny) {
        this.typPojazdu = typPojazdu;
        this.nrRejestracyjny = nrRejestracyjny;
    }
    public String getTypPojazdu() {
        return typPojazdu;
    }
    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    public void wyswietlPojazd() {
        System.out.println("Pojazd:" + getTypPojazdu());
        System.out.println("O numerze rejestracyjnym: " + getNrRejestracyjny());
    }
}
