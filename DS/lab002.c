#include<stdio.h>
void main()
{
int arr[15],i,j,k,v;
printf("enter the elements:");
printf("\n");
{
for( i=0;i<15;i++)
    scanf("%d",&arr[i]);
}
int a[10][16]={};
for(i=1;i<=10;i++)
{
    for( j=1;j<=16;j++)
    {
        for( k=0,v=1;k<15;k++)
        {
            if(arr[k]%i==0)
            {
                a[i][v]=arr[k];
                v++;
            }
        }
    }
}
printf("\nMultiplication from 1 to 9:\n");
printf("\n");
for( i=1;i<10;i++){
    for( j=1;j<16;j++){
        printf("%d\t",a[i][j]);
    }
    printf("\n\n");
}
}
