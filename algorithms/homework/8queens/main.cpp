    /*
* Janek uczy się grać w szachy. Poznaje sposób poruszania się różnych figur. Najśmieszniejszy
* wydaje mu się styl skoków konika. Zastanawia się również, co byłoby, gdyby na szachownicy
* znalazło się kilka figur hetmanów. Analizuje, czy na planszy o wymiarach n x n możliwe jest
* takie rozstawienie n tych figur, aby żaden z nich się nie szachował, a jeśli tak, to na ile
* sposobów można to zrobić?

* Wejście
* n - rozmiar szachownicy, liczba naturalna mniejsza niż 15.

* Wyjście
* Liczba sposobów, na jakie można rozmieścić figury hetmanów na szachownicy tak, by się
* wzajemnie nie szachowały.

* Przykład
* Wejście
* 8

* Wyjście
* 92
 */
#include <iostream>
#include <vector>
#include <cmath>

bool czyMoznaUmiescic(std::vector<int> &pozycje, int zajeteWiersze, int kolumna)
{
    for (int i = 0; i < zajeteWiersze; ++i)
    {
        if (pozycje[i] == kolumna ||
            abs(pozycje[i] - kolumna) == abs(i - zajeteWiersze))
        {
            return false;
        }
    }
    return true;
}

void rozwiazNHetmanow(int n, int zajeteWiersze, std::vector<int> &pozycje, int &licznik)
{
    if (zajeteWiersze == n)
    {
        licznik++;
        return;
    }

    for (int kolumna = 0; kolumna < n; ++kolumna)
    {
        if (czyMoznaUmiescic(pozycje, zajeteWiersze, kolumna))
        {
            pozycje[zajeteWiersze] = kolumna;
            rozwiazNHetmanow(n, zajeteWiersze + 1, pozycje, licznik);
        }
    }
}
int main()
{
    int n;
    std::cout << "Podaj rozmiar szachownicy:" << endl;
    std::cin >> n;
    if (n < 1 || n > 14)
    {
        std::cout << "Rozmiar szachownicy musi byc liczba naturalna mniejsza niz 15" << endl;
        return 0;
    }
    std::vector<int> pozycje(n);
    int licznik = 0;

    rozwiazNHetmanow(n, 0, pozycje, licznik);
}