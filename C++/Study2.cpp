#include <iostream>
#include <cmath>

/*
int g = 10;
int &function(){
    return g;
}

int main()
{
    std::cout << g << " " << function() << std::endl;
    function() = 12;
    std::cout << g << " " << function() << std::endl;
}
*/

/* Function for adding numbers */

/*
int add(int i1, int i2)
{
    int i = i1 + i2;
    return i;
}
Better pratctice would be : */

/*
int add(const int &i1, const int &i2)
{
    int i = i1 + i2;
    return i;
}
int main()
{
    int v = 3;
    const int c = 5;
    std::cout << add(v, v) << " "
              << add(c, c) << " "
              << add(7, 7) << std::endl;
}
*/
int main()
{
    x = 3
}