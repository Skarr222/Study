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
/*
int main()
{
    double value;
    double value2;
    while (std::cin >> value)
    {
        std::cin >> value2;
        std::cout << value + value2 << std::endl;
    }
    /*
    bool result = bool(std::cin >> value);
    std::cout << std::boolalpha << result << std::endl;

}*/

int main()
{
    for (int i = 1; i <= 10; i++)
    {
        for (int j = 1; j <= 10; j++)
        {
            std::cout << i << "*" << j << "=";
            std::cout << i * j << "\t";
        }
        std::cout << std::endl;
    }
}