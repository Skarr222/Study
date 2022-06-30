#include <vector>
#include <iostream>

std::vector<int>::iterator min_element(std::vector<int>::iterator x, std::vector<int>::iterator y)
{
    while (x < y)
    {
        auto min = x;
        for (auto iterator = x; iterator < y; ++iterator)
        {
            if (*iterator < *min)
            {
                min = iterator;
            }
        }

        return min;
    }
}

std::vector<int>::const_iterator min_element(std::vector<int>::const_iterator x, std::vector<int>::const_iterator y)
{
    while (x < y)
    {
        auto min = x;
        for (auto iterator = x; iterator < y; ++iterator)
        {
            if (*iterator < *min)
            {
                min = iterator;
            }
        }
        return min;
    }
}
int main()
{
    std::vector<int> vector{7, 5, 1, 12, 8};
    auto result1 = min_element(vector.begin(), vector.end());
    auto result2 = min_element(vector.cbegin(), vector.cend());
    std::cout << result1 - vector.begin() << " "
              << result2 - vector.cbegin() << std::endl;
}
