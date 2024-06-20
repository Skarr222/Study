
#include <iostream>
using namespace std;

double calculateMinRadius(int streetLength, int numberOfLanterns, int *lanterns)
{
    int maxDistanceBetweenLanterns = 0;
    for (int i = 0; i < numberOfLanterns - 1; i++)
    {
        if (lanterns[i + 1] - lanterns[i] > maxDistanceBetweenLanterns)
        {
            maxDistanceBetweenLanterns = lanterns[i + 1] - lanterns[i];
        }
    }
    double lanternRadius = maxDistanceBetweenLanterns;

    return lanternRadius;
}

int main()
{
    int streetLength, numberOfLanterns;
    cout << "Podaj dlugosc ulicy i ilosc latarni" << endl;
    cin >> streetLength >> numberOfLanterns;

    int *lanterns = new int[numberOfLanterns];

    for (int i = 0; i < numberOfLanterns; i++)
    {
        cout << "Podaj odleglosc " << i + 1 << " latarni od poczatku ulicy" << endl;
        cin >> lanterns[i];
    }

    double lanternRadius = calculateMinRadius(streetLength, numberOfLanterns, lanterns);
    cout << "Promien swiatla latarni: " << lanternRadius << endl;

    delete[] lanterns;
    return 0;
}
