#include <iostream>
#include <vector>

/*
void clock(double &s, double &l, int h, int m)
{
    double s = (h % 12) * 30. + m / 2.;
    double l = m * 6.;
}

int main()
{
    double s, l;
    int h, m;
    std::cin >> h, m;
    clock(s, l, h, m);

    std::cout << s << " " << l << std::endl;
}*/

/*
void bubble_sort(std::vector<int> &v)
{
    bool unordered;
    do
    {
        unordered = false;
        for (int i = 0; i < v.size() - 1; ++i)
        {
            if (v[i] > v[i + 1])
            {
                int x = v[i];
                v[i] = v[i + 1];
                v[i + 1] = x;
                unordered = true;
            }
        }
    } while (unordered);
}

int main()
{
    std::vector<int> v;

    for (int x; std::cin >> x;)
    {
        v.push_back(x);
    }

    bubble_sort(v);

    for (int i = 0; i < v.size(); ++i)
    {
        std::cout << v[i] << "";
    }
    std::cout << std::endl;
}
*/

int main()
{
    double speed;
    std::cin >> speed;
    std::vector<double> v = {0.5, 6.5, 11.5, 19.5, 29.5, 39.5, 50.5, 62.5, 75.5, 87.5, 102.5, 117.5};
}