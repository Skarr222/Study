package w4.main;

public class familyDoctor extends contractedPerson {
    private double numberOfSavedPatients;

    public familyDoctor(String name, String surrName, double numberOfSavedPatients) {
        super(name, surrName); // call to person class constructor to read name and surrName of a doctor
        this.numberOfSavedPatients = numberOfSavedPatients;
    }

    public void print() {
        super.print(); // call to person class to use print method
        System.out.println("Liczba zapisanych pacjentów:" + numberOfSavedPatients);
    }

    public double paymentValue() {
        return this.numberOfSavedPatients * new financeParameters().GetValueOfPatient();
    }
}
