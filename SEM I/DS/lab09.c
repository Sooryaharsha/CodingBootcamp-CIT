#include<stdio.h>
int stack[10],stack_min[5],top=-1,top1=-1,temp,elem,size,a[10],i,b,choice,j,key;

void push(int elem)
{
	if(top<size-1)
	{
		top++;
		stack[top]=elem;
		printf("\nPushed : %d\n",stack[top]);	
	}
	else if(top==size-1 ) //if stack is full
	{
	
			while(top1<=size-1 && top>=0)
			{
				if(top1==-1 && stack[top]>elem)
				{
			    	stack_min[++top1]=pop();
				}
				else if(top1==-1 && stack[top]<elem)
				{
					stack_min[++top1]=elem;
				}
			
		    }
		    
			while(top1<=0 && top1!=size)
			{
				if(stack[top] > elem)
				{
					while(stack[top] > stack_min[top1])
					{
				    		stack_min[++top1]=pop1();	
				    		stack_min[++top1]=pop();	
					}	    	
	    	    }	
					
				else if(stack_min[top1]>elem)
				{
					while(stack_min[top1]>stack[top])
					{
				    		stack_min[++top1]= pop();	
				    		stack_min[++top1]=pop1();
					}
				}   
				else if(elem > stack[top] && elem > stack_min[top1])
				{
					stack_min[++top]=elem;
				 } 	 
			}
			
			if(top==0)
			{
				while(stack[top]>stack_min[top1] && top<=size-1)
				{
					stack[++top]= pop1();
				}
				
				while(stack[top]<stack_min[top1] && top<=size-1)
				{
					temp=pop();
					stack[++top]=pop1();
					stack[++top]=temp;
				}
			}
		
		
			
			
		
		printf("\nStack values after new element : \n");
		for(j=size-1;j>=0;j--)
		{
			printf("\n%d",stack[j]);
			
		}
	}
	
}

int pop()
{
	return(stack[top--]);	
}

int pop1()
{
	return(stack_min[top1--]);	
}

void isfull()
{
	if(top==size-1)
	printf("Stack is full");
}

void isempty()
{
	if(top==-1)
	printf("stack is empty");
}

void peek()
{
	printf("\n\nThe element is : ",stack[top]);
}

void main()
{
	printf("Enter the stack size : ");
	scanf("%d",&size);
	printf("Enter the elements to push into stack : ");
	for(i=0;i<size;i++)
	{
		scanf("%d",&a[i]);
		push(a[i]);
	}
	do
	{
		printf("\nEnter the new element to push ");
		scanf("%d",&b);
		push(b);
		printf("\n\nDo You wanna push another elem ? 1.YES 2.NO ---> ");
		scanf("%d",&choice);
	}while(choice==1);
	
	
}
