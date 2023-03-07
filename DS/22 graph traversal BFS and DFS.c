#include<stdio.h>
int a[20][20],flag=0,result[20],n,front=0,c=0,stack[20],queue[20],top=-1,visited[20];
static int k;
void bfs(int vertex)
{
   int j;
   result[front]=vertex;
   c++;
   visited[vertex]=1;
   for(j=0;j<n;j++)
   {
       if(!visited[j] && a[vertex][j]==1)
       {
          queue[k]=j;
          visited[j]=1;
          k++;
       }
    }
   if(c<=n)
   {    front++;
        bfs(queue[front]);
   }
}
void dfs(int vertex)
{
    while(top>=0)
  {
    flag=0;
    for(int i=0;i<n;i++)
    {
        if(!visited[i] && a[vertex][i]==1)
        {
            visited[i]=1;
            stack[++top]=vertex;
            flag=1;
            vertex=i;
            result[c]=i;
            c++;
            break;
        }
    }
    if(flag==1)
    {
        dfs(vertex);
    }
    else
    {
        dfs(--top);
    }
  }
}
void main()
{
    printf("Enter no. of vertices: ");
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        visited[i]=0;
    }
    printf("Enter adjacency matrix: \n");
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            scanf("%d",&a[i][j]);
        }
    }
    queue[k++]=0;
    bfs(0);
    printf("\nBFS TRAVERSAL RESULT:");
    for(int s=0;s<n;s++)
    {
        printf("%d ",result[s]);
    }
    for(int i=0;i<n;i++)
    {
        visited[i]=0;
    }
    c=0;
    visited[0]=1;
    stack[++top]=0;
    result[c]=0;
    c++;
    dfs(0);
    printf("\nDFS TRAVERSAL RESULT:");
    for(int i=0;i<n;i++)
    {
        printf("%d ",result[i]);
    }
}
