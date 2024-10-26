#include <iostream>
using namespace std;
class Osoba {
protected:
    string imie, plec;
public:
    Osoba(){}
    Osoba(string imie, string plec) : imie(imie), plec(plec) { }
    void wyswietlInformacje() {
        cout << "Imie: " << imie << endl;
        cout << "Plec:" << plec << endl;
    }
};
class Punktacja {
protected:
    double maksymalnaPunktacja;
    double otrzymanaPunktacja;
    double procent;
public:
    Punktacja(){}
    Punktacja(double maksymalnaPunktacja, double otrzymanaPunktacja): maksymalnaPunktacja(maksymalnaPunktacja), otrzymanaPunktacja(otrzymanaPunktacja){
        this->procent = otrzymanaPunktacja/maksymalnaPunktacja*100;
    }
    void getProcent() {
        cout << "Procent: " << procent << "%" << endl;
    }
};
class Student : public Osoba {
private:
    Punktacja punktacja;
public:
    static int liczbaStudentow;
    Student():Osoba(){}
    Student(string imie, string plec, double maksymalnaPunktacja, double otrzymanaPunktacja) : Osoba(imie, plec), punktacja( maksymalnaPunktacja, otrzymanaPunktacja) {
        liczbaStudentow++;
    }
    void wyswietlInformacje () {
        Osoba::wyswietlInformacje();
        punktacja.getProcent();
    }
    static void wypiszLiczbeStudentow() {
        cout << "Liczba studentow: " << liczbaStudentow << endl;
    }
};
void wyswietlMenu()
{
    std::cout << "====Menu====";
    std::cout << "1. Dodaj Studenta\n";
    std::cout << "2. Usun Studenta\n";
    std::cout << "3. Wyswietl Studentow\n";
    std::cout << "4. Koniec\n";
}
int Student::liczbaStudentow = 0;
int main() {
    char odpowiedz;
    string imie;
    string plec;
    int punktyZdobyte;
    int maksymalnePunkty;
    Student tab[10];
    do
    {
        wyswietlMenu();
        switch(odpowiedz){
            case '1':{
                cout << "Podaj imie: ";
                cin >> imie;
                cout << "Podaj plec: ";
                cin >> plec;
                cout << "Podaj punkty maksymalne: ";
                cin >> maksymalnePunkty;
                cout << "Podaj punkty zdobyte przez studenta: ";
                cin >> punktyZdobyte;
                Student s(imie, plec, maksymalnePunkty, punktyZdobyte);
                tab[Student::liczbaStudentow] = s;
                break;

            }
        }
        std::cin >> odpowiedz;
    } while (odpowiedz != '4');
    Student s1("Jan", "Kowalski", 100, 66);
    s1.wyswietlInformacje();
    Student s2("Adam", "M", 100, 40);
    s2.wyswietlInformacje();
    s1.wyswietlInformacje();
    Student::wypiszLiczbeStudentow();
    return 0;
}