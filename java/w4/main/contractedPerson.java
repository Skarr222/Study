package w4.main;

public abstract class contractedPerson extends person {
    public contractedPerson(String name, String surrName) {
        super(name, surrName);
    }

    public abstract double paymentValue();
}
