/*
* 1. Napisz program, który w 10-elementowej tablicy jednowymiarowej o nazwie dane umieszcza
* liczby z przedziału od 0 do 9 a następnie wyświetla zawartość tablicy.
* 2. Napisz program, który w 10-elementowej tablicy jednowymiarowej o nazwie dane umieszcza
* liczby z przedziału od 9 do 0 a następnie wyświetla zawartość tablicy.
* 3. Napisz program, który w zadeklarowanej tablicy dwuwymiarowej 10 × 10 o nazwie macierz
* umieszcza na przekątnej liczbę 1, a poza przekątną 0. Dodatkowo program powinien obliczać
* sumę wyróżnionych w tablicy elementów, tzn. elementów znajdujących się na jej przekątnej.
* 4. Napisz program, który w zadeklarowanej tablicy dwuwymiarowej 10 × 10 umieszcza w
* pierwszej kolumnie liczby z przedziału od 0 do 9, w drugiej kolumnie kwadraty tych liczb, a w
* pozostałych kolumnach 0 (zobacz interpretację graficzną tablicy zamieszczoną po poleceniu).
* Dodatkowo program powinien obliczać sumę liczb znajdujących się w pierwszej kolumnie i
* sumę liczb znajdujących się w drugiej kolumnie.
* 5. Napisz program, który w 100-elementowej tablicy jednowymiarowej o nazwie dane
* umieszcza liczby z przedziału od 1 do 100, a następnie je sumuje. Do operacji sumowania
* zastosuj pętlę foreach.
* 6. Napisz program, który w 100-elementowej tablicy jednowymiarowej o nazwie dane
* umieszcza liczby z przedziału od 1 do 100, a następnie sumuje liczby parzyste i nieparzyste
* należące do tego przedziału. Do operacji sumowania zastosuj pętlę foreach.
* 7. Napisz program sumujący wartości dwóch macierzy. W pierwszym kroku poproś
* użytkownika o podanie rozmiaru macierzy. Następnie przy użyciu odpowiedniej pętli poproś
* użytkownika o wypełnienie wartościami macierzy A oraz macierzy B. Na końcu wyświetl
* wyniki sumowania macierzy.
* 8. Zadeklaruj dwie tablice typu int. Pierwszą tablicę wypełnij wartościami od 10 do 20 (11
* elementów). Druga tablica powinna zawierać o jeden element mniej (10 elementów).
* Zapełnij ją unikalnymi wartościami między 10 a 20. W efekcie w tablicy powinno brakować
* jednej wartości w porównaniu z pierwsza tablicą. Znajdź sposób na wyszukanie brakującej
* liczby w tabeli.
* 9. Utwórz tablicę o podanym przez użytkownika rozmiarze (pomiędzy 10 a 20). Wypełnij tablicę
* losowymi wartościami z zakresu od 1 do 20 a następnie posortuj elementy tablicy w rosnącej
* kolejności.
*/

using System;

class Program
{
    void Zadanie1()
    {
        System.Console.WriteLine("\n--- Zadanie 1: Wypełnianie tablicy liczbami od 0 do 9 ---");
        int[] dane = new int[10];
        for (int i = 0; i < dane.Length; i++)
        {
            dane[i] = i;
        }
        Console.WriteLine(string.Join(", ", dane));
        System.Console.WriteLine("\n");
    }

    void Zadanie2()
    {
        System.Console.WriteLine("\n--- Zadanie 2: Wypełnianie tablicy liczbami od 9 do 0 ---");
        int[] dane = new int[10];
        for (int i = 0; i < dane.Length; i++)
        {
            dane[i] = 9 - i;
        }
        Console.WriteLine(string.Join(", ", dane));
        System.Console.WriteLine("\n");
    }

    void Zadanie3()
    {
        System.Console.WriteLine("\n--- Zadanie 3: Macierz z przekątną ---");
        int[] macierz = new int[10, 10];
        int suma = 0;
        for (int i = 0; i < 10; i++)
        {
            macierz[i, i] = 1;
            suma += macierz[i, i];
        }
        Console.WriteLine("Suma przekątnej: " + suma);
        System.Console.WriteLine("\n");
    }

    void Zadanie4()
    {
        System.Console.WriteLine("\n--- Zadanie 4: Macierz z kolumnami i sumami ---");
        int[] macierz = new int[10, 10];
        int sumaPierwszaKolumna = 0;
        int sumaDrugaKolumna = 0;
        for (int i = 0; i < 10; i++)
        {
            macierz[i, 0] = i;
            macierz[i, 1] = i * i;
            sumaPierwszaKolumna += macierz[i, 0];
            sumaDrugaKolumna += macierz[i, 1];
        }
        Console.WriteLine("Suma pierwszej kolumny: " + sumaPierwszaKolumna);
        Console.WriteLine("Suma drugiej kolumny: " + sumaDrugaKolumna);
        System.Console.WriteLine("\n");
    }

    void Zadanie5()
    {
        System.Console.WriteLine("\n--- Zadanie 5: Sumowanie liczb w tablicy od 1 do 100 ---");
        int[] dane = new int[100];
        int suma = 0;
        for (int i = 0; i < dane.Length; i++)
        {
            dane[i] = i + 1;
            suma += dane[i];
        }
        Console.WriteLine("Suma liczb od 1 do 100: " + suma);
        System.Console.WriteLine("\n");
    }

    void Zadanie6()
    {
        System.Console.WriteLine(
            "\n--- Zadanie 6: Sumowanie liczb parzystych i nieparzystych w tablicy od 1 do 100 ---"
        );
        int[] dane = new int[100];
        int sumaParzyste = 0;
        int sumaNieparzyste = 0;
        for (int i = 0; i < dane.Length; i++)
        {
            dane[i] = i + 1;
            if (dane[i] % 2 == 0)
            {
                sumaParzyste += dane[i];
            }
            else
            {
                sumaNieparzyste += dane[i];
            }
        }
        Console.WriteLine("Suma liczb parzystych: " + sumaParzyste);
        Console.WriteLine("Suma liczb nieparzystych: " + sumaNieparzyste);
        System.Console.WriteLine("\n");
    }

    void Zadanie7()
    {
        System.Console.WriteLine("\n--- Zadanie 7: Sumowanie dwóch macierzy ---");
        Console.Write("Podaj rozmiar macierzy: ");
        int rozmiar = Convert.ToInt32(Console.ReadLine());
        int[,] macierzA = new int[rozmiar, rozmiar];
        int[,] macierzB = new int[rozmiar, rozmiar];
        int[,] sumaMacierzy = new int[rozmiar, rozmiar];

        Console.WriteLine("Wypełnij macierz A:");
        for (int i = 0; i < rozmiar; i++)
        {
            for (int j = 0; j < rozmiar; j++)
            {
                Console.Write($"A[{i},{j}]: ");
                macierzA[i, j] = Convert.ToInt32(Console.ReadLine());
            }
        }

        Console.WriteLine("Wypełnij macierz B:");
        for (int i = 0; i < rozmiar; i++)
        {
            for (int j = 0; j < rozmiar; j++)
            {
                Console.Write($"B[{i},{j}]: ");
                macierzB[i, j] = Convert.ToInt32(Console.ReadLine());
            }
        }

        for (int i = 0; i < rozmiar; i++)
        {
            for (int j = 0; j < rozmiar; j++)
            {
                sumaMacierzy[i, j] = macierzA[i, j] + macierzB[i, j];
            }
        }

        Console.WriteLine("Suma macierzy A i B:");
        for (int i = 0; i < rozmiar; i++)
        {
            for (int j = 0; j < rozmiar; j++)
            {
                Console.Write(sumaMacierzy[i, j] + " ");
            }
            Console.WriteLine();
        }
        System.Console.WriteLine("\n");
    }

    void Zadanie8()
    {
        System.Console.WriteLine("\n--- Zadanie 8: Znajdowanie brakującej liczby w tablicy ---");
        int[] tablica1 = new int[11];
        int[] tablica2 = new int[10];
        for (int i = 0; i < tablica1.Length; i++)
        {
            tablica1[i] = 10 + i;
        }
        Random rand = new Random();
        for (int i = 0; i < tablica2.Length; i++)
        {
            int liczba;
            do
            {
                liczba = rand.Next(10, 21);
            } while (Array.Exists(tablica2, element => element == liczba) || liczba == tablica1[i]);
            tablica2[i] = liczba;
        }
        foreach (var liczba in tablica1)
        {
            if (!Array.Exists(tablica2, element => element == liczba))
            {
                Console.WriteLine("Brakująca liczba: " + liczba);
                break;
            }
        }
        System.Console.WriteLine("\n");
    }

    void Zadanie9()
    {
        System.Console.WriteLine("\n--- Zadanie 9: Sortowanie tablicy losowych liczb ---");
        Console.Write("Podaj rozmiar tablicy (10-20): ");
        int rozmiar = Convert.ToInt32(Console.ReadLine());
        if (rozmiar < 10 || rozmiar > 20)
        {
            Console.WriteLine("Nieprawidłowy rozmiar tablicy.");
            return;
        }

        int[] tablica = new int[rozmiar];
        Random rand = new Random();
        for (int i = 0; i < rozmiar; i++)
        {
            tablica[i] = rand.Next(1, 21);
        }

        Array.Sort(tablica);
        Console.WriteLine("Posortowana tablica: " + string.Join(", ", tablica));
        System.Console.WriteLine("\n");
    }

    static void Main(string[] args)
    {
        int opcja;
        while (true)
        {
            Console.WriteLine("Witaj w programie! Wybierz opcję:");
            Console.WriteLine("Zadanie 1: Wypełnianie tablicy liczbami od 0 do 9");
            Console.WriteLine("Zadanie 2: Wypełnianie tablicy liczbami od 9 do 0");
            Console.WriteLine("Zadanie 3: Macierz z przekątną");
            Console.WriteLine("Zadanie 4:  Macierz z kolumnami i sumami");
            Console.WriteLine("Zadanie 5: Sumowanie liczb w tablicy od 1 do 100");
            Console.WriteLine(
                "Zadanie 6: Sumowanie liczb parzystych i nieparzystych w tablicy od 1 do 100"
            );
            Console.WriteLine("Zadanie 7: Sumowanie dwóch macierzy");
            Console.WriteLine("Zadanie 8: Znajdowanie brakującej liczby w tablicy");
            Console.WriteLine("Zadanie 9: Sortowanie tablicy losowych liczb");
            Console.WriteLine("-----------------------------------");
            Console.WriteLine("Aby zakończyć program, wpisz 0.");
            Console.WriteLine("-----------------------------------");
            Console.Write("Wybierz numer zadania (1-9): ");
            switch (opcja = Convert.ToInt32(Console.ReadLine()))
            {
                case 1:
                    Zadanie1();
                    break;
                case 2:
                    Zadanie2();
                    break;
                case 3:
                    Zadanie3();
                    break;
                case 4:
                    Zadanie4();
                    break;
                case 5:
                    Zadanie5();
                    break;
                case 6:
                    Zadanie6();
                    break;
                case 7:
                    Zadanie7();
                    break;
                case 8:
                    Zadanie8();
                    break;
                case 9:
                    Zadanie9();
                    break;
                case 0:
                    return;
            }
        }
    }
}
