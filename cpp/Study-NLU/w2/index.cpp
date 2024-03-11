#include <iostream>
class Towar{
    private:
        std::string nazwa;
        std::string kod;
        static int liczbaTowarow;
    public:
    Towar(string nazwa, string kod):nazwa(nazwa),:kod(kod)
    
    {
        liczbaTowarow++;
    }
    void Wyswietl(
        {
            std::cout << std::endl;
            std::cout << nazwa  << std::endl
            std::cout << kod << std::endl;
        }
    )
}
int Towar::liczbaTowarow = 0;

int main(){
    std::cout << "Wykład 2";
    Towar t1("Towar 1", "T1");
    t1.Wyswietl();
    Towar t2("Towar 2", "T2");
    t2.Wyswietl();
    std::cout << "Liczba towarow: " << Towar::liczbaTowarow << std::endl;
    return 0;
}
