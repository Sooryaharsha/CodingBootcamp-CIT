#include <stdio.h>
int main()
{
    int arr[15];
    printf("Enter the elements:\n");
    for(int i=0;i<15;i++)
	{
        scanf("%d",&arr[i]);
    }
    int a[10][16] = { 0 };

    for(int i=1;i<=10;i++){
        for(int j=1;j<=16;j++){
            for(int k=0,v=1;k<15;k++){
                if(arr[k]%i==0){
                    a[i][v]=arr[k];
                    v++;
                }
            }
        }
    }
    printf("\nMultiples from 1 to 9:\n");
    for(int i=1;i<10;i++){
        for(int j=1;j<16;j++){
            printf("%d  ",a[i][j]);
        }
        printf("\n");
    }

}
