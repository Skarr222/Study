#include <iostream>
#include <string>
#include <cstdlib>
#include <unistd.h>
using namespace std;
class Przycisk
{
private:
    bool stan = false;
    string nazwa;
    string lokalizacja;

public:
    Przycisk(string nazwa, string lokalizacja)
    {
        this->nazwa = nazwa;
        this->lokalizacja = lokalizacja;
    }
    bool wlacznik()
    {
        return stan;
    }
    void wcisnij()
    {
        stan = !stan;
    }
    void sprawdz()
    {
        if (stan == true)
        {
            cout << "Przycisk w " << lokalizacja << " wcisniety" << endl;
        }
        else
        {
            cout << "Przycisk w " << lokalizacja << " zwolniony" << endl;
        }
    }
};
class Oswietlenie
{
private:
    bool stan = false;
    string nazwa;
    string lokalizacja;

public:
    Oswietlenie(string nazwa, string lokalizacja)
    {
        this->nazwa = nazwa;
        this->lokalizacja = lokalizacja;
    }
    void zapal()
    {
        stan = true;
    }
    void zgas()
    {
        stan = false;
    }
    bool czyZapalone()
    {
        return stan;
    }
    void czyZapalone1()
    {
        if (stan == true)
        {
            cout << "Swiatlo w " << lokalizacja << " zapalone" << endl;
        }
        else
        {
            cout << "Swiatlo w " << lokalizacja << " zgaszone" << endl;
        }
    }
};
class Czujniki
{
private:
    bool stan = false;
    string nazwa;
    string lokalizacja;

public:
    Czujniki(bool stan, string nazwa, string lokalizacja)
    {
        this->stan = stan;
        this->nazwa = nazwa;
        this->lokalizacja = lokalizacja;
    }
    void otworz()
    {
        stan = true;
    }
    void zamknij()
    {
        stan = false;
    }
    bool sprawdz()
    {
        return stan;
    }
};

void czyscEkran()
{
    system("cls");
}

void menu(Oswietlenie &o1, Oswietlenie &o2, Przycisk &p1, Przycisk &p2, Przycisk &alarm, Czujniki &czujnik1, Czujniki &czujnik2)
{
    int wybor;
    while (true)
    {
        czyscEkran();
        cout << "Menu:\n";
        cout << "1. Wcisnij przycisk\n";
        cout << "2. Wlacz alarm\n";
        cout << "3. Wylacz alarm\n";
        cout << "4. Wyjscie\n";
        cout << "Wybierz opcje: ";
        cin >> wybor;
        switch (wybor)
        {
        case 1:
            czyscEkran();
            cout << "Wybierz przycisk ktory chcesz wcisnac:\n";
            cout << "1. Salon\n";
            cout << "2. Kuchnia\n";

            cout << "Wybierz opcje: ";
            cin >> wybor;
            if (wybor == 1)
            {
                p1.wcisnij();

                p1.sprawdz();
                sleep(1);
            }
            else if (wybor == 2)
            {
                p2.wcisnij();
                p2.sprawdz();
                sleep(1);
            }
            break;
        case 2:
            czyscEkran();
            cout << "Alarm zostal wlaczony!\n";
            sleep(2);
            cout << "Sprawdzanie stanu czujnikow...\n";
            sleep(2);
            if (czujnik1.sprawdz() || czujnik2.sprawdz())
            {
                cout << "Alarm\n";
                cout << "Sygnalizacja alarmu\n";
                sleep(1);

                for (int i = 0; i < 7; ++i)
                {
                    o1.zapal();
                    o2.zgas();
                    cout << "Alarm migajacy - wlaczony\n";
                    sleep(1);
                }
                cout << "Alarm migajacy wylaczony\n";
                sleep(2);
            }
            else
            {
                cout << "Brak ruchu w domu.\n";
                sleep(2);
            }
            break;
        case 3:
            czyscEkran();
            cout << "Alarm zostal wylaczony.\n";
            sleep(2);
            break;
        case 5:
            return;
        default:
            cout << "Wybrano niedostepna opcje, sprobuj ponownie\n";
        }
    }
}

int main()
{
    Przycisk p1("p1", "Salon"), p2("p2", "Kuchnia"), alarm("a1", "Korytarz");
    Oswietlenie o1("s1", "Salon"), o2("s2", "Kuchnia");
    Czujniki czujnik1(false, "cz1", "Drzwi wejściowe"), czujnik2(false, "cz2", "Okno w salonie");
    ;
    menu(o1, o2, p1, p2, alarm, czujnik1, czujnik2);
}