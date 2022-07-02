#include <iostream>
#include <string>
#include <cctype>

/*Napisz funkcję function, która przyjmuje niemodyfikujący iterator początkowy i końcowy wycinka łańcucha tekstowego oraz modyfikujący iterator początkowy innego wycinka.
Funkcja przepisuje zawartość pierwszego wycinka do drugiego zamieniając każdą sekwencję znaków białych na pojedynczą spację.
Funkcja zwraca modyfikujący iterator następnego znaku za ostatnim wpisanym.
Funkcja powinna być przystosowana do użycia w przykładowym programie poniżej. Funkcja korzysta tylko z plików nagłówkowych cctype i string.*/
/*
std::string::iterator function(std::string::const_iterator b, std::string::const_iterator e, std::string::iterator f)
{

    for (auto n = b + 1; n != e; ++b, ++n)
    {
        *f++ = *b;
        if ((isalpha(*b) && isdigit(*n)) || (isdigit(*b) && isalpha(*n)))
        {
            *f++ = *b;
        }
    }
    return f;
}
*/
std::string::iterator function(std::string::const_iterator b, std::string::const_iterator e, std::string::iterator f)
{

    for (auto i = b; i != e; i++, f++)
    {
        if (*i == '\r' && *(i + 1) == '\n')
        {
            *f = ' ';
            i++;
        }

        else if (*i == ' ')
        {
            *f = ' ';
            *++f = ' ';
        }
        else
        {
            *f = *i;
        }
    }

    return f;
}

int main()
{
    std::string in = " peppermint 1001 bubbles balloon gum\t\r\n", out(100, '*');
    auto e = function(in.cbegin(), in.cend(), out.begin());
    int n = e - out.begin();
    std::string s = out.substr(0, n);
    bool b = (s == "peppermint 1001 bubbles balloon gum");
    std::cout << std::boolalpha << b << std::endl;
    std::cout << s << "|" << std::endl;
}