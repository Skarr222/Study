package homeWork.l3.Main;


    public class Main {
        public static void main(String[] args) {
            Samochod car = new Samochod(0);

            car.accelerate(); // Przyspieszenie
            car.brake();      // Hamowanie

            car.honk();       // Trąbienie

            Postac player = new Postac("Gracz");

            player.move();    // Poruszanie się
            player.attack();  // Atakowanie
        }
    }
