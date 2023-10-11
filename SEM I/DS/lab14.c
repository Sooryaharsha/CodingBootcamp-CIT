#include <stdio.h>

int getMax(int a[], int n) {
   int max = a[0];
   int i;
   for( i = 1; i<n; i++) {
      if(a[i] > max)
         max = a[i];
   }
   return max;
}

void countingSort(int a[], int n, int place)
{
  int output[n + 1],i;
  int count[10] = {0};

  for (i = 0; i < n; i++)
    count[(a[i] / place) % 10]++;

  for (i = 1; i < 10; i++)
    count[i] += count[i - 1];

  for (i = n - 1; i >= 0; i--)
  {
    output[count[(a[i] / place) % 10] - 1] = a[i];
    count[(a[i] / place) % 10]--;
  }

  for (i = 0; i < n; i++)
    a[i] = output[i];
}

void radixsort(int a[], int n)
{
	int place;
  int max = getMax(a, n);
  for ( place = 1; max / place > 0; place *= 10)
    countingSort(a, n, place);
}

void printArray(int a[], int n) {
	int i;
  for ( i = 0; i < n; ++i) {
    printf("%d  ", a[i]);
  }
  printf("\n");
}

int main() {
   int a[20],n,i;
  printf("Enter the number of elements to be sorted:");
  scanf("%d",&n);
  printf("Enter the elements:\n");
  for ( i = 0; i < n; ++i)
    {
    scanf("%d",&a[i]);
    }
  radixsort(a, n);
  printf("Sorted array : \n");
  printArray(a,n);
}
