//Grupa: Michał Chraniuk, Piotr Sondej, Oskar Gomza, Nataniel Gomza
#include <iostream>
#include <vector>

using namespace std;

class Pojazd {
public:
    string nazwa;
protected:
    string kolor;
    int liczbaKol;
private:
    static int licznikPojazdow;
public:
    Pojazd(string nazwa, string kolor, int liczbaKol) : nazwa(nazwa), kolor(kolor), liczbaKol(liczbaKol) { Pojazd::licznikPojazdow++; }

    ~Pojazd() = default;

    virtual void wypiszInformacje() {
        cout << "Pojazd: " << nazwa     << endl
             << "Kolor : " << kolor     << endl
             << "Kol   : " << liczbaKol << endl;
    }

    virtual void zaaktualizujDane() = 0;

    static int ilePojazdow() {
        return Pojazd::licznikPojazdow;
    }

    friend ostream& operator<<(ostream& os, const Pojazd& f);
};

int Pojazd::licznikPojazdow = 0;

ostream& operator<<(ostream& os, const Pojazd& p) {
    os << "[" << p.nazwa << "," << p.kolor << "," << p.liczbaKol << "]";
    return os;
}

class Samochod : public Pojazd {
private:
    int liczbaDrzwi;
public:
    Samochod(string nazwa, string kolor, int liczbaKol, int liczbaDrzwi) : Pojazd(nazwa, kolor, liczbaKol), liczbaDrzwi(liczbaDrzwi) { }

    void wypiszInformacje() override {
        Pojazd::wypiszInformacje();
        cout << "Liczba drzwi: " << liczbaDrzwi << endl;
    }

    void zaaktualizujDane() override {
        cout << "Podaj nowa nazwe:";
        cin >> this->nazwa;
        cout << "Podaj nowy kolor:";
        cin >> this->kolor;
        cout << "Podaj liczbe kol:";
        cin >> this->liczbaKol;
        cout << "Podaj liczbe drzwi:";
        cin >> this->liczbaDrzwi;
    }

    void zmienKolor (string kolor) {
        this->kolor = kolor;
    }
};

class Traktor : public Pojazd {
private:
    int mocSilnika;
public:
    Traktor(string nazwa, string kolor, int liczbaKol, int mocSilnika) : Pojazd(nazwa, kolor, liczbaKol), mocSilnika(mocSilnika) { }

    void wypiszInformacje() override {
        Pojazd::wypiszInformacje();
        cout << "Moc silnika: " << mocSilnika << "\n";
    }

    void zaaktualizujDane() override {
        string nowaNazwa;
        cout << "Podaj nowa nazwe:";
        cin >> nowaNazwa;
        string nowyKolor;
        cout << "Podaj nowy kolor:";
        cin >> nowyKolor;
        int nowaLiczbaKol;
        cout << "Podaj nowa liczbe kol:";
        cin >> nowaLiczbaKol;
        int nowaMocSilnika;
        cout << "Podaj nowa moc silnika:";
        cin >> nowaMocSilnika;
        nazwa = nowaNazwa;
        kolor = nowyKolor;
        liczbaKol = nowaLiczbaKol;
        mocSilnika = nowaMocSilnika;

    }

    bool operator> (Traktor& other) {
        return (mocSilnika > other.mocSilnika);
    }
};

class Kombajn : public Pojazd {
private:
    int szerokoscRobocza;
public:
    Kombajn(string nazwa, string kolor, int liczbaKol, int szerokoscRobocza) : Pojazd(nazwa, kolor, liczbaKol), szerokoscRobocza(szerokoscRobocza) { }

    void wypiszInformacje() override {
        Pojazd::wypiszInformacje();
        cout << "Szerokosc robocza: " << szerokoscRobocza << "\n";
    }

    void zaaktualizujDane() override {
        string nowaNazwa;
        cout << "Podaj nowa nazwe:";
        cin >> nowaNazwa;
        string nowyKolor;
        cout << "Podaj nowy kolor:";
        cin >> nowyKolor;
        int nowaLiczbaKol;
        cout << "Podaj nowa liczbe kol:";
        cin >> nowaLiczbaKol;
        int nowaSzerokoscRobocza;
        cout << "Podaj nowa szerokosc robocza:";
        cin >> nowaSzerokoscRobocza;
        nazwa = nowaNazwa;
        kolor = nowyKolor;
        liczbaKol = nowaLiczbaKol;
        szerokoscRobocza = nowaSzerokoscRobocza;
    }

    bool czySieZmiesci(int szerokoscDrogi) {
        if (szerokoscDrogi > szerokoscRobocza){
            return true;
        } else {
            return false;
        }
    }

    void czasZbioru(int powierzchnia) {
        int wydajnosc  = 100;
        double czasZbioru = (powierzchnia / szerokoscRobocza) * wydajnosc;

        cout << "Kombajn zbiera na powierzchni: " << powierzchnia << "m^2" << endl;
        cout << "Czas zbioru: " << czasZbioru << " min" << endl;
    }
};

class Motocykl : public Pojazd {
private:
    double poziomPaliwa;
    double srednieSpalanie;
public:
    Motocykl(string nazwa, string kolor, int liczbaKol, double poziomPaliwa, double srednieSpalanie) : Pojazd(nazwa, kolor, liczbaKol), poziomPaliwa(poziomPaliwa), srednieSpalanie(srednieSpalanie) { }

    void wypiszInformacje() override {
        cout << "Motocykl: " << endl;
        Pojazd::wypiszInformacje();
        cout << "Poziom paliwa: " << poziomPaliwa << "L" << endl;
        cout << "Srednie spalanie: " << srednieSpalanie << "/100km" << endl;
    }

    void zaaktualizujDane() override {
        string nowaNazwa;
        cout << "Podaj nowa nazwe:";
        cin >> nowaNazwa;
        cout << "Podaj nowy kolor:";
        cin >> kolor;
        cout << "Podaj nowa liczbe kol:";
        cin >> liczbaKol;
        cout << "Podaj nowy poziom paliwa:";
        cin >> poziomPaliwa;
        cout << "Podaj nowe srednie spalanie:";
        cin >> srednieSpalanie;

    }

    double getPoziomPaliwa() {
        return poziomPaliwa;
    }

    double getSrednieSpalanie() {
        return srednieSpalanie;
    }

    void zatankuj(double iloscPaliwa) {
        poziomPaliwa += iloscPaliwa;
    }

    bool czyMoznaJechac(double odleglosc) {
        return poziomPaliwa >= odleglosc * srednieSpalanie;
    }
};

int main () {

    //Test Samochod
    Samochod s1("Opel", "czarny", 4, 3);
    Samochod s2("Skoda", "zielony", 4, 5);

    s1.zmienKolor("rozowy");
    s1.wypiszInformacje();
    s1.zaaktualizujDane();
    cout << "Podstawowe dane pierwszego samochodu: " << s1 << endl;

    //Test Traktor
    Traktor t1("Traktor1", "bialy", 4, 200);
    Traktor t2("Traktor2", "czerwony", 4, 400);

    t1.wypiszInformacje();
    //t1.zaaktualizujDane();
    cout << "Podstawowe dane pierwszego traktora: " << t1 << endl;

    if (t1 > t2) {
        cout << "Traktor t1 ma więcej mocy niz traktor t2" << endl;
    } else {
        cout << "Traktor t1 ma mniej mocy niz traktor t2" << endl;
    }

    //Test Kombajn
    Kombajn k1("Kombajn1", "zolty", 6, 600);
    Kombajn k2("Kombajn2", "srebrny", 8, 800);

    k1.wypiszInformacje();
    //k1.zaaktualizujDane();
    cout << "Podstawowe dane pierwszego kombajnu: " << k1 << endl;

    if (k1.czySieZmiesci(1000)){
        cout << "Kombajn k1 zmiesci sie na drodze o szerokosci 10 metrow" << endl;
    } else {
        cout << "Kombajn k1 nie zmiesci sie na drodze o szerokosci 10 metrow" << endl;
    }

    k2.czasZbioru(1000);

    //Test Motocykl
    Motocykl m1("Motocykl1", "czarny", 2, 10.0, 4.5);
    Motocykl m2("Motocykl2", "fioletowy", 2, 15.0, 5.6);

    m1.wypiszInformacje();
    //m1.zaaktualizujDane();
    cout << "Podstawowe dane pierwszego motocykla: " << m1 << endl;

    if (m1.czyMoznaJechac(100)){
        cout << "Motocykl ma wystarczajaco paliwa\n";
    }else {
        cout << "Motocykl ma za malo paliwa!\n";
    }

    //Przechowanie wskaznikow do wszystkich obiektow oraz ich wyswietlenie
    cout << "---------------------------------------\n";
    cout << "Wszystkie pojazdy:" << endl;

    vector<Pojazd*> pojazdy;
    pojazdy.push_back(&s1);
    pojazdy.push_back(&s2);
    pojazdy.push_back(&t1);
    pojazdy.push_back(&t2);
    pojazdy.push_back(&k1);
    pojazdy.push_back(&k2);
    pojazdy.push_back(&m1);
    pojazdy.push_back(&m2);

    for (auto& pojazd : pojazdy) {
        cout << "------------------\n";
        pojazd->wypiszInformacje();
    }

    cout << "Wszystkich pojazdow: " << Pojazd::ilePojazdow() << endl;

    return 0;
}