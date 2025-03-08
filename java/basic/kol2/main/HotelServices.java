package kol2.main;


//* Używam interfejsu w celu określenia jak zarządzamy hotelem
public interface HotelServices {
    void checkAvailability();
    void reserveRoom(Guest guest, int roomNumber);
    void cancelReservation(int roomNumber);
    void checkOut(int roomNumber);

}
