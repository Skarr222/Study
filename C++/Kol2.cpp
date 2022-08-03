#include <iostream>
#include <cctype>
#include <string>
/*
std::string::iterator function(std::string::const_iterator begin_first, std::string::const_iterator end_first, std::string::iterator begin_second)
{
    for (std::string::const_iterator i = begin_first; i < end_first; i++)
    {
        if (std::isalnum(*i))
        {
            while (i < end_first && std::isalnum(*i))
            {
                *begin_second = *i;
                begin_second++;
                i++;
            }
            i--;
            *begin_second = ',';
        }
        else
            *begin_second = *i;
        begin_second++;
    }
    return begin_second;
}
*/

std::string::iterator function(std::string::const_iterator begin_first, std::string::const_iterator end_first, std::string::iterator begin_second)
{
    for (std::string::const_iterator i = begin_first; i < end_first && *begin_second != 0; i++)
    {
        if (std::isalnum(*i))
        {
            while (i < end_first && std::isalnum(*i) && *begin_second != 0)
            {
                *begin_second = *i;
                begin_second++;
                i++;
            }
            i--;

            if (*begin_second == 0)
                return begin_second;
            *begin_second = ',';
        }
        else
            *begin_second = *i;
        begin_second++;
    }
    return begin_second;
}

int main()
{
    std::string in = "peppermint 1001 bubbles balloon gum", out(100, '*');
    auto e = function(in.cbegin(), in.cend(), out.begin());
    int n = e - out.begin();
    std::string s = out.substr(0, n);
    bool b = (s == "peppermint, 1001, bubbles, balloon, gum,");
    std::cout << std::boolalpha << b << std::endl;
}
