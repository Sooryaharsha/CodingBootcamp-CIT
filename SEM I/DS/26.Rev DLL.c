#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node*next;
	struct node*prev;
};

struct node *head,*tail,*curr,*temp,*newnode;
int i,j,ch,choice,n;

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
		if(head==0)
		{
			head=temp=newnode;
			newnode->prev=0;
		}
		else
		{
			temp->next=newnode;
			newnode->prev=temp;
			temp=newnode;
		}
		tail=newnode;
		n--;
	}
	printf("\n\nLinked List before Reversing : ");
	display();
	reverse();
	printf("\n\nLinked List before Reversing : ");
	display();
}

void reverse()
{
	curr=head;
	while(curr!=0)
	{
		temp=curr->next;
		curr->next=curr->prev;
		curr->prev=temp;
		curr=curr->prev;
	}
	temp=tail;
	tail=head;
	head=temp;	
}

void display()
{
	int count=0;
	temp=head;
	while(temp!=0)
	{
		printf("%d--> ",temp->data);
		temp=temp->next;
		count++;
	}
	printf("NULL\n\nThe total no of nodes are : %d",count);
}






