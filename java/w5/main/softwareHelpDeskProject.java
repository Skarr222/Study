
public class softwareHelpDeskProject extends softwareProject {
    private final double hoursOfHelpdesk;

    public softwareHelpDeskProject(String title, String description, double additionalCosts,
            double numberPersonMonthJuniorProgramist,
            double numberPersonMonthMidProgramist, double numberPersonMonthSeniorProgramist,
            double numberPersonMonthTesters, double numberPersonMonthDesigner, double hoursOfHelpdesk) {
        super(title, description, additionalCosts,
                numberPersonMonthJuniorProgramist, numberPersonMonthMidProgramist, numberPersonMonthSeniorProgramist,
                numberPersonMonthTesters, numberPersonMonthDesigner);
        this.hoursOfHelpdesk = hoursOfHelpdesk;

    }

    public void data() {
        super.data();
        System.out.println("Liczba godzin helpdesku: " + hoursOfHelpdesk);

    }

    public double calculate() {
        buissnesExpenses buissnesExpenses = new buissnesExpenses();
        return super.calculate() + hoursOfHelpdesk * buissnesExpenses.getAveragePaymentHelpDesk();

    }
}
