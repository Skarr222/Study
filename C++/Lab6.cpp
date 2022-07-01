#include <iostream>
#include <utility>
#include <vector>

void selection_sort(std::vector<int>::iterator b, std::vector<int>::iterator e)
{
    for (std::vector<int>::iterator j = b; j < e; ++j)
    {
        std::vector<int>::iterator m = j;
        for (std::vector<int>::iterator i = j; ++i < e;)
        {
            if (*i < *m)
            {
                m = i;
            }
        }
        std::swap(*j, *m);
    }
}

int main()
{
    std::vector<int> v{13, -2, 21, 5, -8, 5, 7, -10};
    selection_sort(v.begin(), v.end());
    for (std::vector<int>::iterator i = v.begin(); i < v.end(); ++i)
    {
        std::cout << *i << " ";
    }
    std::cout << std::endl;
}