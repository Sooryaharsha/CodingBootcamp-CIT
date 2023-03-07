#include<stdio.h>

int a[10],size,i,j,temp;

void main()
{
	printf("Enter the size of the array : ");
	scanf("%d",&size);
	printf("Enter the array elements : ");
	getinput();
	printf("\n\nArray values before sorting : ");
	display();
	bubblesort();
	printf("\n\nArray values after sorting : ");
	display();
}

void getinput()
{
	for(i=0;i<size;i++)
	{
		scanf("%d",&a[i]);
	}
}

void bubblesort()
{
	for(i=0;i<size;i++)
	{
		for(j=0;j<size-1;j++)
		{
			if(a[j]>a[j+1])
			{
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}
	}
}

void display()
{
	for(i=0;i<size;i++)
	{
		printf(" %d ",a[i]);
	}
}
