#include <iostream>
#include <string>
#include <iostream>
#include <string>
using namespace std;
class Przedmiot
{
private:
    double *oceny;
    int nr_indeksu;
    int liczba_ocen = 0;
    int limit_ocen;

public:
    ~Przedmiot()
    {
        delete[] oceny;
        cout << "Destruktor wywolany" << endl;
    }
    Przedmiot(int nr_indeksu, int limit_ocen)
    {
        this->nr_indeksu = nr_indeksu;
        this->limit_ocen = limit_ocen;
        this->oceny = new double[limit_ocen];
    }
    void dodajOcene(double ocena)
    {
        if (liczba_ocen >= limit_ocen)
        {
            std::cout << "Dodano juz maksymalna liczbe ocen!\n";
            return;
        }
        if (ocena >= 1 && ocena <= 6)
        {
            oceny[liczba_ocen++] = ocena;
            std::cout << "Ocena dodana na " << liczba_ocen << " miejscu\n";
        }
        else
        {
            std::cout << "Ocena poza zakresem";
        }
    }
    double obliczSrednia()
    {
        double suma = 0;
        if (liczba_ocen > 0)
        {
            for (int i = 0; i < liczba_ocen; i++)
            {
                suma += oceny[i];
            }
            return suma / liczba_ocen;
        }
        else
        {
            return 0;
        }
    }
    bool zaliczenie()
    {
        if (obliczSrednia() >= 3.0)
        {
            return true;
        }
        else
            return false;
    }
    void pisz()
    {
        cout << "Nr indexu: " << nr_indeksu << "\n"
             << endl;
        cout << "Srednia: " << obliczSrednia() << "\n"
             << endl;
        cout << "Oceny: " << endl;
        for (int i = 0; i < liczba_ocen; i++)
        {
            cout << oceny[i] << "\n";
        }
        cout << "Czy zaliczone: \n";
        if (zaliczenie())
            cout << "TAK \n";
        else
            cout << "NIE \n";
    }
    void zmienOcene(double ocena, int ID)
    {
        if (ID <= liczba_ocen && ID >= 1)
            oceny[ID - 1] = ocena;
        else
            cout << "Nie ma takiej oceny!" << endl;
    }
};

int main()
{
    Przedmiot p(20220, 6);
    p.dodajOcene(5);
    p.dodajOcene(4);
    p.dodajOcene(3);
    p.dodajOcene(2);
    p.dodajOcene(1);
    p.pisz();
    cout << "Zmiana oceny: \n"
         << endl;
    p.zmienOcene(1, 1);
    p.pisz();
    return 0;
}