#include <iostream>
#include <utility>
#include <vector>

void selection_sort(std::vector<int>::iterator b, std::vector<int>::iterator e)
{
    while (b < e)
    {
        auto m = b;
        for (std::vector<int>::iterator i = b; ++i < e;)
        {
            if (*i < *m)
            {
                m = i;
            }
        }
        std::iter_swap(b++, m);
    }
}

int main()
{
    std::vector<int> v{13, -2, 21, 5, -8, 5, 7, -10};
    selection_sort(v.begin() + 2, v.end());
    for (std::vector<int>::iterator i = v.begin(); i < v.end(); ++i)
    {
        std::cout << *i << " ";
    }
    std::cout << std::endl;
}