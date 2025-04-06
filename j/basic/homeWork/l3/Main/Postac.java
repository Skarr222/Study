package homeWork.l3.Main;

public class Postac implements PostacOperacje {
    String name;

    public Postac(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " Porusza się.");
    }

    @Override
    public void attack() {
        System.out.println(name + " Atakuje.");
    }
}
