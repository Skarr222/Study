package kol2.main;

//* Używam klasy abstrakcyjnej ponieważ jest to klasa bazowa dla innych klas,
//* wymogiem biznesowym jest to, że mogą istnieć różne typy pokoi hotelowych, które będą miały różne cechy,
//* ale będą miały wspólne cechy, które mogą być zdefiniowane w klasie bazowej.
public abstract class HotelRoom implements HotelServices  {
    private int roomNumber;
    private int capacity;
    private double pricePerNight;

    private int numberOfBeds;
    private boolean isReserved;

    public HotelRoom(int roomNumber, int capacity, double pricePerNight, int numberOfBeds, boolean isReserved) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.numberOfBeds = numberOfBeds;
        this.isReserved = isReserved;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public void reserveRoom(Guest guest, int roomNumber) {
        if (isReserved) {
            System.out.println("Pokój jest zarezerwowany");
        } else {
            System.out.println("Pokój został zarezerwowany przez ");
            System.out.println("Numer pokoju: " + roomNumber);
            guest.displayInfo();
            isReserved = true;
        }
    }
    public void cancelReservation() {
        if (isReserved) {
            isReserved = false;
        } else {
            System.out.println("Pokój nie jest zarezerwowany");
        }
    }
    public void checkOut(int roomNumber) {
        if (isReserved) {
            System.out.println("Gość wymeldował się z pokoju " + roomNumber);
            isReserved = false;
        } else {
            System.out.println("Pokój nie jest zarezerwowany");
        }

    }

    public void checkAvailability(boolean isReserved) {
        if (this.isReserved == isReserved) {
            System.out.println("Pokój " + roomNumber + " jest " + (isReserved ? "zarezerwowany" : "dostępny"));
        }
    }

    public void cancelReservation(int roomNumber) {
        if (this.roomNumber == roomNumber) {
            if (isReserved) {
                System.out.println("Rezerwacja pokoju" + roomNumber + " została anulowana.");
                isReserved = false;
            } else {
                System.out.println("Pokój " + roomNumber + "jest dostępny");
            }
        } else {
            System.out.println("Pokój " + roomNumber + " nie istnieje.");
        }
    }


}
