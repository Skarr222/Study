#include <iostream>
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
}