package homeWork.l1;

public class Silnik {
    private String typSilnika ;
    private double pojemnoscSilnika, mocSilnika;

    public Silnik(String typSilnika, double mocSilnika, double pojemnoscSilnika) {
        this.typSilnika = typSilnika;
        this.mocSilnika = mocSilnika;
        this.pojemnoscSilnika = pojemnoscSilnika;
    }
    public String getTypSilnika() {
        return typSilnika;
    }
    public double getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }
    public double getMocSilnika() {
        return mocSilnika;
    }

    public double obliczMocSilnika() {
        return getMocSilnika() * 0.73549875;
    }

    public double obliczEfektywnoscSilnika() {
        return obliczMocSilnika() / getPojemnoscSilnika();
    }

    public void wyswietlSilnik() {
        System.out.println("Typ silnika: " + getTypSilnika());
        System.out.println("Pojemność silnika: " + getPojemnoscSilnika());
        System.out.println("Moc silnika: " + obliczMocSilnika());
        System.out.println("Efektywność silnika: " + obliczEfektywnoscSilnika());
    }
}
