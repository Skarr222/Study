#include <iostream>
#include <vector>

std::vector<int>::iterator partial_sum(std::vector<int>::const_iterator x, std::vector<int>::const_iterator y, std::vector<int>::iterator z)
{

    std::vector<int> vector = {};

    int sum = 0;

    while (x < y)
    {

        sum += *x;
        *z = sum;
        ++x;
        z++;
    }

    return z;
}

int main()
{
    std::vector<int> vector{3, 2, -1, 3, 4};
    auto result = partial_sum(vector.cbegin(), vector.cend(), vector.begin());
    for (auto iterator = vector.cbegin(); iterator < result;)
    {
        std::cout << *iterator++ << " ";
    }
    std::cout << std::endl;
}
