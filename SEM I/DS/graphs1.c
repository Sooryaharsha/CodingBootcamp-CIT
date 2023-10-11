//directed graph cyclic
#include<stdio.h>
#include<stdlib.h>
#define MAX 100
#define initial 1
#define visited 2
#define finished 3
int n;    /*Number of vertices in the graph */
int adj[MAX][MAX];
void create_graph( );
int state[MAX];
void DF_Traversal();
void DFS(int v);
int main()
{
        create_graph();
        DF_Traversal();
        return 0;
}/*End of main()*/
void DF_Traversal()
{
        int v;
        for(v=0; v<n; v++)
                state[v] = initial;
        DFS(0);/*start DFS from vertex 0*/
        for(v=0; v<n; v++)
        {
                if(state[v]==initial)
                        DFS(v);
        }
        printf("\nGraph is Acyclic\n");
}/*End of DF_Traversal( )*/
void DFS(int v)
{
        int i;
        state[v] = visited;
        for(i=0; i<n; i++)
        {
                if(adj[v][i]==1)
                {
                        if(state[i]==initial)
                                DFS(i);
                        else if(state[i]==visited)
                        {
                                printf("\nBack edge  (%d,%d) found\n", v, i);
                                printf("\nGraph is cyclic\n");
                                exit(1);
                        }
                }
        }
        state[v] = finished;
}/*End of DFS()*/
void create_graph()
{
        int i,max_edges,origin,destin;
        printf("\nEnter number of vertices : ");
        scanf("%d",&n);
        max_edges = n*(n-1);
        for(i=1;i<=max_edges;i++)
        {
                printf("\nEnter edge %d( -1 -1 to quit ) : ",i);
                scanf("%d %d",&origin,&destin);
                if( (origin == -1) && (destin == -1) )
                        break;
                if( origin >= n || destin >= n || origin<0 || destin<0)
                {
                        printf("\nInvalid edge!\n");
                        i--;
                }
                else
                {
                        adj[origin][destin] = 1;
                }
        }
}


//undirected graph cyclic
#include<stdio.h>
#include<stdlib.h>
#define MAX 100
#define NIL -1
#define initial 1
#define visited 2
#define finished 3
int adj[MAX][MAX];
int n;    /* Denotes number of vertices in the graph */
int state[MAX];
int predecessor[MAX];
void create_graph();
void DF_Traversal();
void DFS(int v);
int main()
{
        create_graph();
        DF_Traversal();
        return 0;
}/*End of main()*/
void DF_Traversal()
{
        int v;
        for(v=0; v<n; v++)
        {
                state[v] = initial;
                predecessor[v] = NIL;
        }
        DFS(0); /*start from vertex 0*/
        for(v=0; v<n; v++)
        {
                if(state[v] == initial)
                        DFS(v);
        }
        printf("\nGraph is acyclic\n");
}/*End of DF_Traversal()*/
void DFS(int v)
{
        int i;
        state[v] = visited;
        for(i=0; i<n; i++)
        {
                if( adj[v][i] == 1 && predecessor[v]!=i )
                {
                        if( state[i] == initial)
                        {
                                predecessor[i]=v;
                                DFS(i);
                        }
                        else if(state[i] == visited )
                        {
                                printf("\nBack edge (%d,%d) detected \n", v, i);
                                printf("\nGraph is cyclic\n");
                                exit(1);
                        }
                }
        }
        state[v] = finished;
}/*End of DFS()*/
void create_graph()
{
        int i,max_edges,origin,destin;
        printf("\nEnter number of vertices : ");
        scanf("%d",&n);
        max_edges = n*(n-1)/2;
        for(i=1;i<=max_edges;i++)
        {
                printf("\nEnter edge %d( -1 -1 to quit ) : ",i);
                scanf("%d %d",&origin,&destin);
                if( (origin == -1) && (destin == -1) )
                        break;
                if( origin >= n || destin >= n || origin<0 || destin<0)
                {
                        printf("\nInvalid edge!\n");
                        i--;
                }
                else
                {
                        adj[origin][destin] = 1;
                        adj[destin][origin] = 1;
                }
        }
}


/*  C Program to implement DFS Algorithm for Connected Graph */

#include<stdio.h>
#include<stdlib.h>

#define MAX 100

#define initial 1
#define visited 2

int n;    /* Number of nodes in the graph */
int adj[MAX][MAX]; /*Adjacency Matrix*/
int state[MAX]; /*Can be initial or visited */

void DF_Traversal();
void DFS(int v);
void create_graph();

int stack[MAX];
int top = -1;
void push(int v);
int pop();
int isEmpty_stack();

main()
{
        create_graph();
        DF_Traversal();
}/*End of main()*/

void DF_Traversal()
{
        int v;

        for(v=0; v<n; v++)
                state[v]=initial;

        printf("\nEnter starting node for Depth First Search : ");
        scanf("%d",&v);
        DFS(v);
        printf("\n");
}/*End of DF_Traversal( )*/

void DFS(int v)
{
        int i;
        push(v);
        while(!isEmpty_stack())
        {
                v = pop();
                if(state[v]==initial)
                {
                        printf("%d ",v);
                        state[v]=visited;
                }
                for(i=n-1; i>=0; i--)
                {
                        if(adj[v][i]==1 && state[i]==initial)
                                push(i);
                }
        }
}/*End of DFS( )*/

void push(int v)
{
        if(top == (MAX-1))
        {
                printf("\nStack Overflow\n");
                return;
        }
        top=top+1;
        stack[top] = v;

}/*End of push()*/

int pop()
{
        int v;
        if(top == -1)
        {
                printf("\nStack Underflow\n");
                exit(1);
        }
        else
        {
                v = stack[top];
                top=top-1;
                return v;
        }
}/*End of pop()*/

int isEmpty_stack( )
{
  if(top == -1)
          return 1;
  else
          return 0;
}/*End if isEmpty_stack()*/

void create_graph()
{
        int i,max_edges,origin,destin;

        printf("\nEnter number of nodes : ");
        scanf("%d",&n);
        max_edges=n*(n-1);

        for(i=1;i<=max_edges;i++)
        {
                printf("\nEnter edge %d( -1 -1 to quit ) : ",i);
                scanf("%d %d",&origin,&destin);

                if( (origin == -1) && (destin == -1) )
                        break;

                if( origin >= n || destin >= n || origin<0 || destin<0)
                {
                        printf("\nInvalid edge!\n");
                        i--;
                }
                else
                {
                        adj[origin][destin] = 1;
                }
        }
}


/* C Program to implement BFS Algorithm for Connected Graph */

#include<stdio.h>
#include<stdlib.h>

#define MAX 100

#define initial 1
#define waiting 2
#define visited 3

int n; /*Number of vertices in the graph*/
int adj[MAX][MAX]; /*Adjacency Matrix*/
int state[MAX]; /*can be initial, waiting or visited*/

void create_graph();
void BF_Traversal();
void BFS(int v);

int queue[MAX], front = -1,rear = -1;
void insert_queue(int vertex);
int delete_queue();
int isEmpty_queue();

int main()
{
 create_graph();
 BF_Traversal();

 return 0;

}/*End of main()*/

void BF_Traversal()
{
 int v;

 for(v=0; v<n; v++)
 state[v] = initial;

 printf("\nEnter starting vertex for Breadth First Search : ");
 scanf("%d", &v);
 BFS(v);
}/*End of BF_Traversal()*/

void BFS(int v)
{
 int i;

 insert_queue(v);
 state[v] = waiting;

 while(!isEmpty_queue())
 {
 v = delete_queue( );
 printf("%d ",v);
 state[v] = visited;

 for(i=0; i<n; i++)
 {
 /*Check for adjacent unvisited vertices */
 if(adj[v][i] == 1 && state[i] == initial)
 {
 insert_queue(i);
 state[i] = waiting;
 }
 }
 }
 printf("\n");
}/*End of BFS()*/

void insert_queue(int vertex)
{
 if(rear == MAX-1)
 printf("\nQueue Overflow\n");
 else
 {
 if(front == -1) /*If queue is initially empty */
 front = 0;
 rear = rear+1;
 queue[rear] = vertex ;
 }
}/*End of insert_queue()*/

int isEmpty_queue()
{
 if(front == -1 || front > rear)
 return 1;
 else
 return 0;
}/*End of isEmpty_queue()*/

int delete_queue()
{
 int del_item;
 if(front == -1 || front > rear)
 {
 printf("\nQueue Underflow\n");
 exit(1);
 }

 del_item = queue[front];
 front = front+1;
 return del_item;
}/*End of delete_queue() */

void create_graph()
{
 int i,max_edges,origin,destin;

 printf("\nEnter number of vertices : ");
 scanf("%d",&n);
 max_edges = n*(n-1);

 for(i=1; i<=max_edges; i++)
 {
 printf("\nEnter edge %d( -1 -1 to quit ) : ",i);
 scanf("%d %d",&origin,&destin);

 if((origin == -1) && (destin == -1))
 break;

 if(origin>=n || destin>=n || origin<0 || destin<0)
 {
 printf("\nInvalid edge!\n");
 i--;
 }
 else
 {
 adj[origin][destin] = 1;
 }
 }/*End of for*/
}/*End of create_graph()*/


/* C Program for Traversing Undirected Graph through DFS Recursively */

#include<stdio.h>
#define MAX 100

#define initial 1
#define visited 2
#define finished 3

int adj[MAX][MAX];

int n;    /* Denotes number of vertices in the graph */

int state[MAX];
int predecessor[MAX];

void create_graph();
void DFS(int v);
void DF_Traversal();

int main()
{
        create_graph();
        DF_Traversal();
        return 0;
}/*End of main()*/

void DF_Traversal()
{
        int v;
        for(v=0; v<n; v++)
        {
                state[v] = initial;
                predecessor[v] = -1;
        }
        printf("\nEnter starting vertex for Depth First Search : ");
        scanf("%d",&v);
        DFS(v);
        for(v=0; v<n; v++)
        {
                if(state[v] == initial)
                        DFS(v);
        }
}/*End of DF_Traversal()*/

void DFS(int v)
{
        int i;
        state[v] = visited;
        printf("%d  ",v);
        for(i=0; i<n; i++)
        {
                if(adj[v][i] == 1)
                {
                        if(state[i] == initial)
                                DFS(i);
                }
        }
        state[v] = finished;
}/*End of DFS()*/


void create_graph()
{
        int i,max_edges,origin,destin;

        printf("Enter number of vertices : ");
        scanf("%d",&n);
        max_edges = n*(n-1)/2;

        for(i=1; i<=max_edges; i++)
        {
                printf("\nEnter edge %d( -1 -1 to quit ) : ",i);
                scanf("%d %d",&origin,&destin);

                if( (origin == -1) && (destin == -1) )
                        break;

                if( origin >= n || destin >= n || origin<0 || destin<0)
                {
                        printf("\nInvalid edge!\n");
                        i--;
                }
                else
                {
                        adj[origin][destin] = 1;
                        adj[destin][origin] = 1;
                }
        }
}

/*  C Program for traversing a Directed Graph through DFS recursively  */

#include<stdio.h>
#define MAX 100

#define initial 1
#define visited 2
#define finished 3

int n;    /*Number of vertices in the graph */
int adj[MAX][MAX];
void create_graph();

int state[MAX];
void DF_Traversal();
void DFS(int v);

int main()
{
        create_graph();
        DF_Traversal();

        return 0;

}/*End of main()*/

void DF_Traversal()
{
        int v;

        for(v=0; v<n; v++)
                state[v] = initial;

        printf("\nEnter starting vertex for Depth First Search : ");
        scanf("%d",&v);
        DFS(v);
        for(v=0; v<n; v++)
        {
                if(state[v] == initial)
                        DFS(v);
        }
        printf("\n");
}/*End of DF_Traversal()*/

void DFS(int v)
{
        int i;
        printf("%d ",v);
        state[v] = visited;

        for(i=0; i<n; i++)
        {
                if(adj[v][i] == 1 && state[i] == initial)
                                DFS(i);
        }
        state[v] = finished;
}/*End of DFS()*/

void create_graph()
{
        int i,max_edges,origin,destin;

        printf("\nEnter number of vertices : ");
        scanf("%d",&n);
        max_edges = n*(n-1);

        for(i=1; i<=max_edges; i++)
        {
                printf("\nEnter edge %d( -1 -1 to quit ) : ",i);
                scanf("%d %d",&origin,&destin);

                if( (origin == -1) && (destin == -1) )
                        break;

                if( origin >= n || destin >= n || origin<0 || destin<0)
                {
                        printf("\nInvalid edge!\n");
                        i--;
                }
                else
                {
                        adj[origin][destin] = 1;
                }
        }/*End of for*/
}/*End of create_graph()*/


//bfs directed
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_VERTICES 100

int graph[MAX_VERTICES][MAX_VERTICES];
int visited[MAX_VERTICES];
int queue[MAX_VERTICES];
int front = -1, rear = -1;
int V;

void addEdge(int graph[][MAX_VERTICES], int u, int v) {
graph[u][v] = 1;
}

void BFS(int start) {
int i, current;

for (i = 0; i < V; i++) {
visited[i] = 0;
}

queue[++rear] = start;
visited[start] = 1;

while (front != rear) {
current = queue[++front];
printf("%d ", current);


for (i = 0; i < V; i++) {
  if (graph[current][i] == 1 && !visited[i]) {
    queue[++rear] = i;
    visited[i] = 1;
  }
}
}
}

int main() {
int i, j;

printf("Enter the number of vertices: ");
scanf("%d", &V);

for (i = 0; i < V; i++) {
for (j = 0; j < V; j++) {
graph[i][j] = 0;
}
}

addEdge(graph, 0, 2);
addEdge(graph, 0, 3);
addEdge(graph, 2, 4);
addEdge(graph, 3, 2);
addEdge(graph, 4, 1);

BFS(0);

return 0;
}

//bfs undirected
#include <stdio.h>
#define MAX 100

int adj[MAX][MAX]; // adjacency matrix to represent the graph
int n; // number of vertices
bool visited[MAX]; // array to keep track of visited vertices

void BFS(int s)
{
    int queue[MAX], front = 0, rear = 0; // queue for BFS
    queue[rear++] = s;
    visited[s] = true;

    while (front != rear) {
        int curr = queue[front++];
        printf("%d ", curr);

        for (int i = 0; i < n; i++) {
            if (adj[curr][i] && !visited[i]) {
                queue[rear++] = i;
                visited[i] = true;
            }
        }
    }
}

int main()
{
    // Input the number of vertices
    printf("Enter the number of vertices: ");
    scanf("%d", &n);

    // Input the adjacency matrix
    printf("Enter the adjacency matrix:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &adj[i][j]);
        }
    }

    // Initialize visited array to false
    for (int i = 0; i < n; i++) {
        visited[i] = false;
    }

    // Perform BFS starting from vertex 0
    printf("BFS traversal: ");
    BFS(0);
    printf("\n");

    return 0;
}
