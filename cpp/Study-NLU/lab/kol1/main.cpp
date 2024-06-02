#include <iostream>

using namespace std;
class Roslina
{
private:
    string nazwa;
    string typ;
    double wysokoscRosliny;
    double poziomNawodnienia;

public:
    Roslina() : nazwa(""), wysokoscRosliny(0), typ(""), poziomNawodnienia(0) {}
    Roslina(string nazwa, double wysokoscRosliny, string typ, double poziomNawodnienia) : nazwa(nazwa), wysokoscRosliny(wysokoscRosliny), typ(typ), poziomNawodnienia(poziomNawodnienia) {}
    ~Roslina()
    {
        std::cout << "Destruktor wywolany dla rosliny: " << nazwa << std::endl;
    }
    void setNazwa(string nazwa) { this->nazwa = nazwa; }
    void setTyp(string typ) { this->typ = typ; }
    void setWysokoscRosliny(double wysokoscRosliny) { this->wysokoscRosliny = wysokoscRosliny; }
    string getNazwa() const { return nazwa; }
    double getWysokoscRosliny() const { return wysokoscRosliny; }
    string getTyp() const { return typ; }

    void wyswietlInformacje() const
    {
        cout << "Nazwa: " << nazwa << ", Wysokosc: " << wysokoscRosliny << ", Typ: " << typ << endl;
    }
    void stanNawodnienia() const
    {
        cout << "Poziom nawodnienia: " << poziomNawodnienia << "%" << endl;
    }
    void zmienWysokosc(double nowaWysokosc)
    {
        wysokoscRosliny = nowaWysokosc;
    }

    void nawodnij(double iloscWody)
    {
        poziomNawodnienia += iloscWody;
        if (poziomNawodnienia > 100.0)
        {
            poziomNawodnienia = 100.0;
        }
        std::cout << "Roslina " << nazwa << " zostala podlana. Aktualny poziom nawodnienia: " << poziomNawodnienia << "%" << std::endl;
    }
    bool porownajWysokoscRoslin(const Roslina &innaRoslina) const
    {
        return wysokoscRosliny > innaRoslina.wysokoscRosliny;
    }
};

int main()
{
    Roslina roslina1;
    roslina1.setNazwa("Kaktus");
    roslina1.setTyp("Sukulent");
    roslina1.setWysokoscRosliny(10);
    roslina1.wyswietlInformacje();
    roslina1.stanNawodnienia();
    roslina1.nawodnij(50);
    roslina1.stanNawodnienia();

    Roslina roslina2("Fiolek", 10, "Roslina doniczkowa", 30);
    roslina2.wyswietlInformacje();
    roslina2.stanNawodnienia();
    roslina2.nawodnij(50);
    roslina2.stanNawodnienia();

    roslina1.porownajWysokoscRoslin(roslina2) ? cout << "Kaktus jest wyzszy od fiolka" << endl : cout << "Fiolek jest wyzszy od kaktusa" << endl;

    Roslina *roslina3 = new Roslina("Paprotka", 20, "Roslina doniczkowa", 40);
    roslina3->wyswietlInformacje();
    roslina3->stanNawodnienia();
    roslina3->nawodnij(30);
    roslina3->stanNawodnienia();

    delete roslina3;

    return 0;
}