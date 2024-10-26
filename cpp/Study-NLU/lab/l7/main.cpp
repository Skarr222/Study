#include <iostream>
#include <cmath>
//#define PI 3.14159265
//
//using namespace std;
//
//class Trapez
//{
//protected:
//    int a, b, c, d, h;
//
//public:
//    Trapez(int a, int b, int c, int d, int h)
//    {
//        this->a = a;
//        this->b = b;
//        this->c = c;
//        this->d = d;
//        this->h = h;
//    }
//    float pole()
//    {
//        return (a + b) * h / 2;
//    }
//    float obwod()
//    {
//        return a + b + c + d;
//    }
//};
//
//class Rownoleglobok : public Trapez
//{
//protected:
//    int alfa;
//
//public:
//    Rownoleglobok(int a, int b, int h) : Trapez(a, a, b, b, h) {}
//    Rownoleglobok(int a, int b, int h, int alfa) : Trapez(a, a, b, b, h), alfa(alfa) {}
//
//    float pole2()
//    {
//        return a * b * sin(alfa * PI / 180);
//    }
//    float obwod()
//    {
//        return 2 * a + 2 * b;
//    }
//};
//
//class Prostokat : public Rownoleglobok
//{
//public:
//        Prostokat(int a, int b): Rownoleglobok(a,b,b,90){}
//};
//class Deltoid{
//protected:
//    int a, b, e, f;
//public:
//    Deltoid(int a, int b, int e, int f): a(a), b(b), e(e), f(f){}
//
//    float pole(){
//        return e * f / 2;
//    }
//    float obwod(){
//        return a + b + a + b;
//    }
//};
//class Romb: public Deltoid , public Rownoleglobok{
//
//public:
//    Romb(int a , int h, int alfa): Rownoleglobok(a, a , h, alfa),  Deltoid(a,a,0,0) {}
//    Romb(int e, int f): Rownoleglobok(0,0,0,0), Deltoid(0,0,e,f){}
//    Romb(int a, int h, int e, int f, int alfa): Rownoleglobok(a,a,h,alfa), Deltoid(a,a,e,f){}
//};
//
//class Kwadrat:  public Romb{
//public:
//    Kwadrat(int a): Romb(a,a,0,0,90){}
//};
//
//

#include "Osoba.h"


int main()
{
    Osoba::~Osoba("Oskar", "Gomza", 2000);
    osoba.Wypisz();
    return 0;
}