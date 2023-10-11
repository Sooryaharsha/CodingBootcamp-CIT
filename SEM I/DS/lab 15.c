#include <stdio.h>
int i,j;
void merge(int arr[], int p, int q, int r) {

  int n1 = q - p + 1;
  int n2 = r - q;

  int L[n1], M[n2];

  for ( i = 0; i < n1; i++)
    L[i] = arr[p + i];
  for ( j = 0; j < n2; j++)
    M[j] = arr[q + 1 + j];

  int i, j, k;
  i = 0;
  j = 0;
  k = p;

  while (i < n1 && j < n2) {
    if (L[i] <= M[j]) {
      arr[k] = L[i];
      i++;
    } else {
      arr[k] = M[j];
      j++;
    }
    k++;
  }
  while (i < n1) {
    arr[k] = L[i];
    i++;
    k++;
  }
  while (j < n2) {
    arr[k] = M[j];
    j++;
    k++;
  }
}

void mergeSort(int arr[], int l, int r) {
	int m;
  if (l < r) {
     m = l + (r - l) / 2;

    mergeSort(arr, l, m);
    mergeSort(arr, m + 1, r);

    merge(arr, l, m, r);
  }
}

void printArray(int arr[], int size) {
  for (i = 0; i < size; i++)
    printf("%d ", arr[i]);
  printf("\n");
}
int main() {
   int a[20],n;
  printf("Enter the number of elements to be sorted:");
  scanf("%d",&n);
  printf("Enter the elements:\n");
  for ( i = 0; i < n; ++i)
    {
    scanf("%d",&a[i]);
    }
  mergeSort(a,0,n-1);

  printf("Sorted array: \n");
  printArray(a,n);
}
