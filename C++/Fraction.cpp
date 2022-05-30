#include <iostream>
#include <cmath>

void fraction(double &integral, double &fractional, double liczba){
	integral = int(liczba);
	fractional = liczba-integral;
}

int main() {
double integral, fractional;
fraction(integral, fractional, 3.14159);
std::cout << integral << " " << fractional << std::endl; }
