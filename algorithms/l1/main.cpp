#include <iostream>
#include <chrono>
void bubbleSort(int array[], int size)
{
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size - i - 1; j++)
        {
            if (array[j] > array[j + 1])
            {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}

//* szukamy najmniejszy element z tablicy i zamieniamy go z następnym elementem w tablicy
void selectionSort(int array[], int size)
{
    for (int index = 0; index < size; index++)
    {
        int minIndex = index;
        for (int j = index + 1; j < size; j++)
        {
            if (array[j] < array[minIndex]) //* jeśli element następny z tablicy jest
            {
                minIndex = j; //*mniejszy od pierwszego to przepisujemy wartość najmniejszą w tablicy
            }
        } //* jeżeli w index  jest różny od minimalnego indexu w tablicy to dokonujemy zmiany
        if (index != minIndex)
        {
            int temp = array[index];
            array[index] = array[minIndex]; //* jeśli element z indexem i jest większy od minimum to
            array[minIndex] = temp;         //* zamieniamy go z najmniejszym(dotychczasowym) elementem w tablicy
        }
    }
}
//* sprawdzamy czy następny element jest większy od poprzedniego
//* jeśli jest to zamieniamy i cofamy się w tablicy dopóki
//* nie napotkamy mniejszej wartości bądź równej od obecnie porównywanej
void insertionSort(int array[], int size)
{
    for (int index = 1; index < size; index++)
    {
        int j = index - 1;          //* wskazuje pierwszy element z tablicy
        int current = array[index]; //* wpisujemy wartość pierwszego elementu z tablicy do zmiennej
        //! temp to zmienna którą obecnie porównujemy z poprzednikami tablicy
        //* dopóki j jest większe od zera i
        //* wartość poprzedniego elementu z tablicy jest większa od
        //*wartości obecnie porównywanej w tablicy
        while ((j >= 0) && (current < array[j]))
        {
            array[j + 1] = array[j]; //* to przesuwamy wartość porównywanego elementu do tyłu
            j--;                     //* do momentu aż nie napotkamy wartości mniejszej bądź równej z porównywaną wartością
        }
        array[j + 1] = current; //* po pętli następną wartość w tablicy wpisujem
        //* na miejsce pierwszego elementu w tablicy
    }
}

void coutingSort(int array[], int size)
{
    int tempArray[10] = {0};
    for (int i = 0; i < size; i++)
    {
        tempArray[array[i]]++;
    }
    int counter = 0;
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < tempArray[i]; j++)
        {
            array[counter] = i;
            counter++;
        }
    }
}

int main()
{
    std::cout << "Bubble Sort:" << std::endl;
    int arr[10] = {0, 2, 5, 2, 6, 9, 6, 7, 2, 6};
    bubbleSort(arr, 10);
    for (int i = 0; i < 10; i++)
    {
        std::cout << arr[i] << ' ';
    }
    std::cout << std::endl;
    std::cout << "Selection Sort:" << std::endl;
    selectionSort(arr, 10);
    for (int i = 0; i < 10; i++)
    {
        std::cout << arr[i] << ' ';
    }
    std::cout << std::endl;
    std::cout << "Insertion Sort:" << std::endl;
    insertionSort(arr, 10);
    for (int i = 0; i < 10; i++)
    {
        std::cout << arr[i] << ' ';
    }
    std::cout << std::endl;
    std::cout << "Couting Sort:" << std::endl;
    auto begin = std::chrono::high_resolution_clock::now();
    coutingSort(arr, 10);
    auto end = std::chrono::high_resolution_clock::now();
    auto elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - begin);
    std::cout << "Time: " << elapsed.count() << "ns" << std::endl;
    for (int i = 0; i < 10; i++)
    {
        std::cout << arr[i] << ' ';
    }
    std::cout << std::endl;
};