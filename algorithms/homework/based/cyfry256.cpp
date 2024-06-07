#include <iostream>

using namespace std;

int cyfry(int k2, int k3, int k5, int k6)
{
    int l256 = 0;
    int l32 = 0;
    int suma = 0;
    int loop = k2 + k3 + k5 + k6;
    for (int i = 0; i < loop; i++)
    {

        if (k2 > 0 && k5 > 0 && k6 > 0)
        {
            l256++;
            k2--;
            k5--;
            k6--;
        }
        else if (k3 > 0 && k2 > 0)
        {
            l32++;
            k3--;
            k2--;
        }
    }
    suma = l256 * 256 + l32 * 32;
    return suma;
}

int main()
{
    int k2, k3, k5, k6;
    cin >> k2 >> k3 >> k5 >> k6;
    cout << cyfry(k2, k3, k5, k6) << endl;
    return 0;
}