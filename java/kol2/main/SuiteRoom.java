package kol2.main;

public class SuiteRoom extends HotelRoom{
    private boolean hasJacuzzi;
    private boolean hasMiniBar;

    public SuiteRoom(int roomNumber, int capacity, double pricePerNight, int numberOfBeds, boolean isReserved, boolean hasJacuzzi, boolean hasMiniBar) {
        super(roomNumber, capacity, pricePerNight, numberOfBeds, isReserved);
        this.hasJacuzzi = hasJacuzzi;
        this.hasMiniBar = hasMiniBar;
    }

    public boolean isHasJacuzzi() {
        return hasJacuzzi;
    }

    public void setHasJacuzzi(boolean hasJacuzzi) {
        this.hasJacuzzi = hasJacuzzi;
    }

    public boolean isHasMiniBar() {
        return hasMiniBar;
    }

    public void setHasMiniBar(boolean hasMiniBar) {
        this.hasMiniBar = hasMiniBar;
    }
    @Override
    public void checkAvailability() {
        // Implementacja metody checkAvailability dla SuiteRoom
        if (this.isReserved()) {
            System.out.println("SuiteRoom " + getRoomNumber() + " jest zarezerwowany.");
        } else {
            System.out.println("SuiteRoom " + getRoomNumber() + " jest dostępny.");
        }
    }


}
