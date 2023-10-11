//max heap
#include<stdio.h>

void heapify(int*,int, int);
void heapsort(int*, int);
void print_array(int*, int);
int i;

int main()
{
    int arr[] = { 28,29,30,26,6,40,34,11,9,70 };
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("\nArray before sorting:\n");
    print_array(arr, n);

    heapsort(arr, n);

    printf("\n\nArray after Max heapify:\n");
    print_array(arr, n);
    
    heapsort2(arr, n);

    printf("\n\nArray after Min heapify:\n");
    print_array(arr, n);

    return 0;
}

void heapsort(int* arr, int n)
{
    for ( i = n / 2 - 1; i >= 0; i--)
    {

        maxheapify(arr, n, i);
    }
}

void maxheapify(int* arr, int n, int i)
{

    int largest = i;

    int left = 2 * i + 1;
    int right  = 2 * i + 2;

    if (left < n && arr[left] > arr[largest])
    {
        largest = left;
    }

    if (right < n && arr[right] > arr[largest])
    {
        largest = right;
    }

    if (largest != i)
    {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;

        maxheapify(arr, n, largest);
    }
}


void print_array(int* arr, int n)
{
    for ( i = 0; i < n; i++)
    {
        printf("%d  ", arr[i]);
    }
}

void heapsort2(int* arr, int n)
{
    for ( i = n / 2 - 1; i >= 0; i--)
    {

        minheapify(arr, n, i);
    }
}
void minheapify(int* arr, int n, int i)
{

    int smallest = i;

    int left = 2 * i + 1;
    int right  = 2 * i + 2;

    if (left < n && arr[left] < arr[smallest])
    {
        smallest = left;
    }

    if (right < n && arr[right] < arr[smallest])
    {
        smallest = right;
    }

    if (smallest != i)
    {
        int temp = arr[i];
        arr[i] = arr[smallest];
        arr[smallest] = temp;
        minheapify(arr, n, smallest);
    }
}


