package main;

public class index {
    public static void main(String[] args) {
        System.out.println("Wykład 1");
        worker w1 = new worker("Adam1", "Tomczyk1", 1);
        w1.print();
        worker w2 = new worker("Adam2", "Tomczyk2");
        w2.print();
        worker w3 = new worker();
        w3.print();
    }
}