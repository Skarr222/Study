
public class accounting {
    public void printTransferOrder(interfaceContractedObject o) {
        System.out.println("Polecenie przelewu: ");
        System.out.println("Imie i Nazwisko: ");
        o.print();
        System.out.println("Kwota przelewu: " + o.paymentValue());
        System.out.println();
    }
}
