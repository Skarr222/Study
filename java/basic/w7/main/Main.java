package w7.main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Przykład typu generycznego");

        Pacjent p1 = new Pacjent("Jan", "Kowalski", "123");
        Pacjent p2 = new Pacjent("Tomek", "Nowak", "456");

        RatownikMedyczny r1 = new RatownikMedyczny("Adam", "Nowak", "123");
        RatownikMedyczny r2 = new RatownikMedyczny("Ewa", "Kowalska", "456");

        Lekarz l1 = new Lekarz("Jan", "Kowalski", "Kardiolog");
        Lekarz l2 = new Lekarz("Anna", "Nowak", "Dermatolog");

        //* Tu typem T z ProceduraMedyczna jest Lekarz
        ProceduraMedyczna<Lekarz> pm1 = new ProceduraMedyczna<Lekarz>(l1, p1);

        //* Tu typem T z ProceduraMedyczna jest RatownikMedyczny
        ProceduraMedyczna<RatownikMedyczny> pm2 = new ProceduraMedyczna<RatownikMedyczny>(r1, p2);


        Zbior<Lekarz> zbiorLekarzy = new Zbior<Lekarz>();
        zbiorLekarzy.getLista().add(l1);
        zbiorLekarzy.getLista().add(l2);
        Zbior<Pacjent> zbiorPacjentow = new Zbior<Pacjent>();
        zbiorPacjentow.getLista().add(p1);
        zbiorPacjentow.getLista().add(p2);
        Zbior<RatownikMedyczny> zbiorRatownikow = new Zbior<RatownikMedyczny>();
        zbiorRatownikow.getLista().add(r1);
        zbiorRatownikow.getLista().add(r2);

        System.out.println("====================================");
        System.out.println("Zbiór lekarzy: ");
        System.out.println("====================================");
        for (Lekarz l : zbiorLekarzy.getLista()) {
            System.out.println(l.getImie() + " " + l.getNazwisko() + " " + l.getSpecjalizacja());
        }

        System.out.println("====================================");
        System.out.println("Zbiór pacjentów: ");
        System.out.println("====================================");
        for (Pacjent p : zbiorPacjentow.getLista()) {
            System.out.println(p.getImie() + " " + p.getNazwisko() + " " + p.getNrKartyPacjenta());
        }

        System.out.println("====================================");
        System.out.println("Zbiór ratowników: ");
        System.out.println("====================================");
        for (RatownikMedyczny r : zbiorRatownikow.getLista()) {
            System.out.println(r.getImie() + " " + r.getNazwisko() + " " + r.getOpisUprawnien());
        }
    }
}
