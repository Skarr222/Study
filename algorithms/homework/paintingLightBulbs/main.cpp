/*
 * W Bitocji mieszkańcy lubią ozdabiać domy kolorowymi żaróweczkami. Tworzą z nich różne
 * wzory, ale zawsze dbają o to, by żarówki znajdowały się w jednej linii obok siebie. Czasem
 * trzeba dokonywać napraw i wówczas ważne jest, by żarówki w tym samym kolorze znajdowały
 * się blisko siebie. Każdy mieszkanie chce więc wiedzieć, w jakiej odległości żarówki tego
 * samego koloru są najbliżej oraz najdalej siebie.
 *
 * Wejście
 * W pierwszym wierszu wejścia znajduje się liczba n (1 ≤ n ≤ 106).
 * W drugiej linii znajduje się n liczb całkowitych ki – kolory żaróweczek (1 ≤ ki ≤ n).
 *
 * Wyjście
 * Twój program powinien zapisać dwie liczby całkowite oznaczające odpowiednio najmniejszą
 * odległość pomiędzy dwoma żaróweczkami dowolnego ale tego samego koloru oraz
 * największą możliwą odległość pomiędzy dwoma żaróweczkami dowolnego, ale tego samego koloru.
 * Jeżeli nie jest możliwe wyznaczenie którejś z odległości, wypisz 0.
 *
 * Przykład
 * Wejście                             Wyjście
 * 7                                   1 5
 * 1 2 3 3 1 1 3
 */

#include <iostream>
using namespace std;

int main() {
    int liczbaZarowek;
    cout << "Podaj liczbe zarowek: ";
    cin >> liczbaZarowek;
    if(liczbaZarowek < 1 || liczbaZarowek > 106){
        cout << "Liczba zarowek musi byc z zakresu od 1 do 106" << endl;
        return 0;
    }

    int *kolory = new int[liczbaZarowek];
    cout << "Podaj kolory zarowek: ";
    for (int i = 0; i < liczbaZarowek; i++) {
        cin >> kolory[i];
        if(kolory[i] < 1 || kolory[i] > liczbaZarowek){
            cout << "Kolor musi byc z zakresu od 1 do " << liczbaZarowek << endl;
            return 0;
        }
    }
    if(liczbaZarowek == 1){
        cout << "0 0" << endl;
        return 0;
    }

    int minOdleglosc = liczbaZarowek;
    int maxOdleglosc = 0;

    int *pierwszy = new int[liczbaZarowek];
    int *ostatni = new int[liczbaZarowek];
    for (int i = 0; i < liczbaZarowek; i++) {
        pierwszy[i] = 0;
        ostatni[i] = 0;
    }

    for (int i = 0; i < liczbaZarowek; i++) {
        int kolor = kolory[i] - 1;

        if (pierwszy[kolor] == 0) {
            pierwszy[kolor] = i + 1;
        }
        ostatni[kolor] = i;
    }

    for (int i = 0; i < liczbaZarowek; i++) {
        int kolor = kolory[i] - 1;

        if (pierwszy[kolor] != 0) {
            int odleglosc = ostatni[kolor] - pierwszy[kolor] + 1;
            if (odleglosc < minOdleglosc) {
                minOdleglosc = odleglosc;
            }
            if (odleglosc > maxOdleglosc) {
                maxOdleglosc = odleglosc;
            }
        }
        if (i < liczbaZarowek - 1 && kolory[i] == kolory[i + 1]) {
            minOdleglosc = 1;
        }
    }

    cout << minOdleglosc << " " << maxOdleglosc << endl;

    delete[] kolory;
    delete[] pierwszy;
    delete[] ostatni;

    return 0;
}