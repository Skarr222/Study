package w5.main;

public class contract {
    public void printContract(project p) {
        System.out.println();
        System.out.println("---Umowa---");
        System.out.println("Dane projektu");
        p.projectData();
        System.out.println("Kwota za realizacje: " + p.calculate());

    }
}
