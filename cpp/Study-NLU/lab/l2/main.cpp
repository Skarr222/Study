#include <iostream>

class MyWater
{
private:
    double sumaWody;
    int liczbaButelekS, liczbaButelekM, liczbaButelekL;
    static double pojemonscS, pojemonscM, pojemonscL;

public:
    MyWater() : sumaWody(0), liczbaButelekS(0), liczbaButelekM(0), liczbaButelekL(0) {}
    void addSmallWater(int ilosc)
    {
        sumaWody += pojemonscS * ilosc;
        liczbaButelekS += ilosc;
    }
    void addMediumWater(int ilosc)
    {
        sumaWody += pojemonscM * ilosc;
        liczbaButelekM += ilosc;
    }
    void addLargeWater(int ilosc)
    {
        sumaWody += pojemonscL * ilosc;
        liczbaButelekL += ilosc;
    }
    void showSum()
    {
        std::cout << "Suma wody: " << sumaWody << "L" << std::endl;
        std::cout << "Liczba butelek S: " << liczbaButelekS << std::endl;
        std::cout << "Liczba butelek M: " << liczbaButelekM << std::endl;
        std::cout << "Liczba butelek L: " << liczbaButelekL << std::endl;
    }
    void setSmallWaterCapacity(int capacity)
    {
        pojemonscS = capacity;
    }
    void setMediumWaterCapacity(int capacity)
    {
        pojemonscM = capacity;
    }
    void setLargeWaterCapacity(int capacity)
    {
        pojemonscL = capacity;
    }
};
double MyWater::pojemonscS = 0.5;
double MyWater::pojemonscM = 1;
double MyWater::pojemonscL = 2;
int main()
{
    MyWater woda;
    woda.addSmallWater(5);
    woda.addMediumWater(3);
    woda.addLargeWater(2);
    woda.showSum();

    MyWater woda2;
    woda2.setSmallWaterCapacity(0.3);
    woda2.setMediumWaterCapacity(0.7);
    woda2.setLargeWaterCapacity(1.5);
    woda2.addSmallWater(5);
    woda2.addMediumWater(3);
    woda2.addLargeWater(2);
    woda2.showSum();

    return 0;
}