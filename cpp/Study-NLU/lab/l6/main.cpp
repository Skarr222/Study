#include <iostream>

/*
 * Napisz program wykorzystujący klasę Samochód. Jako składowe klasy podaj: marka,
 * model,
 * pojemnosc,
 * spalanie,
 * dostępna ilość paliwa
 * Utwórz trzy obiekty klasy Samochód.
 * Utwórz funkcję zaprzyjaźnioną do której przekażesz obiekt klasy Samochód
 * oraz odległość w kilometrach. Funkcja sprawdza
 * czy dany obiekt ma wystarczającą ilość paliwa by przejechać podaną odległość.
 */
using namespace std;
class Samochod
{
private:
    string marka;
    string model;
    double pojemnosc;
    double spalanie;
    double iloscPaliwa;

public:
    Samochod(string marka, string model, double pojemnosc,
             double spalanie, double iloscPaliwa) : marka(marka), model(model), pojemnosc(pojemnosc), spalanie(spalanie), iloscPaliwa(iloscPaliwa) {}

    friend bool czyMoznaPrzejechac(const Samochod &samochod, double odleglosc);
};

bool czyMoznaPrzejechac(const Samochod &samochod, double odleglosc)
{
    return samochod.iloscPaliwa >= odleglosc * samochod.spalanie / 100;
};

int main()
{
    Samochod s1("Opel", "Astra", 1.6, 6.0, 40.0);
    Samochod s2("BMW", "E36", 2.0, 11.0, 60.0);
    Samochod s3("Audi", "A6", 2.2, 12.0, 67.0);

    cout << "Samochod 1: " << (czyMoznaPrzejechac(s1, 700) ? "TAK" : "NIE") << endl;
    cout << "Samochod 2: " << (czyMoznaPrzejechac(s2, 300) ? "TAK" : "NIE") << endl;
    cout << "Samochod 3: " << (czyMoznaPrzejechac(s3, 200) ? "TAK" : "NIE") << endl;

    return 0;
}