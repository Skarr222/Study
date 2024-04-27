#include <iostream>

class Samochod
{
protected:
    double spalanie;
    double amortyzacja;

public:
    Samochod(double spalanie, double amortyzacja) : spalanie(spalanie), amortyzacja(amortyzacja)
    {
    }
    virtual double ObliczSpalanieNaTrasie(double liczbaKilomentrow)
    {
        return 0;
    }
    virtual double ObliczAmortyzacjeNaTrasie(double liczbaKilomentrow)
    {
        return 0;
    }
};
class SamochodOsobowy : public Samochod
{
public:
    SamochodOsobowy(double spalanie, double amortyzacja) : Samochod(spalanie, amortyzacja)
    {
    }

    double ObliczSpalanieNaTrasie(double liczbaKilomentrow)
    {
        return liczbaKilomentrow * spalanie / 100;
    }
    double ObliczAmortyzacjeNaTrasie(double liczbaKilomentrow)
    {
        return liczbaKilomentrow * amortyzacja / 100;
    }
};

class SamochodCiezarowy : public Samochod
{
private:
    double ladownoscNaczepy;
    double ladownoscPrzyczepy;

public:
    SamochodCiezarowy(double spalanie, double amortyzacja, double ladownoscNaczepy, double ladownoscPrzyczepy)
        : Samochod(spalanie, amortyzacja), ladownoscNaczepy(ladownoscNaczepy), ladownoscPrzyczepy(ladownoscPrzyczepy)
    {
    }

    double ObliczSpalanieNaTrasie(double liczbaKilomentrow)
    {
        return liczbaKilomentrow * (spalanie + ladownoscNaczepy / 100 + ladownoscPrzyczepy / 100) / 100;
    }
    double ObliczAmortyzacjeNaTrasie(double liczbaKilomentrow)
    {
        return liczbaKilomentrow * (amortyzacja + (2 * ladownoscNaczepy) / 100 + (3 * ladownoscPrzyczepy) / 100) / 100;
    }
};

class Transport
{
private:
    double kosztyPaliwaWFirmie;
    double kosztyAmortyzacjiWFirmie;

public:
    Transport(double kosztyPaliwaWFirmie, double kosztyAmortyzacjiWFirmie)
        : kosztyPaliwaWFirmie(kosztyPaliwaWFirmie), kosztyAmortyzacjiWFirmie(kosztyAmortyzacjiWFirmie)
    {
        kosztyPaliwaWFirmie = 0;
        kosztyAmortyzacjiWFirmie = 0;
    }
    void WykonajTrase(Samochod &s, double liczbaKilometrow)
    {
        kosztyPaliwaWFirmie += s.ObliczSpalanieNaTrasie(liczbaKilometrow) * 7;
        kosztyAmortyzacjiWFirmie += s.ObliczAmortyzacjeNaTrasie(liczbaKilometrow);
    };
    void WyswietlKoszty() const
    {
        std::cout << "Koszty paliwa w firmie: " << kosztyPaliwaWFirmie << std::endl;
        std::cout << "Koszty amortyzacji w firmie: " << kosztyAmortyzacjiWFirmie << std::endl;
    }
};

int main()
{
    std::cout << "Przyklad wirtualnosci" << std::endl;
    std::cout << std::endl;

    Transport t(0, 0);

    Samochod s1(7, 10);
    t.WykonajTrase(s1, 100);
    t.WyswietlKoszty();

    std::cout << std::endl;

    SamochodOsobowy so1(10, 20);
    t.WykonajTrase(so1, 100);
    t.WyswietlKoszty();

    std::cout << std::endl;

    SamochodCiezarowy sc1(20, 30, 1000, 2000);
    t.WykonajTrase(sc1, 100);
    t.WyswietlKoszty();

    return 0;
}