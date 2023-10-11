#include<stdio.h>
#include<stdlib.h>
struct node
    {
        int vertex;
        struct node *next;
    };
    int n,i,j;
void create(struct node *list[])
    {
        int k;struct node *newnode;
        for( i=1;i<=n;i++)
        {
            printf("Enter no. of vertices adjacent to %d: ",i);
            scanf("%d",&k);
            for( j=1;j<=k;j++)
            {   struct node *last;
                newnode=(struct node*)malloc(sizeof(struct node));
                printf("Enter the %d vertex adjacent to %d: ",j,i);
                scanf("%d",&newnode->vertex);
                newnode->next=NULL;
                if(list[i]==NULL)
                {
                    list[i]=newnode;
                }
                else
                {
                    last->next=newnode;
                }
                last=newnode;
            }
        }
    }
    void print(struct node *list[])
    {
        struct node *temp;
        int i;
        for( i=1;i<=n;i++)
        {
            printf("\n");
            temp=list[i];
            printf("Vertices adjacent to %d :",i);
            while(temp!=0)
            {
                printf("%d ,",temp->vertex);
                temp=temp->next;
            }
        }
    }

void main()
    {
    int a[20][20];
    printf("Enter the no. of nodes: ");
    scanf("%d",&n);
    for( i=1;i<=n;i++)
    {
        for( j=1;j<=n;j++)
        {
            printf("Enter 1 if %d and %d is adjacent else enter 0: ",i,j);
            scanf("%d",&a[i][j]);
        }
        printf("\n");
    }
    printf("ADJACENCY MATRIX: \n");
    for( i=1;i<=n;i++)
    {
        for( j=1;j<=n;j++)
        {
            printf("%d ",a[i][j]);
        }
        printf("\n");
    }
      printf("\n");
      struct node *list[n];
      for( i=1;i<=n;i++)
      {
          list[i]=NULL;
      }
      create(list);
      printf("\nADJACENCY LIST: ");
      print(list);
    }
