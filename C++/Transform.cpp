#include <iostream>
#include <functional>
#include <vector>

std::vector<int>::iterator transform(std::vector<int>::const_iterator x, std::vector<int>::const_iterator y, std::vector<int>::iterator f, std::function<int(int)> z)
{

    while (x < y)
    {
        *f = z(*x);
        x++;
        f++;
    }

    return f;
}

int main()
{
    std::vector<int> vector1{-7, 5, 1, 2, 11};
    std::vector<int> vector2(5);
    auto result = transform(vector1.cbegin(), vector1.cend(), vector2.begin(),
                            [](int element)
                            { return element * element; });
    for (auto iterator = vector2.cbegin(); iterator < result;)
    {
        std::cout << *iterator++ << " ";
    }
    std::cout << std::endl;
}
