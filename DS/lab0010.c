#include<stdio.h>

int i,n,c[10][2],j;

void main()
{
	int a[10][2],b[10][2];
	
	printf("\nEnter the no. of terms in Polynomials : ");
	scanf("%d",&n);
	
	printf("\nEnter the values for Polynomial 1 \n ");
	read(a);
	printf("\nPolynomial Equation 1 : ");
	display(a);
	
	printf("\n\nEnter the values for Polynomial 2 \n");
	read(b);
	printf("\nPolynomial Equation 1 : ");
	display(b);
	
	addpoly(a,b);
	
	printf("\n\nValues after polynomial addition : ");
	display(c);
	
}

void read (int a[10][2])
{
	for(i=0;i<n;i++)
	{
		printf("\nEnter the coefficeint value : ");
		scanf("%d",&a[i][0]);
		printf("\nEnter the Exponent value : ");	
		scanf("%d",&a[i][1]);
	}
}

void addpoly(int a[10][2], int b[10][2])
{
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			if(a[i][1]==b[j][1])
			{
				c[i][0]=a[i][0]+b[j][0];
				c[i][1]=a[i][1];
			}
		}
	}
}
void display(int a[10][2])
{
	for(i=0;i<n;i++)
	{
		printf("%dx^%d + ",a[i][0],a[i][1]);
	}
}
