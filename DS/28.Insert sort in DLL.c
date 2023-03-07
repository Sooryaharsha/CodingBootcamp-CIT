#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node* next;
	struct node* prev;
};
struct node *head,*tail,*curr,*temp,*newnode;
int i,j,ch,choice,n,data;

void main()
{
	head=0;
	printf("Enter the no of nodes : ");
	scanf("%d",&n);
	while(n>0)
	{
		newnode=(struct node*)malloc(sizeof(struct node));
		printf("\nEnter the node value : ");
		scanf("%d",&newnode->data);
		newnode->next=0;
		newnode->prev=0;
		if(head==0)
		{
			head=tail=newnode;
			
		}
		else
		{
			if(newnode->data > tail->data)
			{
			tail->next=newnode;
			newnode->prev=tail;
			tail=newnode;
			}
			else
			{
				temp=tail;
				while(temp->prev->data > newnode->data)
				{
					temp=temp->prev;
				}

				newnode->next=temp;
				newnode->prev=temp->prev;
				newnode->prev->next=newnode;
				temp->prev=newnode;
			}
		}
		n--;		
	}
	display();
}

void display()
{
	int count=0;
	temp=head;
	printf("\nSorted Linked List :\n");
	while(temp!=0)
	{
		printf("%d--> ",temp->data);
		temp=temp->next;
		count++;
	}
	printf("NULL\n\nThe total no of nodes are : %d",count);
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
