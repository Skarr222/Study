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
    public:
    Pracownik(std::string imie, std::string nazwisko, std::string stanowisko) 
    : Osoba(imie, nazwisko), stanowisko(stanowisko) {}
    void Drukuj() const {
        Osoba::Drukuj();
        std::cout << "Stanowisko: " << stanowisko << std::endl;
    }
    virtual double DochodyRoczne (){
        return 0;
    }
};

class PracownikEtatowy : public Pracownik {
    private:
    double placaBrutto;
    public:
    PracownikEtatowy(std::string imie, std::string nazwisko, std::string stanowisko, double placaBrutto) 
    : Pracownik(imie, nazwisko, stanowisko), placaBrutto(placaBrutto) {}
    void Drukuj() const {
        Pracownik::Drukuj();
        std::cout << "Płaca Brutto: " << placaBrutto << std::endl;
    }

     virtual double DochodyRoczne (){
        return placaBrutto * 12;
    }
};

class PracownikGodzinowy : public Pracownik{
    private:
    double stawkaGodzinowa;
    double liczbaGodzin;
    public:
    PracownikGodzinowy(std::string imie, std::string nazwisko, std::string stanowisko, double stawkaGodzinowa, double liczbaGodzin) 
    : Pracownik(imie, nazwisko, stanowisko), stawkaGodzinowa(stawkaGodzinowa), liczbaGodzin(liczbaGodzin) {}
    void Drukuj() const {
        Pracownik::Drukuj();
        std::cout << "Stawka Godzinowa: " << stawkaGodzinowa << std::endl;
        std::cout << "Liczba Godzin: " << liczbaGodzin << std::endl;
    }
   virtual double DochodyRoczne (){
        return liczbaGodzin * stawkaGodzinowa;
    }
};

class Ksiegowosc{
    public:
     void DrukujPIT(Pracownik &pracownik){
        std::cout << "Pit 11: " << std::endl;
        std::cout << "Dane Podatnika: "  << std::endl;
        pracownik.Drukuj();
        std::cout << "Dochody roczne podatnika: " << pracownik.DochodyRoczne() << std::endl;
    }
};

int main() {
    //* wskaźnik na osobe wskazuje na osobe
    //* Osoba osoba("Jan", "Kowalski");
    //* Osoba *wsk1 = &osoba;
    //* wsk1->Drukuj();

    //* wskaźnik na osobe wskazuje na pracownika
    //*  Osoba *wsk2 = &pracownik;
    //*  wsk2->Drukuj();

    /*
    * wskaźnik na pracownika wskazuje na osobe
    ! BŁĄD WSKAŹNIK PRACOWNIKA NIE MOŻE WSKAZYWAĆ NA OSOBE ponieważ
    ! pracownik ma więcej pól niż osoba więce nie możemy wskazać 
    ! na osobe ponieważ może nam brakować danych
    ! Pracownik *wsk3 = &osoba
    ! wsk3->Drukuj();
    */  

    Ksiegowosc ksiegowosc;
    Pracownik pracownik("Jan", "Pracownik", "Informatyk");

    // std::cout << "Pracownik:" << std::endl;
    // pracownik.Drukuj();

    std::cout << "Ksiegowosc:" << std::endl;
    ksiegowosc.DrukujPIT(pracownik);
    std::cout << std::endl; 

    PracownikEtatowy pracownikEtatowy("Jan", "Etatowy", "Kierownik", 6000);
    // std::cout << "Pracownik Etatowy:" << std::endl;
    // pracownikEtatowy.Drukuj();
    std::cout << "Ksiegowosc Etatowy:" << std::endl;
    ksiegowosc.DrukujPIT(pracownikEtatowy);
    std::cout << std::endl; 

    PracownikGodzinowy pracownikGodzinowy("Jan", "Godzinowy", "Tester", 50, 100);
    // std::cout << "Pracownik Godzinowy:" << std::endl;
    // pracownikGodzinowy.Drukuj();
    std::cout << "Ksiegowosc Godzinowy:" << std::endl;
    ksiegowosc.DrukujPIT(pracownikGodzinowy);
    std::cout << std::endl; 

    return 0;
}
