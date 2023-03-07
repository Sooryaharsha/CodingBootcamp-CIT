#include<stdio.h>

int i,j,temp,a[10],size,min;

void main()
{
    printf("Enter the size of the array : ");
    scanf("%d",&size);
    printf("\nEnter the array elements : ");
    for(i=0;i<size;i++)
    {
    	scanf("%d",&a[i]);
	}
	for(i=0;i<size;i++)
	{
		min=i;
		for(j=i+1;j<size;j++)
		{
			if(a[j]<a[min])
			   min=j;
		}
		if(min!=i)
		{
			temp=a[min];
			a[min]=a[i];
			a[i]=temp;
		}
	}
	printf("\n\nArray values after sorting : ");
	for(i=0;i<size;i++)
    {
    	printf("\t%d\t",a[i]);
	}
}
