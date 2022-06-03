#include <iostream>
#include <cmath>

int main()
{
    while (true)
    {
        double number;
        std::cout << "Enter positive number: ";
        std::cin >> number;
        std::cout << "Square root: " << std::sqrt(number) << std::endl;
    }
}
