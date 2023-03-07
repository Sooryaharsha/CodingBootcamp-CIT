#include<stdio.h>
#include<stdlib.h>

struct node
{
	int exp,coeff;
	struct node* next;
};

struct node *head1=0,*head2=0,*temp,*tail,*newnode,*poly,*polytail;
int n,choice,i,j;

struct node* createlist(int n)
{
	struct node* head=0;
	while(n>0)
	{
		newnode=(struct node*)malloc(sizeof(struct node));
		newnode->next=0;
		printf("Enter the Exponent value : ");
		scanf("%d",&newnode->exp);
		printf("Enter the Coefficient of  %d : ",newnode->exp);
		scanf("%d",&newnode->coeff);
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
		printf("%d^%d-->",temp->exp,temp->coeff);
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
	printf("\nAddition of polynomial : ");
	sumpoly(head1,head2);
	display(poly);
}

void sumpoly(struct node* list1,struct node* list2)
{
	poly=0;
	while(list1!=0 && list2!=0)
    {
		if(poly==0)
		{
			if(list1->coeff==list2->coeff)
			{
				list1->exp=list1->exp +list2->exp;
				poly=polytail=list1;
				list1=list1->next;
				list2=list2->next;
			}
			else if(list1->coeff>list2->coeff)
			{
				poly=polytail=list1;
				list1=list1->next;
			}
			else
			{
				poly=polytail=list2;
				list2=list2->next;
			}
		}
		else
		{
		
				if(list1->coeff==list2->coeff)
				{
					list1->exp=list1->exp +list2->exp;
					polytail->next=list1;
					list1=list1->next;
					list2=list2->next;
				}
				else if(list1->coeff>list2->coeff)
				{
					polytail->next=list1;
					list1=list1->next;
				}
				else
				{
					polytail->next=list2;
					list2=list2->next;
				}
	    	}
    }
    	if(list1!=0)
    	{
    		polytail=list1;
		}
		else
		{
    		polytail=list2;
		}
    	
	}	

	
	
	
