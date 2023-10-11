#include<stdio.h>

int n,i,j;
void main()
{
printf("enter no of lines:");
scanf("%d",&n);
for(i=1;i<=n;i++)
    {
	for(j=1;j<=i;j++)
	  printf("* ");
	printf("\n");
}
}

