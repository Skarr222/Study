/*
* Pan Integer znalazł w swoim pokoju pudełko z cyframi. W pudełku jest k2 cyfr 2, k3 cyfr 3, k5
* cyfr 5 i k6 cyfr 6.
* Ulubionymi liczbami całkowitymi pana Integera są 32 i 256. Postanowił poskładać te liczby z
* cyfr znajdujących się w pudełku. Każda cyfra może być użyta nie więcej niż jeden raz, tzn.
* wszystkie liczby powinny zawierać nie więcej niż k2 cyfr 2, k3 cyfr 3 i tak dalej. Chce przy tym,
* aby suma uzyskanych liczb była jak największa. Cyfry nieużywane nie są doliczane do sumy.
* Pomóż mu rozwiązać to zadanie!

* Wejście
* Jedyna linia wejścia zawiera cztery liczby całkowite k2, k3, k5 i k6 - odpowiednio liczbę cyfr 2,
* 3, 5 i 6 (0 ≤ k2, k3, k5, k6 ≤ 5·106)$.

* Wyjście
* Wypisz jedną liczbę całkowitą - maksymalną możliwą sumę ulubionych liczb całkowitych pana
* Integera, które można uzyskać za pomocą cyfr z pudełka.
*/
#include <iostream>
using namespace std;

int numbers(int k2, int k3, int k5, int k6)
{
    int number256 = 0;
    int number32 = 0;
    int sum = 0;
    int length = k2 + k3 + k5 + k6;
    if (length == 0)
    {
        cout << "Brak liczb do zsumowania" << endl;
        return 0;
    }

    for (int i = 0; i < length; i++)
    {
        if (k2 > 0 && k5 > 0 && k6 > 0)
        {
            number256++;
            k2--;
            k5--;
            k6--;
        }
        else if (k3 > 0 && k2 > 0)
        {
            number32++;
            k3--;
            k2--;
        }
    }
    sum = number256 * 256 + number32 * 32;
    return sum;
}

int main()
{
    int k2, k3, k5, k6;
    cout << "Podaj ilosc liczb 2, 3, 5, 6" << endl;
    cin >> k2 >> k3 >> k5 >> k6;
    cout << numbers(k2, k3, k5, k6) << endl;
}