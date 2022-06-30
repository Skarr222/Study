#include <cstdlib>
#include <ctime>
#include <iostream>

/*
int main()
{
    std::srand(std::time(nullptr));
    for (int i = 0; i < 10; ++i)
    {
        int a = 1 + std::rand() % 10;
        int b = 1 + std::rand() % 10;
        int u;
        do
        {
            std::cout << a << "  " << b << "  ";
            std::cin >> u;
        } while (u != a * b);
    }
}
*/

int main()
{
    double value;
    std::cin >> value;
    bool result = bool(std::cin >> value);
    std::cout << std::boolalpha << result << std::endl;
}