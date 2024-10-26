//
// Created by oskar on 08.06.2024.
//
#include <iostream>
using namespace std;

class Osoba {
public:
    Osoba(string imie, string nazwisko, int rok_urodzenia);
    void Wypisz();
private:
    string imie;
    string nazwisko;
    int rok_urodzenia;
};
