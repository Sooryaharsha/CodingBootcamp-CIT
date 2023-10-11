#include<stdio.h>
#include<string.h>
int i=0,count=0,n;

void main()
{
	char a[20],b;
	printf("Enter the string : ");
	gets(a);
	n=sizeof(a);
    printf("\nEnter a character to find its occurance : ");
    b= getchar();
    check(a,b);
    printf("\nNo.of occurance of %c in %s is %d times",b,a,count);
	
}

void check(char *a,char b)
{
	if(!a[i])
	{
	  return 0;
	}
	else
	{
		if(a[i]==b)
	 	count++;
	}
	i++;
	check(a,b);
}
