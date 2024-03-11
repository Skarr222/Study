package homeWork.l2;

public class Main {
    public static void main(String[] args) {
        PrzychodniaLekarska przychodnia = new PrzychodniaLekarska();

        Lekarz lekarz1 = new Lekarz("Jan", "Kowalski", "12345678901", "ul. Słoneczna 1", "L001", "Lekarz", "Pediatra", 12345);
        Lekarz lekarz2 = new Lekarz("Anna", "Nowak", "23456789012", "ul. Zielona 2", "L002", "Lekarz", "Internista", 54321);
        przychodnia.dodajLekarza(lekarz1);
        przychodnia.dodajLekarza(lekarz2);

        Pacjent pacjent1 = new Pacjent("Adam", "Nowak", "34567890123", "ul. Kwiatowa 3", "P001");
        Pacjent pacjent2 = new Pacjent("Ewa", "Kowalska", "45678901234", "ul. Górska 4", "P002");
        przychodnia.dodajPacjenta(pacjent1);
        przychodnia.dodajPacjenta(pacjent2);

        Wizyta wizyta1 = new Wizyta("2024-01-28", "10:00", lekarz1.getImie() + " " + lekarz1.getNazwisko(), pacjent1.getImie() + " " + pacjent1.getNazwisko());
        Wizyta wizyta2 = new Wizyta("2024-01-29", "11:00", lekarz2.getImie() + " " + lekarz2.getNazwisko(), pacjent2.getImie() + " " + pacjent2.getNazwisko());
        przychodnia.dodajWizyte(wizyta1);
        przychodnia.dodajWizyte(wizyta2);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Lista pacjentów:");
        System.out.println("-----------------------------------------------------------------");
        przychodnia.wyswietlPacjenta(pacjent1);
        System.out.println("-----------------------------------------------------------------");

        przychodnia.wyswietlPacjenta(pacjent2);

        System.out.println("-----------------------------------------------------------------");
        przychodnia.wyszukajWizyty();
    }
}
