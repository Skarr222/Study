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

int maksymalna_wysokosc_marchewek(int n, int *wysokosci)
{
    if (n == 0)
    {
        return 0;
    }
    else if (n == 1)
    {
        return wysokosci[0];
    }

    int *dp = new int[n];
    dp[0] = wysokosci[0];
    dp[1] = max(wysokosci[0], wysokosci[1]);

    for (int i = 2; i < n; ++i)
    {
        dp[i] = max(dp[i - 1], wysokosci[i] + dp[i - 2]);
    }

    int maksymalna_wysokosc = dp[n - 1];
    delete[] dp;
    return maksymalna_wysokosc;
}

int main()
{
    int n;
    cin >> n;

    int *wysokosci = new int[n];

    for (int i = 0; i < n; ++i)
    {
        cin >> wysokosci[i];
    }

    int wynik = maksymalna_wysokosc_marchewek(n, wysokosci);
    cout << wynik << endl;

    delete[] wysokosci;
    return 0;
}