#include<stdio.h>
#include<stdlib.h>
#include<math.h>


	int i,j,k,n,weight;
	int graph[10][10]={{0,1,1,1,0,0,0},{0,0,0,1,1,0,1},{0,0,0,0,0,1,0},{0,0,1,0,0,1,1},{0,0,0,1,0,0,1},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
	int transpose[10][10];

void main()
{
    system("clear");
	n=7;
	printf("\n\nAdjacency matrix of the given graph\n\n");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			printf("%d ",graph[i][j]);
		}
		printf("\n");
	}
	
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			if(graph[i][j]==1)
			{
				transpose[j][i]=1;
			}
			else
			{
				transpose[j][i]=0;
			}
		}
	}
    printf("\n\nTranspose of the given graph\n");
    for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			printf("%d ",transpose[i][j]);
		}
		printf("\n");
	}
	
	printf("\n\nWeight of the graph");
	for(i=0;i<7;i++)
	{
		for(j=0;j<7;j++)
		{
			if(transpose[i][j]==1)
			{
				weight=(i+1)-(j+1);
				printf("\nWeight of the edge from %d to %d is %d",i+1,j+1,weight);
			}
		}
	}
}
		
		
		
		

