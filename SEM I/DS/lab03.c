#include <stdio.h>
void main()
{
	int a[10],n,i,f,count=0;
	printf("\nEnter the number of elements : ");
	scanf("%d",&n);
	printf("\nEnter those elements : ");
	for (i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	printf("\nEnter the number to find : ");
	scanf("%d",&f);
	for(i=0;i<n;i++)
	{
		if(a[i]==f)
		{
		  count = count+1;
		}
	}
	if(count>0)
	{
	
	printf("Element is present");
	}
	else
	{
	printf("Element not found");
    }
}
 
