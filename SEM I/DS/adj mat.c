#include<stdio.h>
#include<stdlib.h>

struct node
{
	int node;
	struct node* next;
};

struct node* newnode,*head,*temp;
int i,n,j,k,a[10][10];

void main()
{
	printf("Enter the no of vertex : ");
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			printf("\nIf %d and %d are adjacent nodes ? (0/1) - ",i,j);
			scanf("%d",&k);
			if(k==1)
			{
				a[i][j]=1;
			}
			else
			{
				a[i][j]=0;
			}
		}
	}
	printf("The adjacency matrix of the graph is : \n");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			printf("%d ",a[i][j]);
		}printf("\n");
	}
	
}
