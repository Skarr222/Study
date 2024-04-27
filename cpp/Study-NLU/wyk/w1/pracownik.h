#ifndef PRACOWNIK_H
#define PRACOWNIK_H

#include <string>
struct Pracownik {
    std::string imie;
    std::string nazwisko;
    double placa;
    void Wyswietl();
    void Wpisz();
};

#endif
