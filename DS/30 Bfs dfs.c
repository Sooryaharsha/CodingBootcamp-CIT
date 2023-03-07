#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_VERTICES 100

struct Graph {
    int V;
    int adj_mat[MAX_VERTICES][MAX_VERTICES];
};

struct Queue {
    int arr[MAX_VERTICES];
    int front, rear;
};

int i;

struct Graph* createGraph(int V) {
    struct Graph* graph = (struct Graph*) malloc(sizeof(struct Graph));
    graph->V = V;
    for ( i = 0; i < V; i++) {
        for ( j = 0; j < V; j++) {
            graph->adj_mat[i][j] = 0;
        }
    }
    return graph;
}

void addEdge(struct Graph* graph, int src, int dest) {
    graph->adj_mat[src][dest] = 1;
    graph->adj_mat[dest][src] = 1;
}

bool isQueueEmpty(struct Queue* q) {
    return (q->front > q->rear);
}

void enqueue(struct Queue* q, int item) {
    q->arr[++q->rear] = item;
}

int dequeue(struct Queue* q) {
    return q->arr[q->front++];
}

void BFS(struct Graph* graph, int start) {
    bool visited[graph->V];
    for ( i = 0; i < graph->V; i++) {
        visited[i] = false;
    }
    struct Queue* q = (struct Queue*) malloc(sizeof(struct Queue));
    q->front = 0;
    q->rear = -1;
    visited[start] = true;
    enqueue(q, start);
    while (!isQueueEmpty(q)) {
        int curr = dequeue(q);
        printf("%d ", curr);
        for ( i = 0; i < graph->V; i++) {
            if (graph->adj_mat[curr][i] && !visited[i]) {
                visited[i] = true;
                enqueue(q, i);
            }
        }
    }
    printf("\n");
}

void DFSUtil(struct Graph* graph, int v, bool visited[]) {
    visited[v] = true;
    printf("%d ", v);
    for ( i = 0; i < graph->V; i++) {
        if (graph->adj_mat[v][i] && !visited[i]) {
            DFSUtil(graph, i, visited);
        }
    }
}

void DFS(struct Graph* graph, int start) {
    bool visited[graph->V];
    for ( i = 0; i < graph->V; i++) {
        visited[i] = false;
    }
    DFSUtil(graph, start, visited);
    printf("\n");
}

int main() {
    int V = 4;
int value;
struct Graph* graph = createGraph(V);
addEdge(graph, 0, 1);
addEdge(graph, 0, 2);
addEdge(graph, 1, 2);
addEdge(graph, 2, 0);
addEdge(graph, 2, 3);
printf("Enter the value you want to search: ");
scanf("%d", &value);
printf("BFS starting from vertex %d: ", value);
BFS(graph, value);
printf("DFS starting from vertex %d: ", value);
DFS(graph, value);
return 0;
}

