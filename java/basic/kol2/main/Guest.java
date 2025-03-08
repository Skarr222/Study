package kol2.main;

public class Guest {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    public Guest(String name, String surname, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void displayInfo() {
        System.out.println("Imię: " + name);
        System.out.println("Nazwisko: " + surname);
        System.out.println("Numer telefonu: " + phoneNumber);
        System.out.println("Email: " + email);
    }
}
