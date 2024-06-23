#include <iostream>
// *Napisz funkcje dequeue() dla kolejki, która usuwa i zwraca element z początku kolejki.

using namespace std;
int dequeue(int tablica[], int& rozmiar){
    if (rozmiar == 0) {
        cout << "Kolejka jest pusta. Nie mozna usunac elementu." << endl;
        return 0;
    }
    int pierwszyElement = tablica[0];
    for(int i = 0; i < rozmiar; i++){
        tablica[i] = tablica[i+1];
    }
    rozmiar--;
    return pierwszyElement;
}
// * Napisz funkcje pushBack() dla listy jednokierunkowej, która przechodzi na koniec listy i dodaje tam nowy węzeł

struct Node{
    int value;
    Node* next;
};
void pushBack(Node* &head, int value){
    Node* newNode = new Node;
    newNode->value = value;
    newNode->next = nullptr;
    if(head == nullptr){
        head = newNode;
        return;
    }
    Node* temp = head;
    while(temp->next != nullptr){
        temp = temp->next;
    }
    temp->next = newNode;
}

// * Napisz funkcje isEmpty() dla stosu, która sprawdza, czy stos jest pusty.


bool isEmpty(int aktualnyElement){
    if(aktualnyElement < 0){
        cout<< "Stos jest pusty." << endl;
        return true;
    }else{
        cout<< "Stos nie jest pusty." << endl;
        return false;
    }
};

// * Napisz funkcje isEmpty() dla kolejki, która sprawdza czy kolejka jest pusta.

// * Przyjmuje że rozmiar to ilość elementów w tablicy kolejki.
// * Zwraca true jeśli rozmiar jest równy 0, w przeciwnym wypadku zwraca false.
bool isEmptyKolejka(int rozmiar){
    if(rozmiar == 0){
        cout << "Kolejka jest pusta." << endl;
        return true;
    }else{
        cout << "Kolejka nie jest pusta." << endl;
        return false;
    }
}

