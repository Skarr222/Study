#include <iostream>
using namespace std;

struct wiezcholek {
    char poczatek;
    char koniec;
    int wartosc;
};

wiezcholek tab[10];
int ilosc = 0;

void dodaj(char a, char b, int w){
    // a i b to wierzchołki
  tab[ilosc].poczatek = a;
  tab[ilosc].koniec = b;
  tab[ilosc].wartosc = w;
  ilosc++;
  tab[ilosc].poczatek = b;
  tab[ilosc].koniec = a;
  tab[ilosc].wartosc = w;
  ilosc++;
};

void wypisz(){
    for (int i = 0; i < ilosc; i++) {
    cout << tab[i].poczatek<< " <--" << tab[i].wartosc << "--> " << tab[i].koniec << endl;
    }
};

struct Node{ // struktura reprezentująca węzeł
    int value;
    Node* left;
    Node* right;
};
class BST{
public:
    Node* root;
    BST(){
        root=NULL;
    }
    Node* utworz_Lisc(int x){ // funkcja tworząca nowy liść
        Node* lisc = new Node(); // utworzenie nowego liścia
        lisc -> value = x; // przypisanie wartości x do nowego liścia
        lisc -> left = NULL; // ustawienie lewego dziecka na NULL
        lisc -> right = NULL; // ustawienie prawego dziecka na NULL
        return lisc;

    }
    // funkcja dodająca wartość x do drzewa
    void dodaj_wartosc(int x, Node* rodzic){
        if(root==NULL){
            root=utworz_Lisc(x);
        }
        else if(x<rodzic->value){ // jeśli x jest mniejsze od wartości rodzica
            if(rodzic->left==NULL){ // jeśli lewe dziecko rodzica nie istnieje
                rodzic->left=utworz_Lisc(x); // tworzymy nowy liść
            }
            else{ // jeśli lewe dziecko rodzica istnieje
                dodaj_wartosc(x,rodzic->left); // rekurencyjnie wywołujemy funkcję dodaj_wartosc
            }
        }
        else{ // jeśli x jest większe od wartości rodzica
            if(rodzic->right==NULL){ // jeśli prawe dziecko rodzica nie istnieje
                rodzic->right=utworz_Lisc(x); // tworzymy nowy liść
            }
            else{ // jeśli prawe dziecko rodzica istnieje rekurencyjnie wywołujemy funkcję dodaj_wartosc
                dodaj_wartosc(x,rodzic->right);
            }
        }
    }
    void wypisz(Node* rodzic){
        if(rodzic!=NULL){
            if(rodzic->left!=NULL){
                wypisz(rodzic->left);
            }
            cout<<rodzic->value;
            if(rodzic->right!=NULL){
                wypisz(rodzic->right);
            }
        }
        else{
            cout<< "Drzewo jest puste" << endl;
        }
    }

};

int main() {
    BST *drzewo = new BST();
    drzewo->dodaj_wartosc(5,drzewo->root);
    drzewo->dodaj_wartosc(3,drzewo->root);
    drzewo->dodaj_wartosc(7,drzewo->root);
    drzewo->dodaj_wartosc(2,drzewo->root);
    drzewo->dodaj_wartosc(4,drzewo->root);
    drzewo->dodaj_wartosc(1,drzewo->root);

    drzewo->wypisz(drzewo->root);

    return 0;
}