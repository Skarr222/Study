#include <vector>
#include <iostream>

std::vector<int>::iterator min_element(std::vector<int>::iterator b, std::vector<int>::iterator e)
{
    while (b < e)
    {
        auto min = b;
        for (auto iterator = b; iterator < e; ++iterator)
        {
            if (*iterator < *min)
            {
                min = iterator;
            }
        }

        return min;
    }
}

std::vector<int>::const_iterator min_element(std::vector<int>::const_iterator b, std::vector<int>::const_iterator e)
{
    while (b < e)
    {
        auto min = b;
        for (auto iterator = b; iterator < e; ++iterator)
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
