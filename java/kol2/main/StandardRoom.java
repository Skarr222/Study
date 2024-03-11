package kol2.main;

public class StandardRoom extends HotelRoom{
private boolean hasBalcony;
    private boolean hasSeaView;

    public StandardRoom(int roomNumber, int capacity, double pricePerNight, int numberOfBeds, boolean isReserved, boolean hasBalcony, boolean hasSeaView) {
        super(roomNumber, capacity, pricePerNight, numberOfBeds, isReserved);
        this.hasBalcony = hasBalcony;
        this.hasSeaView = hasSeaView;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public boolean isHasSeaView() {
        return hasSeaView;
    }

    @Override
    public void checkAvailability() {
        // Implementacja metody checkAvailability dla StandardRoom
        if (this.isReserved()) {
            System.out.println("StandardRoom " + getRoomNumber() + " jest zarezerwowany.");
        } else {
            System.out.println("StandardRoom " + getRoomNumber() + " jest dostępny.");
        }
    }

}
