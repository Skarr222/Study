#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

class Student
{
private:
    int idStudenta;
    string imie;
    double wynikiKolokwiow[3];
    double sredniWynik;

public:
    // Domyślny konstruktor
    Student() : idStudenta(0), imie(""), sredniWynik(0)
    {
        for (int i = 0; i < 3; ++i)
            wynikiKolokwiow[i] = 0;
    }

    // Konstruktor z parametrami
    Student(int id, string nazwa, double wyniki[3]) : idStudenta(id), imie(nazwa)
    {
        for (int i = 0; i < 3; ++i)
            wynikiKolokwiow[i] = wyniki[i];
        updateSredniWynik();
    }

    int getIdStudenta() const
    {
        return idStudenta;
    }

    string getImie() const
    {
        return imie;
    }

    void dodajWynik(int index, double wynik)
    {
        if (index >= 0 && index < 3)
        {
            wynikiKolokwiow[index] = wynik;
            updateSredniWynik();
        }
    }

    double getSredniWynik() const
    {
        return sredniWynik;
    }

    void wyswietlInformacje() const
    {
        cout << "ID: " << idStudenta << ", Imie: " << imie << ", Wyniki: ";
        for (int i = 0; i < 3; ++i)
        {
            cout << wynikiKolokwiow[i] << " ";
        }
        cout << ", Sredni wynik: " << sredniWynik << endl;
    }

private:
    void updateSredniWynik()
    {
        sredniWynik = (wynikiKolokwiow[0] + wynikiKolokwiow[1] + wynikiKolokwiow[2]) / 3.0;
    }
};

class Grupa
{
private:
    Student uczniowie[20];
    int liczbaUczniow;

public:
    Grupa() : liczbaUczniow(0) {}

    void dodajUcznia(const Student &uczen)
    {
        if (liczbaUczniow < 20)
        {
            uczniowie[liczbaUczniow++] = uczen;
        }
        else
        {
            cout << "Grupa jest pelna." << endl;
        }
    }

    void usunUcznia(int id_ucznia)
    {
        for (int i = 0; i < liczbaUczniow; ++i)
        {
            if (uczniowie[i].getIdStudenta() == id_ucznia)
            {
                for (int j = i; j < liczbaUczniow - 1; ++j)
                {
                    uczniowie[j] = uczniowie[j + 1];
                }
                --liczbaUczniow;
                cout << "Uczen o ID " << id_ucznia << " zostal usuniety." << endl;
                return;
            }
        }
        cout << "Uczen o ID " << id_ucznia << " nie zostal znaleziony." << endl;
    }

    void aktualizujWynikiUcznia(int id_ucznia, double wyniki[3])
    {
        for (int i = 0; i < liczbaUczniow; ++i)
        {
            if (uczniowie[i].getIdStudenta() == id_ucznia)
            {
                for (int j = 0; j < 3; ++j)
                {
                    uczniowie[i].dodajWynik(j, wyniki[j]);
                }
                cout << "Wyniki ucznia o ID " << id_ucznia << " zostaly zaktualizowane." << endl;
                return;
            }
        }
        cout << "Uczen o ID " << id_ucznia << " nie zostal znaleziony." << endl;
    }

    double getSredniWynikStudenta(int id_ucznia) const
    {
        for (int i = 0; i < liczbaUczniow; ++i)
        {
            if (uczniowie[i].getIdStudenta() == id_ucznia)
            {
                return uczniowie[i].getSredniWynik();
            }
        }
        cout << "Uczen o ID " << id_ucznia << " nie zostal znaleziony." << endl;
        return 0;
    }

    double getSredniaKlasy() const
    {
        double suma = 0;
        for (int i = 0; i < liczbaUczniow; ++i)
        {
            suma += uczniowie[i].getSredniWynik();
        }
        return liczbaUczniow > 0 ? suma / liczbaUczniow : 0;
    }

    void getNajlepszyINajgorszyWynik() const
    {
        if (liczbaUczniow == 0)
        {
            cout << "Brak uczniow w grupie." << endl;
            return;
        }

        const Student *najlepszyUczen = &uczniowie[0];
        const Student *najgorszyUczen = &uczniowie[0];

        for (int i = 1; i < liczbaUczniow; ++i)
        {
            if (uczniowie[i].getSredniWynik() > najlepszyUczen->getSredniWynik())
            {
                najlepszyUczen = &uczniowie[i];
            }
            if (uczniowie[i].getSredniWynik() < najgorszyUczen->getSredniWynik())
            {
                najgorszyUczen = &uczniowie[i];
            }
        }

        cout << "Najlepszy wynik: ";
        najlepszyUczen->wyswietlInformacje();
        cout << "Najgorszy wynik: ";
        najgorszyUczen->wyswietlInformacje();
    }

    void wyswietlWszystkichUczniow() const
    {
        cout << "Wszyscy uczniowie:" << endl;
        for (int i = 0; i < liczbaUczniow; ++i)
        {
            uczniowie[i].wyswietlInformacje();
        }
    }
};

int main()
{
    Grupa grupa;
    int wybor;
    do
    {
        cout << "==================================================" << endl;
        cout << "MENU" << endl;
        cout << "==================================================" << endl;
        cout << "1. Dodaj wpis." << endl;
        cout << "2. Usun wpis." << endl;
        cout << "3. Aktualizuj wpis." << endl;
        cout << "4. Wyswietl wszystkie wpisy." << endl;
        cout << "5. Oblicz srednia wynikow wybranego ucznia." << endl;
        cout << "6. Wyswietl srednia wynikow wybranego ucznia." << endl;
        cout << "7. Oblicz i wyswietl srednia wszystkich uczniow." << endl;
        cout << "8. Wyswietl najlepszy i najgorszy wynik (wraz z danymi uczniow, ktorzy go osiagneli)." << endl;
        cout << "9. Wyjscie." << endl;
        cout << "Wybierz opcje: ";
        cin >> wybor;

        switch (wybor)
        {
        case 1:
        {
            int id;
            double wynik1, wynik2, wynik3;
            string imie;
            cout << "Podaj Id ucznia: ";
            cin >> id;
            cout << "Podaj imie ucznia: ";
            cin >> imie;
            cout << "Podaj wyniki 3 kolokwiow: ";
            cin >> wynik1 >> wynik2 >> wynik3;
            double wyniki[3] = {wynik1, wynik2, wynik3};
            Student student(id, imie, wyniki);
            grupa.dodajUcznia(student);
            break;
        }
        case 2:
        {
            int id;
            cout << "Podaj ID ucznia do usuniecia: ";
            cin >> id;
            grupa.usunUcznia(id);
            break;
        }
        case 3:
        {
            int id;
            double wynik1, wynik2, wynik3;
            cout << "Podaj ID ucznia do aktualizacji: ";
            cin >> id;
            cout << "Podaj nowe wyniki 3 kolokwiow: ";
            cin >> wynik1 >> wynik2 >> wynik3;
            double wyniki[3] = {wynik1, wynik2, wynik3};
            grupa.aktualizujWynikiUcznia(id, wyniki);
            break;
        }
        case 4:
            grupa.wyswietlWszystkichUczniow();
            break;
        case 5:
        {
            int id;
            cout << "Podaj ID ucznia, dla ktorego chcesz obliczyc sredni wynik: ";
            cin >> id;
            cout << "Sredni wynik dla ucznia o ID " << id << " wynosi: " << grupa.getSredniWynikStudenta(id) << endl;
            break;
        }
        case 6:
        {
            int id;
            cout << "Podaj ID ucznia, ktorego sredni wynik chcesz wyswietlic: ";
            cin >> id;
            cout << "Sredni wynik dla ucznia o ID " << id << " wynosi: " << grupa.getSredniWynikStudenta(id) << endl;
            break;
        }
        case 7:
            cout << "Sredni wynik dla wszystkich uczniow wynosi: " << grupa.getSredniaKlasy() << endl;
            break;
        case 8:
            grupa.getNajlepszyINajgorszyWynik();
            break;
        case 9:
            cout << "Zamykanie programu." << endl;
            break;
        default:
            cout << "Nieprawidlowy wybór. Prosze podać liczbe od 1 do 9." << endl;
        }
    } while (wybor != 9);
    return 0;
}