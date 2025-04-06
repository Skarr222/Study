package w7.main;

public class Pacjent extends Osoba{
    private String nrKartyPacjenta;

    public Pacjent(String imie, String nazwisko, String nrKartyPacjenta) {
        super(imie, nazwisko);
        this.nrKartyPacjenta = nrKartyPacjenta;
    }

    public String getNrKartyPacjenta() {
        return nrKartyPacjenta;
    }

}
