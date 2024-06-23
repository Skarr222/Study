// #include <iostream>
// /*
//  * Zaimplementuj klasę Ulamek z prywatnymi polami całkowitymi Licznik i Mianownik.
//  * Należy odpowiednio przeciążyć operatory *, -, +, *=, =, -=, +=, --, ++, <, >, ==, << (wypisywanie do strumienia) oraz zaimplementować konstruktory.
//  * Mianownik nie może być równy zero.
//  * Ułamki mają być wypisywane w postaci: Licznik/Mianownik, np.: „3/4”, „-79/8”.
//  * W funkcji main() powołaj do życia kilka obiektów oraz zademonstruj działanie przeciążonych operatorów klasy Ulamek.
//  */
// using namespace std;

// class Ulamek
// {
// private:
//     int licznik;
//     int mianownik;

// public:
//     Ulamek(int licznik, int mianownik)
//     {
//         if (mianownik == 0)
//         {
//             cout << "Mianownik nie może być równy 0! Wpisuję 1" << endl;
//             this->mianownik = 1;
//         }
//         else
//         {
//             this->mianownik = mianownik;
//         }
//         this->licznik = licznik;
//     }
//     Ulamek operator*(Ulamek &u2)
//     {
//         return Ulamek(licznik * u2.licznik, mianownik * u2.mianownik);
//     }
//     Ulamek operator+(Ulamek &u2)
//     {
//         return Ulamek(licznik * u2.mianownik + u2.licznik * mianownik, mianownik * u2.mianownik);
//     }
//     operator double() const
//     {
//         return static_cast<double>(licznik) / mianownik;
//     }
//     friend ostream &operator<<(ostream &wyjscie, Ulamek &u);

//     Ulamek operator-(Ulamek &u2)
//     {
//         return Ulamek(licznik * u2.mianownik - u2.licznik * mianownik, mianownik * u2.mianownik);
//     }

//     Ulamek operator/(int x)
//     {
//         return Ulamek(licznik, mianownik * x);
//     }
//     Ulamek operator++()
//     {
//         licznik += mianownik;
//         return *this;
//     }
//     Ulamek operator--()
//     {
//         licznik -= mianownik;
//         return *this;
//     }
//     Ulamek operator+=(Ulamek &u2)
//     {
//         licznik = licznik * u2.mianownik + u2.licznik * mianownik;
//         mianownik = mianownik * u2.mianownik;
//         return *this;
//     }
//     Ulamek operator-=(Ulamek &u2)
//     {
//         licznik = licznik * u2.mianownik - u2.licznik * mianownik;
//         mianownik = mianownik * u2.mianownik;
//         return *this;
//     }
//     Ulamek operator*=(Ulamek &u2)
//     {
//         licznik = licznik * u2.licznik;
//         mianownik = mianownik * u2.mianownik;
//         return *this;
//     }
//     bool operator<(Ulamek &u2)
//     {
//         return static_cast<double>(*this) < static_cast<double>(u2);
//     }
//     bool operator>(Ulamek &u2)
//     {
//         return static_cast<double>(*this) > static_cast<double>(u2);
//     }
//     bool operator==(Ulamek &u2)
//     {
//         return static_cast<double>(*this) == static_cast<double>(u2);
//     }
// };

// ostream &operator<<(ostream &wyjscie, Ulamek &u)
// {
//     return wyjscie << u.licznik << "/" << u.mianownik;
// }

// int main()
// {
//     Ulamek a(1, 2);
//     Ulamek b(1, 4);
//     cout << a << endl;
//     cout << static_cast<double>(a + b);

//     return 0;
// }