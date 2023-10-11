#include<stdio.h>

int stack[5],size,top=-1,i,elem,top2=-1,choice,stack_two[5],temp;

void read();
void diaplay();
void push(int);
int pop();
int pop2();
void largest_price();


void main()
{
	printf("Enter the size : ");
	scanf("%d",&size);
	read();
	do
	{
		printf("\nDo You want to add a new price : 1.YES 2.NO --->>>");
		scanf("%d",&choice);
		if(choice==1)
		{
			printf("\nEnter the new element : ");
			scanf("%d",&elem);
			push(elem);
		}
		else
		{
			break;
		}
	}while(choice==1);
	
}

void read()
{
	for(i=0;i<size;i++)
	{
		printf("Enter the Stock price : ");
		scanf("\t%d",&elem);
		push(elem);
	}
	display();
}

void push(int elem)
{
	if(top<size-1 && stack[top]<elem)
	{
		stack[++top]=elem;
		printf("\nPushed : %d\n",stack[top]);
	}
	else if(top<=size-1 && stack[top]>elem)
	{
		printf("\nEnter the Price grater than our current price !!!");
	}

	else if(top==-1)
	{
		stack[++top]=elem;
	}
	
	else if(top==size-1 && stack[top]<elem)
	{
	   largest_price();
	   stack[++top]=elem;
	   display();
	}
}

void largest_price()
{
	while(top!=-1)
	{
		stack_two[++top2]=pop();
	}
	temp=pop2();
	
	while(top2!=-1)
	{
		stack[++top]=pop2();
	}
	
	printf("\n\nDeleted Price : %d",temp);
	
}

void display()
{
	printf("\n\nThe largest Stock Prices are : ");
	for(i=top;i>=0;i--)
	{
		printf("\n%d",stack[i]);	
	}
}

int pop()
{
	return stack[top--];
}

int pop2()
{
	return stack_two[top2--];
}
