#include <iostream>
using namespace std;
class Pracownik
{
private:
    string imie;
    string nazwisko;
public:
    Pracownik(const string& imie, const string& nazwisko)
            : imie(imie), nazwisko(nazwisko)
    {
    }
    virtual void wyswietlDane() const
    {
        cout << "Imie: " << imie << '\n';
        cout << "Nazwisko: " << nazwisko << '\n';
    }
};

class Policjant : public Pracownik
{
private:
    string stopien;
public:
    Policjant(const string& imie, const string& nazwisko, const string& stopien)
            : Pracownik(imie,nazwisko), stopien(stopien)
    {}

    void wyswietlDane() const override
    {
        Pracownik::wyswietlDane();
        cout << "Stopien: " << stopien << '\n';
    }
};

class Naczelnik : public Policjant
{
private:
    string wydzial;
public:
    Naczelnik(const string& imie, const string& nazwisko, const string& stopien, const string& wydzial)
            :Policjant(imie,nazwisko, stopien), wydzial(wydzial){}

    void wyswietlDane() const override
    {
        Policjant::wyswietlDane();
        cout << "Wydzial: " << wydzial << '\n';
    }
};
int main()
{
    Pracownik* pracownicy[] = {
            new Pracownik("Jan", "Kowalski"),
            new Policjant("Adam", "Nowak", "komisarz"),
            new Naczelnik("Marek", "Kowal", "inspektor", "Wydzial 1")
    };

    for (auto pracownik : pracownicy)
    {
        pracownik->wyswietlDane();
        cout << endl;
    }

    for (auto pracownik : pracownicy)
    {
        delete pracownik;
    }

    return 0;


}