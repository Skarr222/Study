#include <cmath>
#include <iostream>
#include <cstdlib>
#include <ctime>

/*
const double pi = 4. * std::atan(1.);

double circle(double r)
{
    double area = pi * std::pow(r, 2);
    return area;
}

double triangle(double a, double b, double c)
{
    double p = (a + b + c) / 2.;
    double area = std::sqrt(p * (p - a) * (p - b) * (p - c));
    return area;
}

int main()
{
    std::cout << "Enter 1 for circle or 2 for triangle";
    int figure;
    std::cin >> figure;
    if (figure == 1)
    {
        std::cout << "Enter radius: ";
        double r;
        std::cin >> r;
        if (r > 0.)
        {
            std::cout << "Area is: " << circle(r) << std::endl;
        }
        else
        {
            std::cout << "Invalid radius" << std::endl;
        }
    }

    else if (figure == 2)
    {
        std::cout << "Enter sides: ";
        double a, b, c;
        std::cin >> a >> b >> c;
        if (a > 0. && b > 0. && c > 0.)
        {
            std::cout << "Area is: " << triangle(a, b, c) << std::endl;
        }
        else
        {
            std::cout << "Invalid sides" << std::endl;
        }
    }
    else
    {
        std::cout << "Invalid figure" << std::endl;
    }
}
*/

int main()
{
    std::srand(std::time(0));
    int computer = std::rand() % 2 * 2 - 1, player;
    std::cin >> player;
    std::cout << computer << std::endl;
    if (0 < computer * player)
    {
        std::cout << "true" << std::endl;
    }
    else
    {
        std::cout << "false" << std::endl;
    }
}