
public class contract {
    public void printContract(iObjectContract p) {
        System.out.println();
        System.out.println("---Umowa---");
        System.out.println("Dane");
        p.data();
        System.out.println("Kwota za realizacje: " + p.calculate());

    }
}
