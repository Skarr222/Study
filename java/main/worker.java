package main;

public class worker {
    private String name, surrName;
    private Integer id;

    public worker() {
        name = "Oskar";
        surrName = "Gomza";
        id = 1;
    }

    public worker(String name, String surrName, Integer id) {
        this.name = name;
        this.surrName = surrName;
        this.id = id;
    }

    public worker(String name, String surrName) {
        this.name = name;
        this.surrName = surrName;
        this.id = 1;
    }

    public void print() {
        System.out.println("id: " + id);
        System.out.println("Name: " + name);
        System.out.println("surrName: " + surrName);
    }

}