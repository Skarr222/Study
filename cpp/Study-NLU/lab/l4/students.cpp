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
    double *wynikiKolokwiow;
    double sredniWynik;

public:
    Student(int id, string nazwa) : idStudenta(id), imie(nazwa)
    {
        this->wynikiKolokwiow = new double[3];
    }

    int getIdStudneta() const
    {
        return idStudenta;
    }

    string getImie() const
    {
        return imie;
    }

    void dodajWynik(int wynik)
    {
        updateSredniWynik();
    }

    double getSredniWynik()
    {
        return sredniWynik;
    }

private:
    void updateSredniWynik()
    {
    }
};
class Grupa
{
private:
public:
    void dodajUcznia(Student &uczen)
    {
    }

    void usunUcznia(int id_ucznia)
    {
    }

    void aktualizujWynikiUcznia(int id_ucznia)
    {
    }

    double getSredniWynikStudenta(int id_ucznia)
    {
    }

    double getSredniaKlasy()
    {
    }

    void getNajlepszyINajgorszyWynik()
    {
    }

    void wyswietlWszystkichUczniow()
    {
        cout << "Wszyscy uczniowie:" << endl;
    }
};

int main()
{
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
            int id, wynik1, wynik2, wynik3;
            string imie;
            cout << "Podaj Id ucznia: ";
            cin >> id;
            cout << "Podaj imie ucznia: ";
            cin >> imie;
            cout << "Podaj wyniki 3 kolokwiow: ";
            cin >> wynik1 >> wynik2 >> wynik3;
            Student student(id, imie);
            student.dodajWynik(wynik1);
            student.dodajWynik(wynik2);
            student.dodajWynik(wynik3);
            break;
        }
        case 2:
        {
            int id;
            cout << "Podaj ID ucznia do usunięcia: ";
            cin >> id;
            break;
        }
        case 3:
        {
            int id, wynik1, wynik2, wynik3;
            cout << "Podaj ID ucznia do aktualizacji: ";
            cin >> id;
            cout << "Podaj nowe wyniki 3 kolokwiow: ";
            cin >> wynik1 >> wynik2 >> wynik3;
            break;
        }
        case 4:
            break;
        case 5:
        {
            int id;
            cout << "Podaj ID ucznia, dla ktorego chcesz obliczyc sredni wynik: ";
            cin >> id;
            cout << "Sredni wynik dla ucznia o ID " << id << " wynosi: " << endl;
            break;
        }
        case 6:
        {
            int id;
            cout << "Podaj ID ucznia, którego średni wynik chcesz wyświetlić: ";
            cin >> id;
            cout << "Sredni wynik dla ucznia o ID " << id << " wynosi: " << endl;
            break;
        }
        case 7:
            cout << "Sredni wynik dla wszystkich uczniow wynosi: " << endl;
            break;
        case 8:
        {
            cout << "Najlepszy wynik: " << endl;
            cout << "Najgorszy wynik: " << endl;
            break;
        }
        case 9:
            cout << "Zamykanie programu." << endl;
            break;
        default:
            cout << "Nieprawidlowy wybór. Prosze podać liczbe od 1 do 9." << endl;
        }
    } while (wybor != 9);
}