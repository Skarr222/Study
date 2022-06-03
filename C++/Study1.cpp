#include <iostream>
#include <cmath>

int main()
{
    while (true)
    {
        double number;
        std::cout << "Enter positive number: ";
        std::cin >> number;
        if (number < 0.)
        {
            continue;
        }
        if (number == 0.)
        {
            break;
        }
        std::cout << "Square root: " << std::sqrt(number) << std::endl;
    }
    std::cout << "Thank you!" << std::endl;
}
