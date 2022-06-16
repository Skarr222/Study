#include <iostream>

bool time()
{
    int godz, minu;
    std::cin >> godz >> minu;
    return ((godz >= 10 && godz < 18) && minu >= 30) || ((godz <= 18 && godz > 10) && minu <= 30);
}

int main()
{
    std::cout << std::boolalpha << time();
}
std::