/*
* W pokoju znajduje się n żarówek. Początkowo wszystkie żarówki są zgaszone. Z każdą żarówką połączony jest jeden wyłącznik,
* którego naciśnięcie powoduje zmianę stanu żarówki (zaświecenie zgaszonej lub zgaśnięcie zapalonej).
* Miecio postanowił pobawić się wyłącznikami i  razy dokonał naciśnięcia któregoś z wyłączników. Ile żarówek jest teraz zapalonych?

* Wejście
* W pierwszej linii wejścia znajdują się dwie liczby całkowite oddzielone spacją, n i k (1 ≤ n ≤ 1000, 1 ≤ k ≤ 1000000 ).
* W drugiej linii znajduje się k liczb całkowitych a1, ..., ak (1 ≤ ai ≤ n) poodzielanych spacjami.
* Liczby te oznaczają numery wyłączników naciskanych przez Miecia.
*
* Wyjście
* Program powinien wypisać jedną liczbę oznaczającą liczbę zapalonych żarówek po zakończeniu zabawy Miecia.
* Przykład
* Dla danych wejściowych:
* 3 8
* 1 1 2 1 3 2 2 1
* poprawną odpowiedzią jest:
* 2
*/

#include <iostream>

using namespace std;

int main()
{
    int n, k;
    cin >> n >> k;

    int *wylaczniki = new int[n];
    for (int i = 0; i < n; ++i)
    {
        wylaczniki[i] = 0;
    }

    for (int i = 0; i < k; ++i)
    {
        int wylacznik;
        cin >> wylacznik;
        wylaczniki[wylacznik - 1] = !wylaczniki[wylacznik - 1];
    }

    int zapalone = 0;
    for (int i = 0; i < n; ++i)
    {
        if (wylaczniki[i] == 1)
        {
            ++zapalone;
        }
    }

    cout << zapalone << endl;
    delete[] wylaczniki;
    return 0;
}