package w4.main;

public class index {

    public static void main(String[] args) {

        System.out.println("Wykład 4");
        accounting accounting = new accounting();

        familyDoctor fd = new familyDoctor("Adam", "Rodzinny", 100);
        accounting.printTransferOrder(fd);

        specialistDoctor sd = new specialistDoctor("Adam", "Specjalista", 100);
        accounting.printTransferOrder(sd);

    }

}