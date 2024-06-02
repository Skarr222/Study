#include <iostream>
#include <ctime>
using namespace std;

/*
 * Napisz klasę Serwis wspomagającą obsługę serwisową notebooków. W konstruktorze domyślnym powinna być zerowana prywatna tablica naprawy[][] oraz ustawiane statyczne pole
 * liczbaZgloszen na 0. Zakładamy, że pierwszy wymiar tablicy to identyfikatory komputerów (max 100), a drugi daty napraw (max 5),
 * Dodatkowo napisz metody:
 * boolean dodajNaprawe (int nrKomputera): funkcja ta pobiera aktualne naprawy komputera o indeksie nrkomputera (wiersz z tabeli),
 * a następnie w kolejnym wolnym miejscu dopisuje dzisiejszą datę.
 * Jeśli brakuje miejsca na naprawę, funkcja powinna zwrócić false;
 * w przeciwnym wypadku true.
 * int liczDoZlomowania(): funkcja liczy, ile komputerów już nie może być
 * naprawionych (brak miejsca w tablicy na naprawy)
 * String ostatniaNaprawa(int komputer): funkcja ma zwrócić stringa z datą
 * ostatniej naprawy danego komputera
 * double średnioNapraw(): funkcja zwraca informacje o średniej liczbie napraw
 * komputerów w bazie. UWAGA: komputer nigdy nie naprawiany nie wchodzi do średniej!
 */

class Serwis
{
private:
    static const int liczbaZgloszen = 0;
    static const int maxKomputery = 100;
    static const int maxNaprawy = 5;
    string naprawy[maxKomputery][maxNaprawy];

public:
    Serwis()
    {
        for (int i = 0; i < maxKomputery; i++)
        {
            for (int j = 0; j < maxNaprawy; j++)
            {
                naprawy[i][j] = "";
            }
        }
    }
    bool dodajNaprawe(int nrKomputera)
    {
        if (nrKomputera < 0 || nrKomputera >= maxKomputery)
        {
            return false;
        }

        for (int i = 0; i < maxNaprawy; i++)
        {
            if (naprawy[nrKomputera][i].length() > 0; i++)
            {
                continue;
            }
            time_t now = time(nullptr);
            naprawy[nrKomputera][i] = string(ctime(&now)).substr(0, 10);

            return true;
        }
    }
    int liczDoZlomowania()
    {
        int liczDoZlomowania = 0;
        for (int i = 0; i < maxKomputery; i++)
        {
            if (naprawy[i][maxNaprawy - 1].length() > 0)
            {
                liczDoZlomowania++;
            }
        }
        return liczDoZlomowania;
    }
    string ostatniaNaprawa(int nrKomputera)
    {
        if (nrKomputera < 0 || nrKomputera >= maxKomputery)
        {
            return "Nieprawidlowy numer komputera";
        }

        for (int i = maxNaprawy; i >= 0; i--)
        {
            if (naprawy[nrKomputera][i].length() > 0)
            {
                return naprawy[nrKomputera][i];
            }
        }
        return "Nie ma zadnych napraw";
    }
    double sredniaNapraw()
    {

        int naprawiane_komputery = 0;
        for (int i = 0; i < maxKomputery; i++)
        {
            if (!naprawy[i][0].empty())
            {
                naprawiane_komputery++;
            }
        }

        return liczbaZgloszen / naprawiane_komputery;
    }
};

int main()
{
    std::cout << "Hello, World!" << std::endl;
    return 0;
}