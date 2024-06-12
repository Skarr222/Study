/*
 * Napisz program, który dla podanej na standardowym wejściu liczby całkowitej n, narysuje
 * szachownicę z cyfr 0 i 1 o boku n.
 * Wejście
 * Jedyny wiersz danych zawiera liczbę całkowitą n (1 ≤ n ≤ 200).
 * Wyjście
 * Program powinien wypisać szachownicę o wielkości n.
 * Przykład
 * Wejście
 * 5
 * Wyjście
 * 01010
 * 10101
 * 01010
 * 10101
 * 01010
 */

#include <iostream>
using namespace std;

void chessboard(int rozmiar)
{
    for (int wiersz = 0; wiersz < rozmiar; ++row)
    {
        for (int kolumna = 0; kolumna < rozmiar; ++col)
        {
            if ((wiersz + kolumna) % 2 == 0)
            {
                cout << "0";
            }
            else
            {
                cout << "1";
            }
        }
        cout << endl;
    }
}

int main()
{
    int n;
    cout << "Wpisz wielkosc szachownicy: ";
    cin >> n;
    if (n > 0)
    {
        chessboard(n);
    }
    else
    {
        cout << "Wielkosc musi byc wieksza od zera" << endl;
    }

    return 0;
}