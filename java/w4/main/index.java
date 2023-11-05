package w4.main;

public class index {

    public static void main(String[] args) {

        System.out.println("Wykład 4");

        familyDoctor fd = new familyDoctor("Adam", "Rodzinny", 100);
        fd.printTransferOrder();

        specialistDoctor sd = new specialistDoctor("Adam", "Specjalista", 100);
        sd.printTransferOrder();

    }

}