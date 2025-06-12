/*
*1. Utwórz prostą klasę o nazwie Osoba zawierającą dwa pola prywatne: imie
* oraz nazwisko. Wartości zmiennych powinny być inicjalizowane poprzez
* konstruktor przyjmujący dwa parametry o takich samych nazwach. Klasa
* powinna również definiować właściwość tylko do odczytu o nazwie
* PelnaNazwa, która zwraca tekst w formacie: imie nazwisko:

* 2. Zmodyfikuj rozwiązanie z zadanie 1 tak aby dodać właściwość
* MozeGlosowac która zwraca odpowiednią wartość bool na podstawie
* wieku. Zakładamy, że osoba może głosować mając co najmniej 18 lat.

* 3. Stwórz klasę modelującą prostokąt. Konstruktor klasy powinien
* przyjmować dwa parametry typu int: dlugosc, szerokosc.
* Klasa powinna również implementować prywatną metodę typu int o
* nazwie ObliczPole, która oblicza i zwraca pole prostokąta.
* Ostatnim elementem klasy powinna być właściwość zwracająca wartość
* obliczonego pola poprzez wywołanie prywatnej metody ObliczPole.
* Poproś użytkownika o podanie długości i szerokości a następnie utwórz
* egzemplarz klasy i wyświetl obliczone pole.

* 4. Napisz program definiujący dwie klasy: Bank i KontoBankowe.
* Klasa Bank powinna zawierać takie pola jak Nazwa, Adres oraz
* tablicę kont bankowych.
* Klasa KontoBankowe powinna zawierać pola Numer, Nazwisko,
* Saldo. Konto bankowe powinno również definiować dwie metody
* umożliwiające zasilenie konta oraz wypłatę środków z konta. Konto
* bankowe udostępnia również właściwość umożliwiającą
* wyświetlanie salda.
* Klasa Bank natomiast powinna udostępniać metodę umożliwiającą
* otworzenie nowego konta. Otworzenie jest równoznaczne z
* dodaniem go do listy konta bankowych w klasie Bank.
* Postaraj się w odpowiedni sposób zaplanować modyfikatory
* dostępów poszczególnych składowych klasy, w szczególności skup
* się na zabezpieczeniu wartości salda konta tak aby nie była możliwa
* jego zmiana z pominięciem wykonania operacji wpłaty lub wypłaty
* na konto.

* 5. Stwórz klasy Magazyn oraz Produkt. Klasa Produkt powinna
* zawierać odpowiedni konstruktor oraz takie pola jak nazwa,
* kategoria, cena, ilość. Klasa Magazyn natomiast powinna
* umożliwiać tworzenie nowych produktów, dodawanie i wydawanie
* do/z magazynu deklarowanej ilości danego produktu, wyświetlanie
* stanu magazynu (para: nazwa - ilość) oraz pobieranie listy
* produktów według podanej w parametrze kategorii.

* 6. Utwórz klasę Student z takimi polami jak nazwisko, identyfikator
* oraz listą jego ocen. Klasa ta powinna również definiować metodę
* dodającą ocenę oraz indeksator umożliwiający dostęp konkretnej
* oceny studenta.

* 7. Stwórz klasę Kalkulator która będzie udostępniała odpowiednie
* metody do wykonywania operacji arytmetycznych na dwóch i więcej
* argumentach typu int (słowo kluczowe params[] w parametrze
* metody). Kalkulator powinien „zapisywać w pamięci” każdą
* wykonaną operację oraz udostępniać metodę wyświetlającą historię
* operacji w formacie: nazwa operacji – wynik.

* 8. Utwórz klasę Samochód która zawiera pole przebieg. Klasa
* udostępnia również metodę rejestrującą tankowanie samochodu
* wraz z aktualnym przebiegiem. Ponadto klasa udostępnia
* właściwość wyświetlającą średnie spalanie. W razie potrzeby dodaj
* do klasy dodatkowo potrzebne pola.
*/

namespace L3
{
    class Osoba
    {
        private string imie;
        private string nazwisko;

        public Osoba(string imie, string nazwisko)
        {
            this.imie = imie;
            this.nazwisko = nazwisko;
        }

        public string PelnaNazwa
        {
            get { return $"{imie} {nazwisko}"; }
        }

        public bool MozeGlosowac(int wiek)
        {
            return wiek >= 18;
        }
    }

    class Prostokat
    {
        private int dlugosc;
        private int szerokosc;

        public Prostokat(int dlugosc, int szerokosc)
        {
            this.dlugosc = dlugosc;
            this.szerokosc = szerokosc;
        }

        private int ObliczPole()
        {
            return dlugosc * szerokosc;
        }

        public int Pole
        {
            get { return ObliczPole(); }
        }
    }

    class KontoBankowe
    {
        private string numer;
        private string nazwisko;
        private decimal saldo;

        public KontoBankowe(string numer, string nazwisko)
        {
            this.numer = numer;
            this.nazwisko = nazwisko;
            this.saldo = 0;
        }

        public void Zasil(int kwota)
        {
            if (kwota > 0)
                saldo += kwota;
        }

        public void Wyplac(int kwota)
        {
            if (kwota > 0 && kwota <= saldo)
                saldo -= kwota;
        }

        public decimal Saldo
        {
            get { return saldo; }
        }
    }

    class Bank
    {
        public string Nazwa { get; set; }
        public string Adres { get; set; }
        private List<KontoBankowe> konta;

        public Bank(string nazwa, string adres)
        {
            Nazwa = nazwa;
            Adres = adres;
            konta = new List<KontoBankowe>();
        }

        public void OtworzKonto(KontoBankowe konto)
        {
            konta.Add(konto);
        }

        public List<KontoBankowe> Konta
        {
            get { return konta; }
        }
    }

    class Produkt
    {
        public string Nazwa { get; set; }
        public string Kategoria { get; set; }
        public decimal Cena { get; set; }
        public int Ilosc { get; set; }

        public Produkt(string nazwa, string kategoria, decimal cena, int ilosc)
        {
            Nazwa = nazwa;
            Kategoria = kategoria;
            Cena = cena;
            Ilosc = ilosc;
        }
    }

    class Magazyn
    {
        private List<Produkt> produkty;

        public Magazyn()
        {
            produkty = new List<Produkt>();
        }

        public void DodajProdukt(Produkt produkt)
        {
            produkty.Add(produkt);
        }

        public void DodajDoMagazynu(string nazwa, int ilosc)
        {
            var produkt = produkty.FirstOrDefault(p => p.Nazwa == nazwa);
            if (produkt != null)
            {
                produkt.Ilosc += ilosc;
            }
        }

        public void WydajZMagazynu(string nazwa, int ilosc)
        {
            var produkt = produkty.FirstOrDefault(p => p.Nazwa == nazwa);
            if (produkt != null && produkt.Ilosc >= ilosc)
            {
                produkt.Ilosc -= ilosc;
            }
        }

        public void WyswietlStanMagazynu()
        {
            foreach (var produkt in produkty)
            {
                Console.WriteLine($"{produkt.Nazwa} - {produkt.Ilosc}");
            }
        }

        public List<Produkt> PobierzProduktyWKategorii(string kategoria)
        {
            return produkty.Where(p => p.Kategoria == kategoria).ToList();
        }
    }

    class Student
    {
        public string Nazwisko { get; set; }
        public string Identyfikator { get; set; }
        private List<int> oceny;

        public Student(string nazwisko, string identyfikator)
        {
            Nazwisko = nazwisko;
            Identyfikator = identyfikator;
            oceny = new List<int>();
        }

        public void DodajOcene(int ocena)
        {
            oceny.Add(ocena);
        }

        public int this[int index]
        {
            get { return oceny[index]; }
        }
    }

    class Kalkulator
    {
        private List<string> historia;

        public Kalkulator()
        {
            historia = new List<string>();
        }

        public int Dodaj(int a, int b)
        {
            int wynik = a + b;
            historia.Add($"Dodawanie {a} + {b} = {wynik}");
            return wynik;
        }

        public int Odejmij(int a, int b)
        {
            int wynik = a - b;
            historia.Add($"Odejmowanie {a} - {b} = {wynik}");
            return wynik;
        }

        public int Mnoz(int a, int b)
        {
            int wynik = a * b;
            historia.Add($"Mnożenie {a} * {b} = {wynik}");
            return wynik;
        }

        public int Dziel(int a, int b)
        {
            if (b == 0)
                throw new DivideByZeroException();
            int wynik = a / b;
            historia.Add($"Dzielenie {a} / {b} = {wynik}");
            return wynik;
        }

        public void WyswietlHistorie()
        {
            foreach (var operacja in historia)
            {
                Console.WriteLine(operacja);
            }
        }
    }

    class Samochod
    {
        private int przebieg;
        private List<int> tankowania;

        public Samochod()
        {
            przebieg = 0;
            tankowania = new List<int>();
        }

        public void RejestrujTankowanie(int przebieg)
        {
            this.przebieg = przebieg;
            tankowania.Add(przebieg);
        }

        public double SrednieSpalanie()
        {
            if (tankowania.Count == 0)
                return 0;
            return (double)przebieg / tankowania.Count;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            int opcja;
            while (true)
            {
                Console.WriteLine("Witaj w programie! Wybierz opcję:");
                Console.WriteLine("1. Zadanie 1 - Klasa Osoba");
                Console.WriteLine("2. Zadanie 2 - Klasa Osoba z MozeGlosowac");
                Console.WriteLine("3. Zadanie 3 - Klasa Prostokat");
                Console.WriteLine("4. Zadanie 4 - Klasy Bank i KontoBankowe");
                Console.WriteLine("5. Zadanie 5 - Klasy Magazyn i Produkt");
                Console.WriteLine("6. Zadanie 6 - Klasa Student");
                Console.WriteLine("7. Zadanie 7 - Klasa Kalkulator");
                Console.WriteLine("8. Zadanie 8 - Klasa Samochod");
                Console.WriteLine("-----------------------------------");
                Console.WriteLine("Aby zakończyć program, wpisz 0.");
                Console.WriteLine("-----------------------------------");
                Console.Write("Wybierz numer zadania (1-8): ");
                switch (opcja = Convert.ToInt32(Console.ReadLine()))
                {
                    case 1:
                        Console.Write("Podaj imię: ");
                        string imie = Console.ReadLine();
                        Console.Write("Podaj nazwisko: ");
                        string nazwisko = Console.ReadLine();
                        Osoba osoba = new Osoba(imie, nazwisko);
                        Console.WriteLine($"Pełna nazwa: {osoba.PelnaNazwa}");
                        Console.WriteLine("-----------------------------------");
                        break;
                    case 2:
                        Console.Write("Podaj imię: ");
                        imie = Console.ReadLine();
                        Console.Write("Podaj nazwisko: ");
                        nazwisko = Console.ReadLine();
                        osoba = new Osoba(imie, nazwisko);
                        Console.Write("Podaj wiek: ");
                        int wiek = Convert.ToInt32(Console.ReadLine());
                        Console.WriteLine($"Czy osoba może głosować? {osoba.MozeGlosowac(wiek)}");
                        Console.WriteLine("-----------------------------------");
                        break;

                    case 3:
                        Console.Write("Podaj długość prostokąta: ");
                        int dlugosc = Convert.ToInt32(Console.ReadLine());
                        Console.Write("Podaj szerokość prostokąta: ");
                        int szerokosc = Convert.ToInt32(Console.ReadLine());
                        Prostokat prostokat = new Prostokat(dlugosc, szerokosc);
                        Console.WriteLine($"Pole prostokąta: {prostokat.Pole}");
                        Console.WriteLine("-----------------------------------");
                        break;
                    case 4:

                        Bank bank = new Bank("Bank XYZ", "ul. Przykładowa 1");
                        Console.Write("Podaj numer konta: ");
                        string numerKonta = Console.ReadLine();
                        Console.Write("Podaj nazwisko właściciela konta: ");
                        string nazwiskoWlasciciela = Console.ReadLine();
                        KontoBankowe konto = new KontoBankowe(numerKonta, nazwiskoWlasciciela);
                        bank.OtworzKonto(konto);
                        Console.WriteLine($"Konto otwarte: {konto.Numer} - {konto.Nazwisko}");
                        Console.Write("Podaj kwotę do zasilenia konta: ");
                        int kwota = Convert.ToInt32(Console.ReadLine());
                        konto.Zasil(kwota);
                        Console.WriteLine($"Saldo konta: {konto.Saldo}");
                        Console.WriteLine("-----------------------------------");
                        Console.Write("Podaj kwotę do wypłaty z konta: ");
                        kwota = Convert.ToInt32(Console.ReadLine());
                        konto.Wyplac(kwota);
                        Console.WriteLine($"Saldo konta po wypłacie: {konto.Saldo}");
                        Console.WriteLine("-----------------------------------");
                        Console.WriteLine("Lista kont bankowych:");
                        foreach (var k in bank.Konta)
                        {
                            Console.WriteLine($"{k.Numer} - {k.Nazwisko} - Saldo: {k.Saldo}");
                        }
                        Console.WriteLine("-----------------------------------");
                        break;
                    case 5:
                        Magazyn magazyn = new Magazyn();
                        Console.Write("Podaj nazwę produktu: ");
                        string nazwaProduktu = Console.ReadLine();
                        Console.Write("Podaj kategorię produktu: ");
                        string kategoriaProduktu = Console.ReadLine();
                        Console.Write("Podaj cenę produktu: ");
                        decimal cenaProduktu = Convert.ToDecimal(Console.ReadLine());
                        Console.Write("Podaj ilość produktu: ");
                        int iloscProduktu = Convert.ToInt32(Console.ReadLine());
                        Produkt produkt = new Produkt(
                            nazwaProduktu,
                            kategoriaProduktu,
                            cenaProduktu,
                            iloscProduktu
                        );
                        magazyn.DodajProdukt(produkt);
                        Console.WriteLine($"Produkt dodany: {produkt.Nazwa} - {produkt.Ilosc}");
                        Console.WriteLine("-----------------------------------");
                        Console.Write("Podaj nazwę produktu do dodania do magazynu: ");
                        nazwaProduktu = Console.ReadLine();
                        Console.Write("Podaj ilość do dodania: ");
                        iloscProduktu = Convert.ToInt32(Console.ReadLine());
                        magazyn.DodajDoMagazynu(nazwaProduktu, iloscProduktu);
                        Console.WriteLine(
                            $"Dodano {iloscProduktu} sztuk produktu {nazwaProduktu} do magazynu."
                        );
                        Console.WriteLine("-----------------------------------");
                        Console.Write("Podaj nazwę produktu do wydania z magazynu: ");
                        nazwaProduktu = Console.ReadLine();
                        Console.Write("Podaj ilość do wydania: ");
                        iloscProduktu = Convert.ToInt32(Console.ReadLine());
                        magazyn.WydajZMagazynu(nazwaProduktu, iloscProduktu);
                        Console.WriteLine(
                            $"Wydano {iloscProduktu} sztuk produktu {nazwaProduktu} z magazynu."
                        );
                        Console.WriteLine("-----------------------------------");
                        Console.WriteLine("Stan magazynu:");
                        magazyn.WyswietlStanMagazynu();
                        Console.WriteLine("-----------------------------------");
                        Console.Write("Podaj kategorię do pobrania produktów: ");
                        string kategoria = Console.ReadLine();
                        var produktyWKategorii = magazyn.PobierzProduktyWKategorii(kategoria);
                        Console.WriteLine($"Produkty w kategorii {kategoria}:");
                        foreach (var p in produktyWKategorii)
                        {
                            Console.WriteLine($"{p.Nazwa} - {p.Ilosc}");
                        }
                        Console.WriteLine("-----------------------------------");

                        break;
                    case 6:
                        Console.Write("Podaj nazwisko studenta: ");
                        string nazwiskoStudenta = Console.ReadLine();
                        Console.Write("Podaj identyfikator studenta: ");
                        string identyfikatorStudenta = Console.ReadLine();
                        Student student = new Student(nazwiskoStudenta, identyfikatorStudenta);
                        Console.Write("Podaj ocenę do dodania: ");
                        int ocena = Convert.ToInt32(Console.ReadLine());
                        student.DodajOcene(ocena);
                        Console.WriteLine($"Ocena dodana: {ocena}");
                        Console.WriteLine("-----------------------------------");
                        Console.Write("Podaj indeks oceny do wyświetlenia: ");
                        int indeks = Convert.ToInt32(Console.ReadLine());
                        if (indeks >= 0 && indeks < student.Oceny.Count)
                        {
                            Console.WriteLine($"Ocena na indeksie {indeks}: {student[indeks]}");
                        }
                        else
                        {
                            Console.WriteLine("Indeks poza zakresem.");
                        }
                        Console.WriteLine("-----------------------------------");
                        break;
                    case 7:
                        Kalkulator kalkulator = new Kalkulator();
                        Console.Write("Podaj pierwszą liczbę: ");
                        int a = Convert.ToInt32(Console.ReadLine());
                        Console.Write("Podaj drugą liczbę: ");
                        int b = Convert.ToInt32(Console.ReadLine());
                        Console.WriteLine($"Dodawanie: {kalkulator.Dodaj(a, b)}");
                        Console.WriteLine($"Odejmowanie: {kalkulator.Odejmij(a, b)}");
                        Console.WriteLine($"Mnożenie: {kalkulator.Mnoz(a, b)}");
                        try
                        {
                            Console.WriteLine($"Dzielenie: {kalkulator.Dziel(a, b)}");
                        }
                        catch (DivideByZeroException)
                        {
                            Console.WriteLine("Błąd: Dzielenie przez zero.");
                        }
                        Console.WriteLine("-----------------------------------");
                        Console.WriteLine("Historia operacji:");
                        kalkulator.WyswietlHistorie();
                        Console.WriteLine("-----------------------------------");
                        break;
                    case 8:
                        Samochod samochod = new Samochod();
                        Console.Write("Podaj przebieg samochodu: ");
                        int przebieg = Convert.ToInt32(Console.ReadLine());
                        samochod.RejestrujTankowanie(przebieg);
                        Console.WriteLine($"Przebieg zarejestrowany: {przebieg}");
                        Console.WriteLine($"Średnie spalanie: {samochod.SrednieSpalanie()}");
                        Console.WriteLine("-----------------------------------");
                        Console.Write("Podaj nowy przebieg samochodu: ");
                        przebieg = Convert.ToInt32(Console.ReadLine());
                        samochod.RejestrujTankowanie(przebieg);
                        Console.WriteLine($"Nowy przebieg zarejestrowany: {przebieg}");
                        Console.WriteLine(
                            $"Średnie spalanie po rejestracji: {samochod.SrednieSpalanie()}"
                        );
                        Console.WriteLine("-----------------------------------");
                        break;
                    case 0:
                        return;
                }
            }
        }
    }
}
