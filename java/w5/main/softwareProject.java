package w5.main;

public class softwareProject extends project {
    private double numberPersonMonthJuniorProgramist, numberPersonMonthMidProgramist, numberPersonMonthSeniorProgramist,
            numberPersonMonthTesters, numberPersonMonthDesigner;

    public softwareProject(String title, String description, double additionalCosts,
            double numberPersonMonthJuniorProgramist,
            double numberPersonMonthMidProgramist, double numberPersonMonthSeniorProgramist,
            double numberPersonMonthTesters, double numberPersonMonthDesigner) {
        super(title, description, additionalCosts);
        this.numberPersonMonthJuniorProgramist = numberPersonMonthJuniorProgramist;
        this.numberPersonMonthMidProgramist = numberPersonMonthMidProgramist;
        this.numberPersonMonthSeniorProgramist = numberPersonMonthSeniorProgramist;
        this.numberPersonMonthTesters = numberPersonMonthTesters;
        this.numberPersonMonthDesigner = numberPersonMonthDesigner;

    }

    public void projectData() {
        super.projectData();
        System.out.println("Liczba Osobo-Miesięcy Młodszych Programistów: " + numberPersonMonthJuniorProgramist);
        System.out.println("Liczba Osobo-Miesięcy Programistów: " + numberPersonMonthMidProgramist);
        System.out.println("Liczba Osobo-Miesięcy Starszych Programistów: " + numberPersonMonthSeniorProgramist);
        System.out.println("Liczba Osobo-Miesięcy Projektantów: " + numberPersonMonthTesters);
        System.out.println("Liczba Osobo-Miesięcy Testerów: " + numberPersonMonthDesigner);

    }

    public double calculate() {
        buissnesExpenses buissnesExpenses = new buissnesExpenses();
        return this.numberPersonMonthJuniorProgramist * buissnesExpenses.getAveragePaymentJuniorProgrammer()
                + this.numberPersonMonthMidProgramist * buissnesExpenses.getAveragePaymentProgrammer()
                + this.numberPersonMonthSeniorProgramist * buissnesExpenses.getAveragePaymentSeniorProgrammer()
                + this.numberPersonMonthTesters * buissnesExpenses.getAveragePaymentTester()
                + this.numberPersonMonthDesigner * buissnesExpenses.getAveragePaymentDesigner()
                + this.additionalCosts;
    }
}
