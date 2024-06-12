#include <iostream>
using namespace std;

void quickSort(int *tabela, int lewaStrona, int prawaStrona)
{
    // Sprawdzamy, czy lewa strona jest większa lub równa prawej stronie.
    // Jeśli tak, kończymy funkcję, ponieważ nie ma już nic do sortowania.
    if (lewaStrona >= prawaStrona)
    {
        return;
    }
    // Ustawiamy indeksy lewej i prawej strony.
    int indexLewaStrona = lewaStrona;
    int indexPrawaStrona = prawaStrona;
    // Wybieramy pivot (jest to wartość względem, której będziemy sortować tablice) jako środkowy element tablicy.
    int pivot = tabela[(lewaStrona + prawaStrona) / 2];
    while (true)
    {
        // Szukamy elementu większego pivotowi po lewej stronie.
        while (tabela[indexLewaStrona] < pivot)
            indexLewaStrona++;
        // Szukamy elementu mniejszego pivotowi po prawej stronie.
        while (tabela[indexPrawaStrona] > pivot)
            indexPrawaStrona--;

        // Sprawdzamy, czy indeksy się nie przekroczyły.
        if (indexLewaStrona <= indexPrawaStrona)
        {
            // Zamieniamy miejscami elementy, które są po niewłaściwych stronach pivotu. (swap z wykladu)
            int temp = tabela[indexLewaStrona];
            tabela[indexLewaStrona] = tabela[indexPrawaStrona];
            tabela[indexPrawaStrona] = temp;
            // Przesuwamy indeksy.
            indexLewaStrona++;
            indexPrawaStrona--;
        }
        // Jeśli indeksy się przekroczyły, wychodzimy z pętli.
        if (indexLewaStrona > indexPrawaStrona)
        {
            break;
        }
    }
    // Rekurencyjnie (rekurencyjnie czyli funkcja wywołuję się ponownie sama w ciele funkcji)
    // wywołujemy funkcję dla lewej i prawej strony tablicy.
    if (lewaStrona < indexPrawaStrona)
    {
        quickSort(tabela, lewaStrona, indexPrawaStrona); // Wywołujemy dla lewej strony
    }
    if (indexLewaStrona < prawaStrona)
    {
        quickSort(tabela, indexLewaStrona, prawaStrona); // Wywołujemy dla prawej strony
    }
}

int main(){
    int tabela[10] = {8, 7,7,3,2,2,6,0,8,9};

    cout << "Przed sortowaniem: ";
    for (int i = 0; i < 10; i++)
    {
        cout << tabela[i] << " ";
    }
    cout << endl;
    quickSort(tabela, 0, 9);
    cout << "Po sortowaniu: ";
    for (int i = 0; i < 10; i++)
    {
        cout << tabela[i] << " ";
    }
    cout << endl;

    return 0;
}





//void quickSort(int *tabela, int lewaStrona, int prawaStrona)
//{
//    if (lewaStrona >= prawaStrona)
//    {
//        return;
//    }
//    int indexLewaStrona = lewaStrona;
//    int indexPrawaStrona = prawaStrona;
//    int pivot = tabela[(lewaStrona + prawaStrona) / 2];
//    while (true)
//    {
//        while (tabela[indexLewaStrona] < pivot)
//            indexLewaStrona++;
//        while (tabela[indexPrawaStrona] > pivot)
//            indexPrawaStrona--;
//
//        if (indexLewaStrona <= indexPrawaStrona)
//        {
//            int temp = tabela[indexLewaStrona];
//            tabela[indexLewaStrona] = tabela[indexPrawaStrona];
//            tabela[indexPrawaStrona] = temp;
//            indexLewaStrona++;
//            indexPrawaStrona--;
//        }
//        if (indexLewaStrona > indexPrawaStrona)
//        {
//            break;
//        }
//    }
//    if (lewaStrona < indexPrawaStrona)
//    {
//        quickSort(tabela, lewaStrona, indexPrawaStrona);
//    }
//    if (indexLewaStrona < prawaStrona)
//    {
//        quickSort(tabela, indexLewaStrona, prawaStrona);
//    }
//
//}
//
//int main(){
//    int tabela[10] = {8, 7,7,3,2,2,6,0,8,9};
//
//    cout << "Przed sortowaniem: ";
//    for (int i = 0; i < 10; i++)
//    {
//        cout << tabela[i] << " ";
//    }
//    cout << endl;
//    quickSort(tabela, 0, 9);
//    cout << "Po sortowaniu: ";
//    for (int i = 0; i < 10; i++)
//    {
//        cout << tabela[i] << " ";
//    }
//    cout << endl;
//
//    return 0;
//}

