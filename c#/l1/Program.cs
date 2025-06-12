using System;

class MainClass
{
    void Zadanie1_WyswietlenieLiczbyPi()
    {
        const double piValue = Math.PI;
        System.Console.WriteLine("\n--- Zadanie 1: Wyświetlanie Pi ---");
        System.Console.WriteLine($"Wartość liczby Pi wynosi:  {piValue.ToString("F5")}");
        System.Console.WriteLine("\n");
    }

    void Zadanie2_PromienKuli()
    {
        System.Console.WriteLine("\n--- Zadanie 2: Objętość kuli ---");
        Console.Write("Podaj promień kuli (r): ");
        double radius = Convert.ToDouble(Console.ReadLine());

        double volume = (4.0 / 3.0) * Math.PI * Math.Pow(radius, 3);

        Console.WriteLine(
            $"Objętość kuli o promieniu {radius.ToString("F2")} wynosi: {volume.ToString("F2")}"
        );
        System.Console.WriteLine("\n");
    }

    void Zadanie3_DzielenieBezReszty()
    {
        System.Console.WriteLine("\n--- Zadanie 3: Dzielenie bez reszty ---");
        int liczba1 = 66;
        int liczba2 = 7;

        int wynikDzielenia = liczba1 / liczba2;

        Console.WriteLine(
            $"Wynik dzielenia {liczba1}/{liczba2} bez reszty wynosi: {wynikDzielenia}"
        );
        System.Console.WriteLine("\n");
    }

    void Zadanie4_ResztaZDzielenia()
    {
        System.Console.WriteLine("\n--- Zadanie 4: Reszta z dzielenia ---");
        int liczba1 = 19;
        int liczba2 = 3;

        int reszta = liczba1 % liczba2;

        Console.WriteLine($"Reszta z dzielenia {liczba1}/{liczba2} wynosi: {reszta}");
        System.Console.WriteLine("\n");
    }

    void Zadanie5_SprawdzanieSłowaWZdaniu()
    {
        System.Console.WriteLine("\n--- Zadanie 5: Sprawdzanie słowa w zdaniu ---");
        Console.Write("Podaj pojedyncze słowo: ");
        string slowo = Console.ReadLine();

        Console.Write("Podaj dowolne zdanie: ");
        string zdanie = Console.ReadLine();

        bool zawiera = zdanie.Contains(slowo, StringComparison.OrdinalIgnoreCase);

        if (zawiera)
        {
            Console.WriteLine($"Zdanie '{zdanie}' zawiera słowo '{slowo}'.");
        }
        else
        {
            Console.WriteLine($"Zdanie '{zdanie}' NIE zawiera słowa '{slowo}'.");
        }
        System.Console.WriteLine("\n");
    }

    void Zadanie6_SprawdzaniePrzedziału()
    {
        System.Console.WriteLine("\n--- Zadanie 6: Sprawdzanie przedziału ---");
        Console.Write("Podaj pierwszą liczbę całkowitą: ");
        int liczba1 = Convert.ToInt32(Console.ReadLine());

        Console.Write("Podaj drugą liczbę całkowitą: ");
        int liczba2 = Convert.ToInt32(Console.ReadLine());

        bool liczba1WPrzedziale = (liczba1 >= -20 && liczba1 <= 10);
        bool liczba2WPrzedziale = (liczba2 >= -20 && liczba2 <= 10);

        if (liczba1WPrzedziale || liczba2WPrzedziale)
        {
            Console.WriteLine("Przynajmniej jedna z liczb mieści się w przedziale [-20, 10].");
            if (liczba1WPrzedziale)
            {
                Console.WriteLine($"Liczba {liczba1} mieści się w przedziale.");
            }
            if (liczba2WPrzedziale)
            {
                Console.WriteLine($"Liczba {liczba2} mieści się w przedziale.");
            }
        }
        else
        {
            Console.WriteLine("Żadna z liczb nie mieści się w przedziale [-20, 10].");
        }
        System.Console.WriteLine("\n");
    }

    void Zadanie7_KilometryNaMile()
    {
        System.Console.WriteLine("\n--- Zadanie 7: Konwersja Kilometry na Mile ---");
        const double MILES_PER_KM = 0.621371;

        Console.Write("Podaj wartość w kilometrach: ");
        double kilometers = Convert.ToDouble(Console.ReadLine());

        double miles = kilometers * MILES_PER_KM;

        Console.WriteLine($"{kilometers:F2} km to {miles:F2} mil.");
        System.Console.WriteLine("\n");
    }

    void Zadanie8_Kalkulator()
    {
        System.Console.WriteLine("\n--- Zadanie 8: Kalkulator ---");
        Console.Write("Podaj pierwszą liczbę: ");
        double liczba1 = Convert.ToDouble(Console.ReadLine());

        Console.Write("Podaj znak operacji (+, -, *, /): ");
        char operation = Convert.ToChar(Console.ReadLine());

        Console.Write("Podaj drugą liczbę: ");
        double liczba2 = Convert.ToDouble(Console.ReadLine());

        double wynik = 0;

        switch (operation)
        {
            case '+':
                wynik = liczba1 + liczba2;
                Console.WriteLine($"Wynik: {liczba1} + {liczba2} = {wynik:F2}");
                break;
            case '-':
                wynik = liczba1 - liczba2;
                Console.WriteLine($"Wynik: {liczba1} - {liczba2} = {wynik:F2}");
                break;
            case '*':
                wynik = liczba1 * liczba2;
                Console.WriteLine($"Wynik: {liczba1} * {liczba2} = {wynik:F2}");
                break;
            case '/':
                if (liczba2 != 0)
                {
                    wynik = liczba1 / liczba2;
                    Console.WriteLine($"Wynik: {liczba1} / {liczba2} = {wynik:F2}");
                }
                else
                {
                    Console.WriteLine("Błąd: Nie można dzielić przez zero!");
                }
                break;
            default:
                Console.WriteLine("Nieprawidłowy znak operacji.");
                break;
        }
        System.Console.WriteLine("\n");
    }

    void Zadanie9_KalkulatorKredytowy()
    {
        Console.WriteLine("\n--- Zadanie 9: Kalkulator rat kredytowych ---");
        Console.Write("Podaj kwotę kredytu (od 10000 do 100000 PLN): ");
        double kwota = Convert.ToDouble(Console.ReadLine());

        Console.Write("Podaj liczbę rat (od 6 do 96): ");
        int liczbaRat = Convert.ToInt32(Console.ReadLine());

        if (kwota < 10000 || kwota > 100000 || liczbaRat < 6 || liczbaRat > 96)
        {
            Console.WriteLine("Błąd: Nieprawidłowe dane wejściowe.");
            return;
        }

        double roczneOprocentowanie = 0.05;
        double odsetkiRoczne = kwota * roczneOprocentowanie;
        double odsetkiMiesieczne = odsetkiRoczne / 12;
        double rataKapitalowa = kwota / liczbaRat;
        double rataLaczna = rataKapitalowa + odsetkiMiesieczne;

        Console.WriteLine($"Twoja miesięczna rata wynosi: {rataLaczna:F2} PLN");
        System.Console.WriteLine("\n");
    }

    void Zadanie10_KalkulatorBMI()
    {
        Console.WriteLine("\n--- Zadanie 10: Kalkulator BMI ---");
        Console.Write("Podaj wagę w kilogramach: ");
        double waga = Convert.ToDouble(Console.ReadLine());

        Console.Write("Podaj wzrost w metrach (np. 1.75): ");
        double wzrost = Convert.ToDouble(Console.ReadLine());

        double bmi = waga / (wzrost * wzrost);
        Console.WriteLine($"Twoje BMI wynosi: {bmi:F2}");

        string wynik;
        if (bmi < 16)
            wynik = "wygłodzenie";
        else if (bmi < 17)
            wynik = "wychudzenie";
        else if (bmi < 18.5)
            wynik = "niedowaga";
        else if (bmi < 25)
            wynik = "wartość prawidłowa";
        else if (bmi < 30)
            wynik = "nadwaga";
        else if (bmi < 35)
            wynik = "I stopień otyłości";
        else if (bmi < 40)
            wynik = "II stopień otyłości";
        else
            wynik = "otyłość skrajna";

        Console.WriteLine($"Interpretacja: {wynik}");
        System.Console.WriteLine("\n");
    }

    void Zadanie11_MinMaxZ5Liczb()
    {
        Console.WriteLine("\n--- Zadanie 11: Najmniejsza i największa z 5 liczb ---");
        int[] liczby = new int[5];

        for (int i = 0; i < 5; i++)
        {
            Console.Write($"Podaj liczbę {i + 1}: ");
            liczby[i] = Convert.ToInt32(Console.ReadLine());
        }

        int min = liczby[0];
        int max = liczby[0];

        foreach (int liczba in liczby)
        {
            if (liczba < min)
                min = liczba;
            if (liczba > max)
                max = liczba;
        }

        Console.WriteLine($"Najmniejsza liczba: {min}");
        Console.WriteLine($"Największa liczba: {max}");
        System.Console.WriteLine("\n");
    }

    static void Main()
    {
        MainClass program = new MainClass();
        int opcja;

        while (true)
        {
            Console.WriteLine("Witaj w programie! Wybierz opcję:");
            Console.WriteLine("Zadanie 1: Wyświetlanie wartości Pi");
            Console.WriteLine("Zadanie 2: Obliczanie objętości kuli");
            Console.WriteLine("Zadanie 3: Dzielenie bez reszty");
            Console.WriteLine("Zadanie 4: Reszta z dzielenia");
            Console.WriteLine("Zadanie 5: Sprawdzanie słowa w zdaniu");
            Console.WriteLine("Zadanie 6: Sprawdzanie przedziału liczb");
            Console.WriteLine("Zadanie 7: Konwersja kilometrów na mile");
            Console.WriteLine("Zadanie 8: Kalkulator");
            Console.WriteLine("Zadanie 9: Kalkulator rat kredytowych");
            Console.WriteLine("Zadanie 10: Kalkulator BMI");
            Console.WriteLine("Zadanie 11: Najmniejsza i największa z 5 liczb");
            Console.WriteLine("-----------------------------------");
            Console.WriteLine("Aby zakończyć program, wpisz 0.");
            Console.WriteLine("-----------------------------------");
            Console.Write("Wybierz numer zadania (1-11): ");

            switch (opcja = Convert.ToInt32(Console.ReadLine()))
            {
                case 1:
                    program.Zadanie1_WyswietlenieLiczbyPi();
                    break;
                case 2:
                    program.Zadanie2_PromienKuli();
                    break;
                case 3:
                    program.Zadanie3_DzielenieBezReszty();
                    break;
                case 4:
                    program.Zadanie4_ResztaZDzielenia();
                    break;
                case 5:
                    program.Zadanie5_SprawdzanieSłowaWZdaniu();
                    break;
                case 6:
                    program.Zadanie6_SprawdzaniePrzedziału();
                    break;
                case 7:
                    program.Zadanie7_KilometryNaMile();
                    break;
                case 8:
                    program.Zadanie8_Kalkulator();
                    break;
                case 9:
                    program.Zadanie9_KalkulatorKredytowy();
                    break;
                case 10:
                    program.Zadanie10_KalkulatorBMI();
                    break;
                case 11:
                    program.Zadanie11_MinMaxZ5Liczb();
                    break;
                case 0:
                    return;
                default:
                    Console.WriteLine("Nieprawidłowy wybór. Wybierz numer od 1 do 8.");
                    continue;
            }
        }
    }
}
