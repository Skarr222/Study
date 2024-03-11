package kol2.main;

import java.util.ArrayList;
import java.util.List;

public class HotelManagment  {
    private List<HotelRoom> rooms;

    public HotelManagment() {
        rooms = new ArrayList<>();
    }

    public void checkAvailability(boolean isReserved) {
        for (HotelRoom room : rooms) {
            if (room.isReserved() == isReserved) {
                System.out.println("Pokój " + room.getRoomNumber() + " jest " + (isReserved ? "zarezerwowany" : "dostępny"));
            }
        }
    }

    public void reserveRoom(Guest guest, int roomNumber) {
        HotelRoom room = findRoom(roomNumber);
        if (room != null) {
            room.reserveRoom(guest, roomNumber);
        } else {
            System.out.println("Pokój " + roomNumber + " nie istnieje.");
        }
    }

    public void cancelReservation(int roomNumber) {
        HotelRoom room = findRoom(roomNumber);
        if (room != null) {
            if (room.isReserved()) {
                room.cancelReservation();
                System.out.println("Rezerwacja pokoju " + roomNumber + " została anulowana.");
            } else {
                    System.out.println(" Pokój " + roomNumber + " nie jest zarezerwowany.");
            }
        } else {
                System.out.println("Pokój " + roomNumber + " nie istnieje.");
        }
    }

    public void checkOut(int roomNumber) {
        HotelRoom room = findRoom(roomNumber);
        if (room != null) {
            if (room.isReserved()) {
                room.checkOut(roomNumber);
                System.out.println("Gość wymeldował się z pokoju " + roomNumber + ".");
            } else {
                System.out.println("Pokój " + roomNumber + " nie jest zarezerwowany.");
            }
        } else {
            System.out.println("Pokój " + roomNumber + " nie istnieje.");

        }
    }

    public void addRoom(HotelRoom room) {
        rooms.add(room);
    }

    private HotelRoom findRoom(int roomNumber) {
        for (HotelRoom room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
