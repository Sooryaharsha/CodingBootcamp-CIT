#include<stdio.h>
int i,j,max,pos,b[10];
int a[10],n;
void display(int x[],int);

int getmax(int a[],int n)
{
	max=a[0];
	for(i=1;i<n;i++)
	{
		if(a[i]>max)
		{
          max=a[i];
		}
	}
	return max;
}

void radixsort(int a[],int n)
{
	int max = getmax(a,n);
	printf("\nThe maximum element is : %d",max);
	for(pos=1;max/pos>0;pos=pos*10)
	{
		countsort(a,n,pos);
	}
	display(b,n);
}

void countsort(int a[],int n,int pos)
{
	printf("\nEntered into countsort");
	int count[10];
	for(i=0;i<n;i++)
	{
		count[(a[i]/pos)%10]++;
	}
	for(i=0;i<n;i++)
	{
		count[i]=count[i]+count[i-1];
	}
	for(i=n-1;i>0;i--)
	{
		b[count[((a[i]/pos)%10)]-1]=a[i];
		count[((a[i]/pos)%10)]--;
	
	}
}

void main()
{
	printf("\nEnter the size of the array: \n");
	scanf("%d",&n);
	printf("Enter the elements:\n");
	for(i=0;i<n;i++)
	{b
		scanf("\n%d",&a[i]);
	}
	printf("\nArray values before sorting :\n");
	display(a,n);
	radixsort(a,n);
	printf("\nArray values after sorting :\n");
	display(b,n);
}


void display(int x[],int n)
{
    for(i=0;i<n;i++)
	 {
		printf("%d\n",x[i]);
	 }
}
