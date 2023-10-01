package main;

public class index {
    public static void main(String[] args) { // * String[] args pozwala podać do maina argumenty z poziomu konsoli
        System.out.println("Wykład 1-2");

        account account1 = new account("Alior Bank", "98435789258792370348734");
        account1.print();

        worker worker1 = new worker("Adam1", "Tomczyk1", 1, account1);
        worker1.print();
    }
}