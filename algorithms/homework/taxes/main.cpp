/*
* Pan Longint zamieszkał w Bitolandii. Bardzo lubi tamtejsze widoki. Bitolandia to kraj o bardzo
* dziwnym systemie podatkowym. Kwota podatku, jaką musi zapłacić pan Longint od umowy
* opiewającej na n bitów (miejscowa waluta), jest równa maksymalnemu dzielnikowi
* właściwemu n. Na przykład dla trzech umów odpowiednio na 25, 6 i 2 bity należy zapłacić 9
* bitów (5 bitów dla umowy na 25 bitów, 3 dla 6 i 1 dla 2 bitów).
* Pan Longint dostrzegł jednak pewną lukę w przepisach. Otóż może on podzielić umowę na
* kilka różnych (mniejszych) umów i (być może) zapłacić mniejszy podatek opodatkowując
* każdą umowę oddzielnie! Czy mu się to opłaca?
* Oblicz, jaki łączny (możliwie najmniejszy) podatek dla podanej kwoty zapłaci pan Longint!
*
* Wejście
* Pierwszy i jedyny wiersz wejścia zawiera jedną liczbę n (2 ≤ n ≤ 10^10) – kwota, na jaką opiewa umowa.
*
* Wyjście
* Wypisz jedną liczbę całkowitą – najniższy podatek, jaki może zapłacić Longint.

* Przykład
* Wejście             Wyjście
* 4                   27
*
* Wyjście             Wyjście
* 2                   3
*/

#include <iostream>

using namespace std;


long long najwiekszyDzielnikWlasciwy(long long kwota) {
    long long najwiekszyWlasciwyDzielnik = 0;

    for (long long i = 2; i * i <= kwota; ++i) {
        // jeśli i jest dzielnikiem n
        while (kwota % i == 0) {
            najwiekszyWlasciwyDzielnik = i;
            kwota /= i;

        }
    }
    // n jest liczbą pierwszą
    if (kwota > 1) {
        najwiekszyWlasciwyDzielnik = kwota;
    }
    return najwiekszyWlasciwyDzielnik;
}

int main() {
    long long kwota;
    cin >> kwota;
    if (kwota < 2) {
        cout << "Kwota jest mniejsza niż 2" << endl;
        return 0;
    } else if (kwota > 10000000000) {
        cout << "Kwota jest większa niż 10000000000" << endl;
        return 0;
    }
    long long minimalnyPodatek = najwiekszyDzielnikWlasciwy(kwota);
    cout << minimalnyPodatek << endl;
    return 0;
}
