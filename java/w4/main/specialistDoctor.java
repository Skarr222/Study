
public class specialistDoctor extends person {
    private double numberOfAcceptedPatients;

    public specialistDoctor(String name, String SurrName, double numberOfAcceptedPatients) {
        super(name, SurrName);
        this.numberOfAcceptedPatients = numberOfAcceptedPatients;
    }

    public void print() {
        super.print();
        System.out.println("Liczba przyjętych pacjentów:" + this.numberOfAcceptedPatients);
    }

    public double paymentValue() {
        return this.numberOfAcceptedPatients * new financeParameters().GetValueOfSpecialistPatient();
    }
}
