package w7.main;

//* Klasa prodcedura medyczna działa na pewnym typie T w którym będzie podstawiany typ wykonawcy
public class ProceduraMedyczna<T> {
    private T wykonawca;
    private Pacjent pacjent;
    public ProceduraMedyczna(T wykonawca, Pacjent pacjent) {
        this.wykonawca = wykonawca;
        this.pacjent = pacjent;
    }
    public T getWykonawca() {
        return wykonawca;
    }
    public Pacjent getPacjent() {
        return pacjent;
    }
}
