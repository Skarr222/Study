#include <iostream>
#include <vector>

using namespace std;

std::vector<int>::iterator partial_sum(std::vector<int>::const_iterator b, std::vector<int>::const_iterator e, std::vector<int>::iterator f)
{

    vector<int> vector = {};

    int sum = 0;

    while (b < e)
    {

        sum += *b;
        *f = sum;
        ++b;
        f++;
    }

    return f;
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