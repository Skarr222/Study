// #include <iostream>

// using namespace std;

// class Pracownik
// {
// protected:
//     string imie, nazwisko;

// public:
//     static string stanowisko;
//     Pracownik(string imie, string nazwisko) : imie(imie), nazwisko(nazwisko)
//     {
//     }
//     void wyswietlDane()
//     {
//         cout << "Dane pracownika: " << imie << " " << nazwisko << endl;
//     }
//     void nadpiszDane(string x, string y)
//     {
//         imie = x;
//         nazwisko = y;
//     }
//     string zwrocImie();
// };
// string stanowisko = "it";
// string Pracownik::zwrocImie()
// {
//     return imie;
// }

// int main()
// {
//     Pracownik George("George", "Smith");
//     George.wyswietlDane();

//     Pracownik Marcin("Marcin", "Kowalski");
//     Marcin.nadpiszDane("test2", "test2");
//     Marcin.wyswietlDane();
// }
#include <iostream>
#include <cmath>
using namespace std;
class RownanieKwadratowe
{
private:
    double A, B, C;

public:
    RownanieKwadratowe()
    { // konstruktor domyslny
        A = 0;
        B = 0;
        C = 0;
    }

    RownanieKwadratowe(double A, double B, double C)
    { // nasz konstruktor
        // A = A;                  //tutaj uzywamy A z parametrów i nadpisuje tą A
        this->A = A; // tutaj uzywamy A z parametrów i nadpisujemy A z klasy
        this->B = B;
        this->C = C;
    }

    void ustawA(double num)
    {            // seter
        A = num; // tu nie trzeba this->, bo różne nazwy
    }

    void ustawB(double num)
    {
        B = num;
    }

    void ustawC(double num)
    {
        C = num;
    }

    // b*b-4*a*c
    double delta()
    {
        return B * B - 4 * A * C;
    }

    //(-b-sqrt(delta))/(2*a)
    double obliczX1()
    {
        return (-B - sqrt(delta())) / (2 * A);
    }

    //(-b+sqrt(delta))/(2*a)
    double obliczX2()
    {
        return (-B + sqrt(delta())) / (2 * A);
    }

    //-b/(2*a);
    double obliczX12()
    {
        return -B / (2 * A);
    }
    double q()
    {
        return -delta() / (4 * A);
    }
    void obliczZerowe()
    {
        double delta = this->delta(); // potrzebne this->, bo powtorzenie nazwy
        if (delta > 0)
        {
            cout << "Pierwiastki rownania x1=" << obliczX1() << ", x2=" << obliczX2() << endl;
        }
        else if (delta == 0)
        {
            cout << "Pierwiastek podwojny x0=" << obliczX12() << endl;
        }
        else
        {
            cout << "Brak pierwiastkow rzeczywistych\n";
        }
    }
    void obliczWierzcholek()
    {
        cout << "Wierzcholkiem jest: (" << obliczX12() << ", " << q() << ")" << endl;
    }
    void get()
    {
        cout << "a: " << A << " b: " << B << " c: " << C << endl;
    }
};

int main()
{
    RownanieKwadratowe r; // tworzenie obiektu r z konstruktorem domyslnym
    double num;

    cout << "Podaj A:";
    cin >> num;
    r.ustawA(num);
    cout << "Podaj B:";
    cin >> num;
    r.ustawB(num);

    cout << "Podaj C:";
    cin >> num;
    r.ustawC(num);
    RownanieKwadratowe f(2, 4, 6); // tworzenie obiektu z konstruktorem z parametrami (a,b,c)

    r.obliczZerowe();
    r.obliczWierzcholek();
    r.get();
    f.obliczZerowe();
    f.get();

    return 0;
}