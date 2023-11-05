package w5.main;

public class index {

    public static void main(String[] args) {

        System.out.println("Wykład 5");

        contract contract = new contract();

        auditProject ap = new auditProject("P1", "O1", 100, 1, 0);
        contract.printContract(ap);

        softwareProject sp = new softwareProject("P2", "O2", 250, 2, 2, 2, 2, 2);
        contract.printContract(sp);

        softwareHelpDeskProject hd = new softwareHelpDeskProject("P3", "O3", 250, 2, 2, 2, 2, 2, 3);
        contract.printContract(hd);
    }

}