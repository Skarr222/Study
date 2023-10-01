package w1.main;

public class index {

    public void main(String[] args) { // * String[] args allows to pass arguments throughht console

        System.out.println("Wykład 1-2");

        worker worker = new worker("Oskar", "Gomza", 1, new account("Alior Bank", "98435789258792370348734"));
        worker.print();
    }
}