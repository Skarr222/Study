package w3.main;

public class person {
    protected String name;
    protected String surrName;

    public person(String name, String surrName) {
        this.name = name;
        this.surrName = surrName;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("surrName: " + surrName);

    }
}
