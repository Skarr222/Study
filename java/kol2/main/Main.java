package kol2.main;

public class Main {
    public static void main(String[] args) {
        HotelManagment hotelManagement = new HotelManagment();

        StandardRoom standardRoom1 = new StandardRoom(101, 2, 100.0, 1, false, true, false);
        StandardRoom standardRoom2 = new StandardRoom(102, 2, 120.0, 1, false, false, true);
        SuiteRoom suiteRoom1 = new SuiteRoom(201, 4, 200.0, 2, false, true, true);

        hotelManagement.addRoom(standardRoom1);
        hotelManagement.addRoom(standardRoom2);
        hotelManagement.addRoom(suiteRoom1);

        System.out.println("Dostępność pokoi:");
        hotelManagement.checkAvailability(false);

        Guest guest1 = new Guest("Jan", "Kowalski", "123456789", "jan.kowalski@gmail.com");

        hotelManagement.reserveRoom(guest1, 101);


        System.out.println("\nDostępność pokoi po rezerwacji:");
        hotelManagement.checkAvailability(false);



        System.out.println("\nDostępność pokoi po anulowaniu rezerwacji:");
        hotelManagement.cancelReservation(101);
        hotelManagement.checkAvailability(false);

        System.out.println("\nDostępność pokoi po wymeldowaniu się:");
        hotelManagement.checkOut( 102);
        hotelManagement.checkAvailability(false);
    }
}
