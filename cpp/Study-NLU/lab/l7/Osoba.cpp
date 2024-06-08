#include "Osoba.h"

Osoba::Osoba(string imie, string nazwisko, int rok_urodzenia): imie(imie), nazwisko(nazwisko), rok_urodzenia(rok_urodzenia){}

void Osoba::Wypisz(){
    cout << "Imie: " << imie << endl;
    cout << "Nazwisko: " << nazwisko << endl;
    cout << "Rok urodzenia: " << rok_urodzenia << endl;
}