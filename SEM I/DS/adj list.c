#include<stdio.h>
#include<stdlib.h>

struct node
{
	int node;
	struct node* next;
};

struct node  *newnode,*head[10],*temp;
int i,n,j,k,a[10][10];

void main()
{
	printf("Enter the no of vertex : ");
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		head[i]=0;
		head[i]=create(head[i],i);
    }
    temp=head[1];
    while(temp!=0)
    {
    	printf("%d",temp->node);
    	temp=temp->next;
	}
}

void create(struct node* head,int i)
{

	for(j=1;j<=n;j++)
	{
		    newnode=(struct node*)malloc(sizeof(struct node));
			printf("\nIf %d and %d are adjacent nodes ? (0/1) - ",i,j);
			scanf("%d",&k);
			if(head==0)
			{
				head=temp=newnode;
			}
			else
			{
				temp->next=newnode;
				temp=newnode;
			}
	    }
	    return head;
}






