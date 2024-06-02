#include <iostream>

const int max = 5;
int stos[max];
int active = -1;

void push(int value)
{
    if (active < max - 1)
    {
        active++;
        stos[active] = value;
        std::cout << "Pushed: " << value << " on position" << active << std::endl;
    }
    else
    {
        std::cout << "Stack is full" << std::endl;
    }
}
void pop()
{
    if (active >= 0)
    {
        active--;
    }
    else
    {
        std::cout << "Stack is empty" << std::endl;
    }
}

int main()
{
    push(5);
    push(6);
    push(7);
    push(8);
    push(9);
    push(10);
}