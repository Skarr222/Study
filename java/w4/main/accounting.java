package w4.main;

public class accounting {
    public void printTransferOrder(contractedPerson o) {
        System.out.println("Polecenie przelewu: ");
        System.out.println("Imie i Nazwisko: ");
        o.print();
        System.out.println("Kwota przelewu: " + o.paymentValue());
        System.out.println();
    }
}