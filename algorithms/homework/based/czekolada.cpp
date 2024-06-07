#include <iostream>

using namespace std;

bool czekolada(int n, int m, int k)
{
    if ((k % n == 0 && k / n < m) || (k % m == 0 && k / m < n))
    {
        return true;
    }
    else
    {
        return false;
    }
}

int main()
{
    int n, m, k;
    cin >> n >> m >> k;
    if (czekolada(n, m, k))
    {
        cout << "TAK";
    }
    else
    {
        cout << "NIE";
    }
    return 0;
}