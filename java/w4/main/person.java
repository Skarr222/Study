package w4.main;

public class person {
    private String name;
    private String surrName;

    public person(String name, String surrName) {
        this.name = name;
        this.surrName = surrName;
    }

    public void print() {
        System.out.println(name + surrName);

    }
}
