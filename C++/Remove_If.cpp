#include <iostream>
#include <functional>
#include <vector>

std::vector<int>::iterator remove_if(std::vector<int>::iterator x, std::vector<int>::iterator y, [](int element)
                                     { return bool element; })
{
    auto = m;
    for (auto i = x; i < y; ++i)
    {
        if (i <=)
    }
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