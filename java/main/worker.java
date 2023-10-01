package main;

public class worker {
    private String name, surrName;
    private Integer id;
    private account bankAccount;

    public worker(String name, String surrName, Integer id, account bankAccount) {
        this.name = name;
        this.surrName = surrName;
        this.id = id;
        this.bankAccount = bankAccount;
    }

    public void print() {
        System.out.println("id: " + id);
        System.out.println("Name: " + name);
        System.out.println("surrName: " + surrName);

        // ! print method from class account
        bankAccount.print();
    }

}