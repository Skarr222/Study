package w2.main;

public class index {

    public static void main(String[] args) { // * String[] args allows to pass arguments throughht console

        System.out.println("Wykład 1-2");

        worker worker1 = new worker("Oskar", "Gomza", 1);
        worker1.print();

        System.out.println("Liczba pracowników wynosi: " + worker.getNumberOfAddedWorkers());

    }

}