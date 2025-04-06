
//*Jeżeli klasa zawiera co najmniej jedną metodę abstrakcyjną, to musi być abstrakcyjna */
public abstract class project implements iObjectContract  {
    private final String title;
    private final String description;
    protected double additionalCosts;

    public project(String title, String description, double additionalCosts) {
        this.title = title;
        this.description = description;
        this.additionalCosts = additionalCosts;
    }

    public void data() {
        System.out.println("Tytuł: " + title);
        System.out.println("Opis: " + description);
        System.out.println("Koszty dodatkowe: " + additionalCosts);

    }

    // Funkcja abstrakcyjna to taka, że ma abstract z przodu i nie ma bloku.
    // Jak nie wiemy, jak napisać daną funkcję w klasie, w której jesteśmy, a wiemy,
    // jak w klasie dziedziczącej to warto w tej pierwszej klasie zrobić ją
    // abstrakcyjną
    public abstract double calculate();

}
