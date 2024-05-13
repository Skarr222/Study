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
void quickSort(int *tab, int left, int right)
{
    if (left >= right)
    {
        return;
    }
    int indexLeft = left;
    int indexRight = right;
    int pivot = tab[(left + right) / 2];
    while (true)
    {
        while (tab[indexLeft] < pivot)
            indexLeft++;
        while (tab[indexRight] > pivot)
            indexRight--;

        if (indexLeft <= indexRight)
        {
            int temp = tab[indexLeft];
            tab[indexLeft] = tab[indexRight];
            tab[indexRight] = temp;
            indexLeft++;
            indexRight--;
        }
        if (indexLeft > indexRight)
        {
            break;
        }
    }
    if (left < indexRight)
    {
        quickSort(tab, left, indexRight);
    }
    if (indexLeft < right)
    {
        quickSort(tab, indexLeft, right);
    }
}
void merge(int *tab, int left, int middle, int right)
{
    int *temp = new int[right - left + 1];
    int i = left;
    int j = middle + 1;
    int k = 0;
    while (i <= middle && j <= right)
    {
        if (tab[i] < tab[j])
        {
            temp[k] = tab[i];
            i++;
        }
        else
        {
            temp[k] = tab[j];
            j++;
        }
        k++;
    }
    while (i <= middle)
    {
        temp[k] = tab[i];
        i++;
        k++;
    }
    while (j <= right)
    {
        temp[k] = tab[j];
        j++;
        k++;
    }
    for (int i = left; i <= right; i++)
    {
        tab[i] = temp[i - left];
    }
    delete[] temp;
}
void mergeSort(int *tab, int left, int right)
{
    if (left >= right)
    {
        return;
    }
    if (left < right)
    {
        int middle = (left + right) / 2;
        mergeSort(tab, left, middle);
        mergeSort(tab, middle + 1, right);
        merge(tab, left, middle, right);
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
    coutingSort(arr, 10);
    for (int i = 0; i < 10; i++)
    {
        std::cout << arr[i] << ' ';
    }
    std::cout << std::endl;

    std::cout << "Quick Sort:" << std::endl;
    int *tab = new int[10]{0, 2, 5, 2, 6, 9, 6, 7, 2, 6};
    quickSort(tab, 0, 9);
    for (int i = 0; i < 10; i++)
    {
        std::cout << tab[i] << ' ';
    }
    std::cout << std::endl;
};