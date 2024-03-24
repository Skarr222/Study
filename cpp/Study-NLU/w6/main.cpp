#include <iostream>

class Osoba {
    private:
    std::string imie;
    std::string nazwisko;
public:
    Osoba(std::string imie, std::string nazwisko) : imie(imie), nazwisko(nazwisko){}
    void Drukuj() const {
        std::cout << "Imie i Nazwisko: " << imie << " "<< nazwisko << std::endl;
    }
};

class Pracownik : public Osoba {
    private:
    std::string stanowisko;
    std::string placa;
    public:
    Pracownik(std::string imie, std::string nazwisko, std::string stanowisko, std::string placa) 
    : Osoba(imie, nazwisko), stanowisko(stanowisko), placa(placa) {}
    void Drukuj() const {
        Osoba::Drukuj();
        std::cout << "Stanowisko: " << stanowisko << std::endl;
        std::cout << "Placa: " << placa << std::endl;
    }
};

class PracownikEtatowy : public Pracownik {
    private:
    std::string placaBrutto;
    public:
    PracownikEtatowy(std::string imie, std::string nazwisko, std::string stanowisko, std::string placa, std::string placaBrutto) 
    : Pracownik(imie, nazwisko, stanowisko, placa), placaBrutto(placaBrutto) {}
    void Drukuj() const {
        Pracownik::Drukuj();
        std::cout << "Płaca Brutto: " << placaBrutto << std::endl;
    }
};
class PracownikGodzinowy : public Pracownik{
    private:
    double stawkaGodzinowa;
    double liczbaGodzin;
    public:
    PracownikGodzinowy(std::string imie, std::string nazwisko, std::string stanowisko, std::string placa, double stawkaGodzinowa, double liczbaGodzin) 
    : Pracownik(imie, nazwisko, stanowisko, placa), stawkaGodzinowa(stawkaGodzinowa), liczbaGodzin(liczbaGodzin) {}
    void Drukuj() const {
        Pracownik::Drukuj();
        std::cout << "Stawka Godzinowa: " << stawkaGodzinowa << std::endl;
        std::cout << "Liczba Godzin: " << liczbaGodzin << std::endl;
    }
    double Wynagrodzenie() const {
        return stawkaGodzinowa * liczbaGodzin;
    }
};

int main() {
    //* wskaźnik na osobe wskazuje na osobe
    Osoba osoba("Jan", "Kowalski");
    Osoba *wsk1 = &osoba;
    wsk1->Drukuj();

    //* wskaźnik na osobe wskazuje na pracownika
    Pracownik pracownik("Jan", "Kowalski", "Informatyk", "5000");
    Osoba *wsk2 = &pracownik;

    //* wskaźnik na pracownika wskazuje na osobe 
    //! BŁĄD WSKAŹNIK PRACOWNIKA NIE MOŻE WSKAZYWAĆ NA OSOBE ponieważ 
    //! pracownik ma więcej pól niż osoba więce nie możemy wskazać 
    //! na osobe ponieważ może nam brakować danych
    // Pracownik *wsk3 = &osoba
    // wsk3->Drukuj();

    return 0;
}
