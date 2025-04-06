package homeWork.l2;

public class Wizyta {
    private String data;
    private String godzina;
    private String lekarz;
    private String pacjent;

    public Wizyta(String data, String godzina, String lekarz, String pacjent) {
        this.data = data;
        this.godzina = godzina;
        this.lekarz = lekarz;
        this.pacjent = pacjent;
    }

    public void wyswietlWizyte() {
        System.out.println("Data wizyty: " + data);
        System.out.println("Godzina wizyty: " + godzina);
        System.out.println("Lekarz: " + lekarz);
        System.out.println("Pacjent: " + pacjent);
    }
}
