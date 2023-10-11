#include<stdio.h>
#include<math.h>

int a[]={10,36,54,89,12};
int i,sqr,sqr1,sum=0,n,j,x=-1,y=-1;
int b[10][10];

void main()
{
	for( i=0;i<=4;i++)
	{
		printf("%d\t\t",a[i]);
	}
	printf("\n");
	for( i=0;i<=4;i++)
	{
		printf("%d\t\t",a[i]);
		check(a[i]);
	}
	display();
}

void check(int no)
{
	sum=0;
	printf("\n\n%d",no);
	if(no%4 ==0 && no%6==0)
	{
		sum=4;
	}
	if(no%2==0)
	{
		sum=sum+3;
	}
	sqr=sqrt(no) ;
	printf("\n\n%d",sqr);
	sqr1=sqr*sqr;
	if(sqrt(no)==(sqr1))
	{
		sum = sum+5;
	}
	printf("\n Weigtage of %d is %d",no,sum);
	
	//storing
	
	b[++x][0]=no;
	b[++y][1]=sum;
	printf("\n\n%d",b[x][y]);


}

void display()
{
	printf("\n\nNumber and its corresponding weightage : \n\n");
	for(i=0;i<5;i++)
	{
		for(j=0;j<2;j++)
		{
			printf("%d\t",b[i][j]);
		}
		printf("\n");
	}
}