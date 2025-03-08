package w1.main;

public class account {
    private String bankName;
    private String number;

    public account(String bankName, String number) {
        this.bankName = bankName;
        this.number = number;
    }

    public void print() {
        System.out.println("Nazwa banku: " + bankName);
        System.out.println("Numer konta: " + number);
    }
}
