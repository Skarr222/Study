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
    auto i1 = std::find_if(s.begin(), s.end(), [](char c)
                           { return !(std::isspace(c)); });
    s.erase(s.begin(), i1);

    auto i2 = std::find_if(s.rbegin(), s.rend(), [](char c)
                           { return !(std::isspace(c)); });
    s.erase(i2.base(), s.end());
}

void contains(const std::string &s, const std::string &p)
{
    auto i = std::search(s.begin(), s.end(), p.begin(), p.end());
}

int main()
{
    std::string s = "   Hello world!     ";
    trim(s);
    bool result = contains(s, "lo");
    std::cout << std::boolalpha << result << std::endl;
}