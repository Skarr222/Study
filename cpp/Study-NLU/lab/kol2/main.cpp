#include <iostream>
#include <string>

using namespace std;

class Pies {
protected:
    string imie;
    int wiek;

public:
    static int liczbaPsow;

    Pies() : imie(), wiek() {
        liczbaPsow++;
    }

    Pies(string imie, int wiek) : imie(imie), wiek(wiek) {
        liczbaPsow++;
    }

     ~Pies() {
        liczbaPsow--;
    }
    int getWiek() const {
        return wiek;
    }

    string getImie() const {
        return imie;
    }

    void szczekaj() const {
        cout << getImie() << " szczeka!" << endl;
    }

    friend void pokazImie(Pies& p);
    friend void zmienImie(Pies& p, string noweImie);
};

int Pies::liczbaPsow = 0;

class Jamnik : public Pies {
private:
    string kolor;

public:
    Jamnik(string imie, int wiek, string kolor) : Pies(imie, wiek), kolor(kolor) {}

    string getKolor() const {
        return kolor;
    }

    void kopDolki(Jamnik &jamnik) const {
        cout << jamnik.getImie() << " kopie dolki" << endl;
        cout << "Kolor jamnika: " << jamnik.getKolor() << endl;
        cout << jamnik.getImie() << " ubrudzil sie" << endl;
        cout << "Kolor jamnika: " << "Brudny " << jamnik.getKolor() << endl;
    }


};

class Terier : public Pies {
private:
    int energia;
public:
    Terier(string imie, int wiek, int energia) : Pies(imie, wiek), energia(energia) {
    }

    void bawSie() {
        cout << getImie() << " bawi sie z energia: " << energia << endl;
        energia -= 10;
        cout << "Po zabawie energia: " << energia << endl;
    }
    int getEnergia() const {
        return energia;
    }

    Terier operator+(const Terier& t) {
        return Terier(this->getImie() + t.getImie(), this->getWiek() + t.getWiek(), this->energia + t.energia);
    }

    bool operator==(const Terier& terrier) {
        return (this->getImie() == terrier.getImie()) && (this->energia == terrier.energia);
    }

    friend ostream& operator<<(ostream& os, const Terier& terrier) {
        os << "Terier: " << terrier.getImie() << ", Poziom energii: " << terrier.energia;
        return os;
    }
};

class Husky : public Pies {
private:
    int liczbaWygranychZawodow;

public:
    Husky(string imie, int wiek, int wygrane) : Pies(imie, wiek), liczbaWygranychZawodow(wygrane) {}

    void zawody(bool czyWygral)  {
        cout << getImie() << " bierze udzial w zawodach!" << endl;
        cout << "Dotychczasowa liczba wygranych zawodow: " << liczbaWygranychZawodow << endl;
        if (czyWygral) {
            liczbaWygranychZawodow++;
            cout << "Wygral/a zawody!" << endl;
            cout << "Liczba wygranych zawodow: " << liczbaWygranychZawodow << endl;
        } else {
            cout << "Przegral/a zawody!" << endl;
            cout << "Liczba wygranych zawodow: " << liczbaWygranychZawodow << endl;
        }

    }
};


void pokazImie(Pies& p) {
    cout << "Imie psa: " << p.imie << endl;
}

void zmienImie(Pies& p, string noweImiePsa) {
    cout << "Zmieniono imie psa z: " << p.imie;
    p.imie = noweImiePsa;
    cout << " na " << p.imie << endl;
}


int main() {
    Jamnik jamnik("Tofik", 3, "fioletowy");
    Terier terier1("Burek", 5, 50);
    Terier terier2("Reksio", 1, 100);
    Husky husky("Luna", 8, 15);

    cout << "Liczba psow: " << Pies::liczbaPsow << endl;

    Terier terier3 = terier1 + terier2;
    cout << endl;
    cout << terier3 << endl;
    cout << endl;
    cout << terier1.getImie() << " i " << terier2.getImie() << " sa" << (terier1 == terier2 ? " takie same" : " rozne") << endl;
    cout << terier1.getImie() << " i " << terier1.getImie() << " sa" << (terier1 == terier1 ? " takie same" : " rozne") << endl;

    cout << endl;

    jamnik.szczekaj();
    cout << endl;
    jamnik.kopDolki(jamnik);
    cout << endl;

    terier1.szczekaj();
    cout << endl;
    terier1.bawSie();
    cout << endl;

    husky.szczekaj();
    cout << endl;
    husky.zawody(true);
    cout << endl;
    husky.zawody(false);
    cout << endl;

    pokazImie(jamnik);
    zmienImie(jamnik, "Tofik2");
    cout << endl;

    cout << "Liczba psow: " << Pies::liczbaPsow << endl;
    cout << endl;

    return 0;
}
class Policjant {
public:
    Policjant(std::string imie, std::string nazwisko, std::string stopien)
            : imie_(imie), nazwisko_(nazwisko), stopien_(stopien) {}

    virtual void wyswietlDane() const {
        std::cout << "Policjant: " << imie_ << " " << nazwisko_ << ", stopień: " << stopien_ << std::endl;
    }

protected:
    std::string imie_;
    std::string nazwisko_;
    std::string stopien_;
};

class NaczelnikWydzialu : public Policjant {
public:
    NaczelnikWydzialu(std::string imie, std::string nazwisko, std::string stopien, std::string wydzial)
            : Policjant(imie, nazwisko, stopien), wydzial_(wydzial) {}

    void wyswietlDane() const override {
        Policjant::wyswietlDane();
        std::cout << "Naczelnik wydziału: " << wydzial_ << std::endl;
    }

private:
    std::string wydzial_;
};

int main() {
    Policjant* pracownicy[] = {
            new Policjant("Jan", "Kowalski", "podkomisarz"),
            new NaczelnikWydzialu("Anna", "Nowak", "komisarz", "Ruchu Drogowego"),
            new Policjant("Piotr", "Wiśniewski", "inspektor"),
            new NaczelnikWydzialu("Maria", "Zielińska", "nadkomisarz", "Prewencji")
    };

    for (Policjant* pracownik : pracownicy) {
        pracownik->wyswietlDane(); // Polimorficzne wywołanie
        std::cout << std::endl;
    }

    // Pamiętaj o zwolnieniu pamięci po obiektach dynamicznych
    for (Policjant* pracownik : pracownicy) {
        delete pracownik;
    }

    return 0;
}