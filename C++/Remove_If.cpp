#include <iostream>
#include <functional>
#include <vector>

std::vector<int>::iterator remove_if(std::vector<int>::iterator x, std::vector<int>::iterator y, std::function<bool(int)> z)
{
    while (x < y)
    {
        *y = z(*x);
        x++;
        y++;
    }
    return y;
}

int main()
{
    std::vector<int> vector{-7, 5, 2, 2, 11, 2, 3};
    auto result = remove_if(vector.begin(), vector.end(),
                            [](int element)
                            { return element < 3; });
    for (auto iterator = vector.cbegin(); iterator < result;)
    {
        std::cout << *iterator++ << " ";
    }
    std::cout << std::endl;
}