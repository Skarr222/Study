#include <iostream>
#include <string>

int main()
{
    std::string s;

    while (std::getline(std::cin, s))
    {
        int j = s.find_first_not_of(" \t");          /*Wskazuje ostatni indeks w łańcuchu niebędący spacją lub tabulatorem */
        s.erase(j == std::string::npos ? 0 : j + 1); /* Funkcja npos ustala co metoda zwróci jeśli nie znajdzie czego szuka(pomiędzy dystrybucjami oporogramowania) */
        /* "erase" Usuwa spacje i tabulatory za ostatnim znakiem*/

        /*
      for (int i = 0; i < s.size(); ++i) Jest to funkcja find first not of wykonana za pomocą podstawowych funckji języka cpp
      {
          if (s[i] != ' ' && s[i] != '\t')
          {
              j = i;
          }
      }
      */
        std::cout << j << std::endl;
        std::cout << s << "|" << std::endl;
    }
}