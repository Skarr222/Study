#include <iostream>
#include <cstdlib>
using namespace std;

class Osoba {
protected:
    string id, imie, nazwisko;
public:
    Osoba(string &id, string &imie, string &nazwisko ) :  id(id), imie(imie), nazwisko(nazwisko){};

    virtual ~Osoba() = default;

    string getId()
    {
        return id;
    }

    virtual void wyswietlDane() {
        cout << "Dane osoby: " <<endl;
        cout << "Id: " << id << endl;
        cout << "Imie: " << imie << endl;
        cout << "Nazwisko: " << nazwisko << endl;
    };

    virtual void edytujDane() {
        cout << "Podaj nowe imie: ";
        cin.ignore();
        getline(cin, imie);
        cout << "Podaj nowe nazwisko: ";
        getline(cin, nazwisko);
    }
};

class Wykladowca : public Osoba {
private:
    string tytul;
public:
    Wykladowca( string &id, string &imie, string &nazwisko, string &tytul) : Osoba(id, imie, nazwisko ), tytul(tytul){};

    void wyswietlDane() override {
        cout << "Dane wykladowcy:"<< endl;
        cout << "Id: " << id << endl;
        cout << "Imie: " << imie << endl;
        cout << "Nazwisko: " << nazwisko << endl;
        cout << "Tytul: " << tytul << endl;
    }

    void edytujDane() override {
        cout << "Podaj nowe imie: ";
        cin.ignore();
        getline(cin, imie);
        cout << "Podaj nowe nazwisko: ";
        getline(cin, nazwisko);
        cout << "Podaj nowy tytul: ";
        getline(cin, tytul);
    }
};

class Licencjat : public Osoba {
private:
    string rok;
public:
    Licencjat( string id, string imie, string nazwisko, string rok) : Osoba(id,imie, nazwisko), rok(rok){};

    void wyswietlDane() override {
        cout << "Dane studenta licencjatu: "  << endl;
        cout << "Id: " << id << endl;
        cout << "Imie: " << imie << endl;
        cout << "Nazwisko: " << nazwisko << endl;
        cout << "Rok: " << rok << endl;
    }
    void edytujDane() override {
        cout << "Podaj nowe imie: ";
        cin.ignore();
        getline(cin, imie);
        cout << "Podaj nowe nazwisko: ";
        getline(cin, nazwisko);
        cout << "Podaj nowy rok: ";
        getline(cin, rok);
    }
};

class Magister : public Osoba
{
private:
    string idOpiekuna;
public:
    Magister(string id, string imie, string nazwisko,  string idOpiekuna) : Osoba(id, imie, nazwisko ), idOpiekuna(idOpiekuna){};

    void wyswietlDane() override {
        cout << "Dane studenta magistra: " << endl;
        cout << "Identyfikator Opiekuna: " << idOpiekuna << endl;
        cout << "Id: " << id << endl;
        cout << "Imie: " << imie << endl;
        cout << "Nazwisko: " << nazwisko << endl;
    }

    void edytujDane() override {
        cout << "Podaj nowy identyfikator opiekuna: ";
        cin.ignore();
        getline(cin, idOpiekuna);
        cout << "Podaj nowe imie: ";
        getline(cin, imie);
        cout << "Podaj nowe nazwisko: ";
        getline(cin, nazwisko);
    }
};
class Doktorant : public Osoba
{
private:
    string tematPracy;
public:
    Doktorant(string &id, string &imie, string &nazwisko, string &tematPracy) : Osoba(id, imie, nazwisko), tematPracy(tematPracy){};

    void wyswietlDane() override {
        cout << "Dane doktoranta: " << endl;
        cout << "Id: " << id << endl;
        cout << "Imie: " << imie << endl;
        cout << "Nazwisko: " << nazwisko << endl;
        cout << "Temat pracy: " << tematPracy << endl;
    }

    void edytujDane() override {
        cout << "Podaj nowe imie: ";
        cin.ignore();
        getline(cin, imie);
        cout << "Podaj nowe nazwisko: ";
        getline(cin, nazwisko);
        cout << "Podaj nowy temat pracy: ";
        getline(cin, tematPracy);
    }
};


void wyswietlWszystkieOsoby(Osoba *osoby[], int iloscOsob) {
    for (int i = 0; i < iloscOsob; i++) {
        osoby[i]->wyswietlDane();
    }
}

bool czyIdIstnieje(Osoba *osoby[], int iloscOsob, string id) {
    for (int i = 0; i < iloscOsob; i++) {
        if (osoby[i]->getId() == id)
        {
            return true;
        }
    }
    return false;
}

int main() {
    Osoba *osoby[20] = {nullptr};
    int iloscOsob = 0;
    bool programDziala = true;
    int wybor;
    string idOsobyEdytowanej;
    string idOsobyUsuwanej;
    string dodaneImie;
    int typOsoby;
    string dodaneNazwisko;
    string dodaneId;
    string tytul;
    string rok;
    string idOpiekuna;
    string tematPracy;

    while (programDziala) {
        cout << "1. Wyswietl wszystkie osoby" << endl;
        cout << "2. Wyswietl wykladowcow" << endl;
        cout << "3. Wyswietl studentow licencjackich" << endl;
        cout << "4. Wyswietl studentow magisterskich" << endl;
        cout << "5. Wyswietl doktorantow" << endl;
        cout << "6. Edytuj dane osoby" << endl;
        cout << "7. Usun osobe" << endl;
        cout << "8. Dodaj osobe" << endl;
        cout << "9. Wyczysc konsole" << endl;
        cout << "10. Wyjdz" << endl;
        cin >> wybor;

        switch (wybor) {
            case 1:
                wyswietlWszystkieOsoby(osoby, iloscOsob);
                break;
            case 2:
                for (int i = 0; i < iloscOsob; i++) {
                    if (dynamic_cast<Wykladowca *>(osoby[i])) {
                        osoby[i]->wyswietlDane();
                    }
                }
                break;
            case 3:
                for (int i = 0; i < iloscOsob; i++) {
                    if (dynamic_cast<Licencjat *>(osoby[i])) {
                        osoby[i]->wyswietlDane();
                    }
                }
                break;
            case 4:
                for (int i = 0; i < iloscOsob; i++) {
                    if (dynamic_cast<Magister *>(osoby[i])) {
                        osoby[i]->wyswietlDane();
                    }
                }
                break;
            case 5:
                for (int i = 0; i < iloscOsob; i++) {
                    if (dynamic_cast<Doktorant *>(osoby[i])) {
                        osoby[i]->wyswietlDane();
                    }
                }
                break;
            case 6:
                wyswietlWszystkieOsoby(osoby, iloscOsob);
                cout << "Podaj id osoby do edycji: ";
                cin >> idOsobyEdytowanej;
                if (iloscOsob == 0) {
                    cout << "Nie ma osob do edycji" << endl;
                    break;
                }
                if (!czyIdIstnieje(osoby, iloscOsob, idOsobyEdytowanej)) {
                    cout << "Osoba o podanym id nie istnieje" << endl;
                    break;
                }
                for (int i = 0; i < iloscOsob; i++) {
                    if (osoby[i]->getId() == idOsobyEdytowanej) {
                        osoby[i]->edytujDane();
                    }
                }
                break;
            case 7:
                wyswietlWszystkieOsoby(osoby, iloscOsob);
                cout << "Podaj id osoby do usuniecia: ";
                cin >> idOsobyUsuwanej;
                if (iloscOsob == 0) {
                    cout << "Nie ma osob do usuniecia" << endl;
                    break;
                }
                if (!czyIdIstnieje(osoby, iloscOsob, idOsobyUsuwanej)) {
                    cout << "Osoba o podanym id nie istnieje" << endl;
                    break;
                }
                for (int i = 0; i < iloscOsob; i++) {
                    if (osoby[i]->getId() == idOsobyUsuwanej) {
                        delete osoby[i];
                        for (int j = i; j < iloscOsob - 1; j++) {
                            osoby[j] = osoby[j + 1];
                        }
                        iloscOsob--;
                        break;
                    }
                }
                break;
            case 8:
                if (iloscOsob >= 20) {
                    cout << "Nie mozna dodac wiecej osob" << endl;
                    break;
                }
                cout << "Jaki typ osoby chcesz dodac?" << endl;
                cout << "1. Dodaj wykladowce" << endl;
                cout << "2. Dodaj studenta licencjata" << endl;
                cout << "3. Dodaj studenta magistra" << endl;
                cout << "4. Dodaj doktoranta" << endl;
                cin >> typOsoby;
                if (typOsoby < 1 || typOsoby > 4) {
                    cout << "Nie ma takiej opcji. Podaj liczbe od 1 do 4" << endl;
                    break;
                }
                cin.ignore();
                cout << "Podaj imie: ";
                getline(cin, dodaneImie);
                cout << "Podaj nazwisko: ";
                getline(cin, dodaneNazwisko);
                cout << "Podaj id: ";
                getline(cin, dodaneId);
                if (czyIdIstnieje(osoby, iloscOsob, dodaneId)) {
                    cout << "Osoba o podanym id juz istnieje" << endl;
                    break;
                }
                if (typOsoby == 1) {
                    cout << "Podaj tytul: ";
                    getline(cin, tytul);
                    osoby[iloscOsob] = new Wykladowca(dodaneId, dodaneImie, dodaneNazwisko, tytul);
                }
                else if (typOsoby == 2) {
                    cout << "Podaj rok: ";
                    getline(cin, rok);
                    osoby[iloscOsob] = new Licencjat(dodaneId, dodaneImie, dodaneNazwisko, rok);
                }
                else if (typOsoby == 3) {
                    cout << "Podaj id opiekuna: ";
                    getline(cin, idOpiekuna);
                    osoby[iloscOsob] = new Magister(dodaneId, dodaneImie, dodaneNazwisko, idOpiekuna);
                }
                else if (typOsoby == 4) {
                    cout << "Podaj temat pracy: ";
                    getline(cin, tematPracy);
                    osoby[iloscOsob] = new Doktorant(dodaneId, dodaneImie, dodaneNazwisko, tematPracy);
                }
                iloscOsob++;
                break;
            case 9:
                system("cls");
                break;
            case 10:
                programDziala = false;
                break;
            default:
                cout << "Wybrano niedostepna opcje. Podaj liczbe od 1 do 10" << endl;
        }
    }
    for (int i = 0; i < iloscOsob; i++) {
        delete osoby[i];
    }
    return 0;
}