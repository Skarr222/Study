#include "pracownik.h"
#include <iostream>
#include <string>

void Pracownik::Wyswietl() {
    std::cout << "Imie: " << imie << std::endl;
    std::cout << "Nazwisko: " << nazwisko << std::endl;
    std::cout << "Placa: " << placa << std::endl;
}

void Pracownik::Wpisz() {
    std::cout << "Podaj imie: ";
    std::cin >> imie;
    std::cout << "Podaj nazwisko: ";
    std::cin >> nazwisko;
    std::cout << "Podaj place: ";
    std::cin >> placa;
}