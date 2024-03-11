package homeWork.l3.Main;

class Samochod extends Pojazd {
    public Samochod(int speed) {
        super(speed);
    }

    public void honk() {
        System.out.println("Samochód trąbi.");
    }
}