package homeWork.l2;

import java.util.ArrayList;
import java.util.List;

public class PrzychodniaLekarska extends Przychodnia {
    private List<Lekarz> lekarze;
    private List<Pacjent> pacjenci;
    private List<Wizyta> wizyty;

    public PrzychodniaLekarska() {
        lekarze = new ArrayList<>();
        pacjenci = new ArrayList<>();
        wizyty = new ArrayList<>();
    }

    public void dodajLekarza(Lekarz lekarz) {
        lekarze.add(lekarz);
    }
    public void dodajPacjenta(Pacjent pacjent) {
        pacjenci.add(pacjent);
    }
    public void usunPacjenta(Pacjent pacjent) {
        pacjenci.remove(pacjent);
    }
    public void wyswietlPacjenta(Pacjent pacjent) {
        pacjent.wyswietlPacjenta();
    }

    public void umowWizyte(Wizyta wizyta) {
        wizyty.add(wizyta);
    }

    public void dodajWizyte(Wizyta wizyta) {
        umowWizyte(wizyta);
    }

    public void usunWizyte(Wizyta wizyta) {
        wizyty.remove(wizyta);
    }

    public void wyszukajWizyty() {
        System.out.println("Lista wizyt:");
        System.out.println("-----------------------------------------------------------------");
        for (Wizyta wizyta : wizyty) {
            wizyta.wyswietlWizyte();
            System.out.println("-----------------------------------------------------------------");
        }
    }

}
