package w4.main;
//* jeżeli osoba implementuje interfaceContractedObiect to żeby 

//* nie była abstrakcyjna musi mieć zrealizowane wszytkie metody z interfejsu

public abstract class person {
    private String name;
    private String surrName;

    public person(String name, String surrName) {
        this.name = name;
        this.surrName = surrName;
    }

    public void print() {
        System.out.println(name + surrName);

    }

    public abstract double paymentValue();

    public void printTransferOrder() {
        System.out.println("Polecenie przelewu: ");
        System.out.println("Imie i Nazwisko: ");
        print();
        System.out.println("Kwota przelewu: " + paymentValue());
        System.out.println();
    }
}
