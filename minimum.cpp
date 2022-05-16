#include <iostream>

int main ()
{
    double m;
    if (!(std::cin >> m))
    {
    return 0;
    }
    else
    {
        for(double v; std::cin>>v;)
        {
            if (v<m){
            m = v;}
        }
    }
    std::cout << m << std::endl;
}
