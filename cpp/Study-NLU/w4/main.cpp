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
    std::cout << "Pracownik:" << std::endl;
    Pracownik pracownik("Jan", "Kowalski", "Informatyk", "5000");
    pracownik.Drukuj();

    PracownikEtatowy pracownikEtatowy("Jan", "Kowalski", "Informatyk", "5000", "6000");
    std::cout << "Pracownik Etatowy:" << std::endl;
    pracownikEtatowy.Drukuj();
    PracownikGodzinowy pracownikGodzinowy("Jan", "Kowalski", "Informatyk", "5000", 50, 100);
    std::cout << "Pracownik Godzinowy:" << std::endl;
    pracownikGodzinowy.Drukuj();
    std::cout << "Wynagrodzenie: " << pracownikGodzinowy.Wynagrodzenie() << std::endl;
    return 0;
}
