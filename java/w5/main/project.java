package w5.main;

//*Jeżeli klasa zawiera conajmniej jedną metode abstrakcyjną to musi być abstrakcyjna */
public abstract class project {
    private String title, description;
    protected double additionalCosts;

    public project(String title, String description, double additionalCosts) {
        this.title = title;
        this.description = description;
        this.additionalCosts = additionalCosts;
    }

    public void projectData() {
        System.out.println("Tytuł: " + title);
        System.out.println("Opis: " + description);
        System.out.println("Koszty dodatkowe: " + additionalCosts);

    }
    // * Funkcja abstrakcyjna to taka że ma abstract z przodu i nie ma bloku
    // * Jak nie wiemy jak napisać daną funkcje w klasie w której jesteśmy a wiemy
    // * jak w klasie dziedziczącej to warto w tej pierwszej klasie zrobić ją
    // * abstrakcyjną

    public abstract double calculate();

}
