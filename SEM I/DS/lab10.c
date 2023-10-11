#include<stdio.h>

int i,j;

void get_input(int x[20][2],int n)
{
     for( i=0;i<n;i++)
    {
        printf("Enter the coefficient:");
        scanf("%d",&x[i][0]);
        printf("Enter the exponent:");
        scanf("%d",&x[i][1]);
    }
}

void display(int a[20][2],int n)
{
    for(i=0;i<n;i++)
    {
      printf("%d(x^%d)+",a[i][0],a[i][1]);
    }
}

void main()
{
    int a[20][2],b[20][2],c[20][2],n;
    printf("Enter the terms in a polynomial:");
    scanf("%d",&n);
    
    printf("Enter the values for polynomial 1:\n");
    get_input(a,n);
    printf("Enter the values for polynomial 2:\n");
    get_input(b,n);

    printf("Polynomial 1:\n");
    display(a,n);

    printf("\nPolynomial 2:\n");
    display(b,n);

    for( i=0;i<n;i++)
    {
        for( j=0;j<n;j++)
        {
          if(a[i][1]==b[j][1])
           {
            c[i][0]=a[i][0]+b[j][0];
            c[i][1]=a[i][1];
           }
        }

    }
    printf("\nSum of two polynomial:\n");
    display(c,n);

}

