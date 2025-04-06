package homeWork.l3.Main;

public abstract class Pojazd implements PojazdOperacje {
    int speed;

    public Pojazd(int speed) {
        this.speed = speed;
    }
    @Override
    public void accelerate() {
        speed += 10;
        System.out.println("Pojazd przyśpiesza. Obecna prędkość: " + speed);
    }

    @Override
    public void brake() {
        speed -= 5;
        System.out.println("Pojazd hamuje. Obecna prędkość: " + speed);
    }
}
