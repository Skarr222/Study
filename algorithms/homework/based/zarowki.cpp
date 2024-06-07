#include <iostream>

using namespace std;

int zarowki(int n, int k, int *tab)
{
    int tempn[n] = {0};
    int zapalone = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < k; j++)
        {
            if (tab[j] == i + 1)
            {
                tempn[i]++;
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        if (tempn[i] % 2 != 0)
        {
            zapalone++;
        }
    }
    return zapalone;
};
int main()
{

    int n;
    int k;

    cin >> n >> k;
    int tab[k];
    for (int i = 0; i < k; i++)
    {
        cin >> tab[i];
    }

    cout << zarowki(n, k, tab) << endl;

    return 0;
}