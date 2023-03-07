//Merge two sorted 

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node* next;
};

struct node *head1=0,*head2=0,*temp,*tail,*newnode,*mergelist,*mergetail;
int n,choice,i,j;

struct node* createlist(int n)
{
	struct node* head=0;
	while(n>0)
	{
		newnode=(struct node*)malloc(sizeof(struct node));
		newnode->next=0;
		printf("Enter the node value : ");
		scanf("%d",&newnode->data);
		if(head==0)
		{
			head=temp=newnode;
		}
		else
		{
			temp->next=newnode;
			temp=newnode;
		}
		n--;
	}
	return head;

}

void display(struct node* start)
{
	temp=start;
	while(temp!=0)
	{
		printf("%d-->",temp->data);
		temp=temp->next;
	}
	printf("NULL");
}

void main()
{
	printf("\nEnter the No of nodes in list1 : ");
	scanf("%d",&n);
	head1=createlist(n);
	printf("\nEnter the No of nodes in list2 : ");
	scanf("%d",&n);
	head2=createlist(n);
	printf("\nFirst Linked list values : ");
	display(head1);
	printf("\nSecond Linked list values : ");
	display(head2);
	merge(head1,head2);
	printf("\n\nAFTER MERGING TWO SORTED LINKED LIST : \n");
	display(mergelist);

}

void merge(struct node* list1,struct node* list2)
{
	if(list1->data<=list2->data)
	{
		mergelist=list1;
		list1=list1->next;
	}
	else
	{
		mergelist=list2;
		list2=list2->next;
	}
	
	mergetail=mergelist;
	
	while(list1!=0 && list2!=0)
	{
		if(list1->data<=list2->data)
		{
		   mergetail->next=list1;
		   list1=list1->next;
		}
		else
		{
			mergetail->next=list2;
		    list2=list2->next;
		}
		mergetail=mergetail->next;
	}
	
	if(list1!=0)
	{
		mergetail->next=list1;
	}
	else if(list2!=0)
	{
		mergetail->next=list2;
	}
}





















