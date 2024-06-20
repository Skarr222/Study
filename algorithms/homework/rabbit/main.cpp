/*
* Króliczek Mareczek kocha marcheweczki. Posadził N marcheweczek w rządku.
* Każda z nich wyrosła na pewną wysokość, pierwsza marcheweczka na wysokość m1, druga na wysokość m2 i tak dalej. . .
* W niedzielę odwiedził go króliczek Karolek i postanowili zrobić marcheweczkową wyżerkę.
* Króliczek Mareczek postanowił zebrać część marcheweczek ze swojego ogródka tak,
* że suma wysokości wszystkich zebranych marcheweczek jest największa.
* Z każdej pary sąsiednich marcheweczek w rzędzie, chce wziąć nie
* więcej niż jedną marcheweczkę (coś mu musi po tej wyżerce zostać).
* Powiedz króliczkowi Mareczkowi, jaka jest największa sumaryczna wysokość marcheweczek.

* Wejście
* W pierwszej linii znajduje się jedna liczba całkowita N, oznaczająca liczbę marcheweczek. W drugiej linii
* znajduje się N liczb całkowitych mi ≤ 109, oznaczające wysokości kolejnych marcheweczek.

* Wyjście
* Na wyjście wypisz jedną liczbę całkowitą oznaczającą największą sumaryczną wysokość marcheweczek.

* Przykład
* Wejście                         Wyjście
* 8                               180
* 45 41 11 37 9 53 57 45
*/

#include <iostream>

using namespace std;

int maksymalnaWysokoscMarchewek(int n, int *wysokosciMarchewek)
{
    if (n == 0) // brak marchewek
    {
        return 0;
    }
    else if (n == 1) // jedna marchewka
    {
        return wysokosciMarchewek[0];
    }

    int *dt = new int[n]; // stworzenie dynamicznej tablicy dla każdej marchewki
    dt[0] = wysokosciMarchewek[0]; // pierwsza marchewka
    dt[1] = max(wysokosciMarchewek[0], wysokosciMarchewek[1]); // pierwsza lub druga marchewka (maksymalna wysokość)

    for (int i = 2; i < n; ++i)
    {
        dt[i] = max(dt[i - 1], wysokosciMarchewek[i] + dt[i - 2]); // maksymalna wysokość dla i-tej marchewki
    }

    int maksymalnaWysokosc = dt[n - 1]; // maksymalna wysokość dla wszystkich marchewek
    delete[] dt;
    return maksymalnaWysokosc;
}

int main()
{
    int n;
    cin >> n;

    int *wysokosciMarchewek = new int[n]; // wysokości marchewek
    for (int i = 0; i < n; ++i)
    {
        cin >> wysokosciMarchewek[i]; // wprowadzenie danych
    }
    int wynik = maksymalnaWysokoscMarchewek(n, wysokosciMarchewek);
    cout << wynik << endl;

    delete[] wysokosciMarchewek;
    return 0;
}