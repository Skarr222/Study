/*
*  Pan Integer kupił swoją ulubioną czekoladę z nadzieniem toffi. Czekolada ma kształt
* prostokąta o rozmiarze n na m kawałków. Pan Integer chciałby teraz odłamać jednym ruchem
* dokładnie k kawałków. Czy jest to możliwe?

* Wejście
* Pierwszy wiersz wejścia zawiera dwie liczby całkowite n oraz m – rozmiar czekolady
* (1 ≤ n, m ≤ 106). 8
* W kolejnej linii znajduje się całkowita liczba k kawałków czekolady,
* które chce odłamać pan Integer (1 ≤ k ≤ 106).

* Wyjście
* Na wyjściu wypisz odpowiedź na pytanie, czy pan Integer może jednym przełamaniem
* oderwać k kawałków czekolady (TAK lub NIE).
*
* Przykład
* Wejście
* 3 5 6
*
* Wyjście
* TAK
*
* Wejście
* 4 8 6
*
* Wyjście
* NIE
*/
#include <iostream>
using namespace std;

int main()
{
    int n, m, k;
    cout << "Podaj dlugosc i szerokosc czekolady oraz ilosc kawalkow do oderwania:" << endl;
    cin >> n >> m >> k;

    if (k % n == 0 || k % m == 0)
    {
        cout << "TAK" << endl;
    }
    else
    {
        cout << "NIE" << endl;
    }

    return 0;
}