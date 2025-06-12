package j.advanced.l3;

public class Towary {
    String nazwa;
    double cena;

    public Towary(String nazwa,double cena){
        this.nazwa = nazwa;
        this.cena = cena;
    }
    protected String getNazwa(){
        return this.nazwa;
    }

    protected double getCena(){
        return this.cena;
    }
}
