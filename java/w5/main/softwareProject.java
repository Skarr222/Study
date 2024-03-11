
public class softwareProject extends project {
    private final double numberPersonMonthJuniorPrograming, numberPersonMonthMidPrograming,
            numberPersonMonthSeniorPrograming,
            numberPersonMonthTesters, numberPersonMonthDesigner;

    public softwareProject(String title, String description, double additionalCosts,
            double numberPersonMonthJuniorPrograming,
            double numberPersonMonthMidPrograming, double numberPersonMonthSeniorPrograming,
            double numberPersonMonthTesters, double numberPersonMonthDesigner) {
        super(title, description, additionalCosts);
        this.numberPersonMonthJuniorPrograming = numberPersonMonthJuniorPrograming;
        this.numberPersonMonthMidPrograming = numberPersonMonthMidPrograming;
        this.numberPersonMonthSeniorPrograming = numberPersonMonthSeniorPrograming;
        this.numberPersonMonthTesters = numberPersonMonthTesters;
        this.numberPersonMonthDesigner = numberPersonMonthDesigner;

    }

    public void projectData() {
        super.projectData();
        System.out.println("Liczba Osobo-Miesięcy Młodszych Programistów: " + numberPersonMonthJuniorPrograming);
        System.out.println("Liczba Osobo-Miesięcy Programistów: " + numberPersonMonthMidPrograming);
        System.out.println("Liczba Osobo-Miesięcy Starszych Programistów: " + numberPersonMonthSeniorPrograming);
        System.out.println("Liczba Osobo-Miesięcy Projektantów: " + numberPersonMonthTesters);
        System.out.println("Liczba Osobo-Miesięcy Testerów: " + numberPersonMonthDesigner);

    }

    public double calculate() {
        buissnesExpenses buissnesExpenses = new buissnesExpenses();
        return this.numberPersonMonthJuniorPrograming * buissnesExpenses.getAveragePaymentJuniorProgrammer()
                + this.numberPersonMonthMidPrograming * buissnesExpenses.getAveragePaymentProgrammer()
                + this.numberPersonMonthSeniorPrograming * buissnesExpenses.getAveragePaymentSeniorProgrammer()
                + this.numberPersonMonthTesters * buissnesExpenses.getAveragePaymentTester()
                + this.numberPersonMonthDesigner * buissnesExpenses.getAveragePaymentDesigner()
                + this.additionalCosts;
    }
}
