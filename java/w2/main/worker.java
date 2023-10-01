
package w2.main;

public class worker {
    private String name, surrName;
    private Integer id;
    private static Integer numberOfAddedWorkers = 0;

    static {
        numberOfAddedWorkers = 0;
    }

    public static int getNumberOfAddedWorkers() {
        return numberOfAddedWorkers;
    }

    public worker(String name, String surrName, Integer id) {
        this.name = name;
        this.surrName = surrName;
        this.id = id;
        numberOfAddedWorkers++;
    }

    public void print() {
        System.out.println("Dane podstawowe pracownika");

        System.out.println("id: " + id);
        System.out.println("Name: " + name);
        System.out.println("surrName: " + surrName);

    }

}