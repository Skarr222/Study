package w5.main;

public class auditProject extends project {
    private final double numberPersonMonthSpecialist;
    private final double numberPersonMonthOlderSpecialist;

    public auditProject(String title, String description, double additionalCosts, double numberPersonMonthSpecialist,
            double numberPersonMonthOlderSpecialist) {
        super(title, description, additionalCosts);
        this.numberPersonMonthSpecialist = numberPersonMonthSpecialist;
        this.numberPersonMonthOlderSpecialist = numberPersonMonthOlderSpecialist;
    }

    public void data() {
        super.data();
        System.out.println("Liczba Osobo-Miesięcy Specjalisty: " + numberPersonMonthSpecialist);
        System.out.println("Liczba Osobo-Miesięcy Starszego Specjalisty: " + numberPersonMonthOlderSpecialist);

    }

    public double calculate() {
        return this.numberPersonMonthSpecialist * new buissnesExpenses().getAveragePaymentSpecialist()
                + this.numberPersonMonthOlderSpecialist * new buissnesExpenses().getAveragePaymentOlderSpecialist()
                + this.additionalCosts;
    }
}
