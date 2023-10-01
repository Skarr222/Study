
package w3.main;

public class worker extends person {
    private Integer id;

    public worker(String name, String surrName, Integer id) {
        super(name, surrName); // * call the person constructor
        this.id = id;
    }

    public void print() {
        System.out.println("Dane podstawowe pracownika");

        System.out.println("id: " + id);
        super.print();

    }

}