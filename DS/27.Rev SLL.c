#include<stdio.h>


struct node
{
	int data;
	struct node* next;
};

struct node* head, *newnode,*temp,*curr,*prev,*net=1;

void main()
{
	
	int choice;
	head=0;
	do
	{
		newnode=(struct node*)malloc(sizeof(struct node));
		newnode->next=0;
		printf("\nEnter the data : ");
		scanf("%d",&newnode->data);
		if (head==0)
		{
			head = temp =newnode;
		}
		else
		{
			temp->next = newnode;
			temp=newnode;
		}
		printf("\ndo you want to add a new node : 1.YES 2.NO ");
		scanf("%d",&choice);
		
	}while(choice==1);
	temp->next=0;
	printf("\n\nLinked List Before reversing : ");
	display();
	reverse();
	printf("\n\nLinked List after reversing : ");
	display();
}

void display()
{
	
	printf("\nThe data in the nodes are : \n");
	temp=head;
	while(temp!=0)
	{
		printf("\n%d",temp->data);
		temp=temp->next;
	}
}

void reverse()
{
	curr=head;
	prev=0;
	while(curr!=0)
	{
		net=curr->next;
		curr->next=prev;
		prev=curr;
		curr=net;
	}
	head=prev;
}











