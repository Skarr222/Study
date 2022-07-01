#include <iostream>
#include <utility>
#include <vector>

void selection_sort(std::vector<int> &v)
{
    for (int j = 0; j < v.size(); ++j)
    {
        int m = j;
        for (int i = j; ++i < v.size();)
        {
            if (v[i] < v[m])
            {
                m = i;
            }
        }
        std::swap(v[j], v[m]);
    }
}

int main()
{
    std::vector<int> v{13, -2, 21, 5, -8, 5, 7, -10};
    selection_sort(v);
    for (int i = 0; i < v.size(); ++i)
    {
        std::cout << v[i] << " ";
    }
    std::cout << std::endl;

    for (std::vector<int>::iterator i = v.begin; i < v.end(); ++i)
    {
        std::cout << *i << " ";
    }
    std::cout << std::endl;
}