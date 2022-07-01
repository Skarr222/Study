#include <iostream>
#include <utility>
#include <vector>

void selection_sort(std::vector<int> &v)
{
    for (std::vector<int>::iterator j = v.begin(); j < v.end(); ++j)
    {
        std::vector<int>::iterator m = j;
        for (std::vector<int>::iterator i = j; ++i < v.end();)
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
    selection_sort(v);
    for (std::vector<int>::iterator i = v.begin; i < v.end(); ++i)
    {
        std::cout << *i << " ";
    }
    std::cout << std::endl;
}