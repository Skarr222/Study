#include <iostream>
#include <cctype>
#include <algorithm>

bool blank(const std::string &s)
{
    std::all_of(s.begin(), s.end(), [](char c)
                { return std::isspace(c); });
}
void trim(std::string &s)
{
    auto i = std::find_if(s.begin(), s.end(), [](char c)
                          { return !(std::isspace(c)); });
    s.erase(s.begin(), i);
}

int main()
{
    std::string s = "   Hello world!     ";
    for (std::string::iterator i = s.begin(); i < s.end(); ++i)
    {
        std::cout << *i;
    }
    trim(s);
    std::cout << std::endl;
}