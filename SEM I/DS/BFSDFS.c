#include <stdio.h>
#include <stdlib.h>
#define MAX_VERTICES 100
#define MAX_EDGES 500

int n;
int e;
int adj[MAX_VERTICES][MAX_VERTICES];
int visited[MAX_VERTICES];
void DFS(int v, int searchValue) {
    int i;
    printf("Visiting vertex %d\n", v);
    visited[v] = 1;
    if (v == searchValue) {
        printf("Value found!\n");
        return;
    }
    for (i = 0; i < n; i++) {
        if (adj[v][i] == 1 && !visited[i]) {
            DFS(i, searchValue);
        }
    }
}
void BFS(int start, int searchValue) {
    int queue[MAX_VERTICES];
    int front = 0, rear = 0;
    int i, current;
    printf("Visiting vertex %d\n", start);
    visited[start] = 1;
    queue[rear++] = start;
    while (front != rear) {
        current = queue[front++];
        if (current == searchValue) {
            printf("Value found!\n");
            return;
        }
        for (i = 0; i < n; i++) {
            if (adj[current][i] == 1 && !visited[i]) {
                printf("Visiting vertex %d\n", i);
                visited[i] = 1;
                queue[rear++] = i;
            }
        }
    }
}
int main() {
    int i, j, a, b;
    printf("Enter the number of vertices: ");
    scanf("%d", &n);
    printf("Enter the number of edges: ");
    scanf("%d", &e);
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            adj[i][j] = 0;
        }
    }
    for (i = 0; i < e; i++) {
        printf("Enter edge %d (a b): ", i+1);
        scanf("%d %d", &a, &b);
        adj[a][b] = adj[b][a] = 1;
    }
    int searchValue;
    printf("Enter the value to search for: ");
    scanf("%d", &searchValue);
    printf("\nDFS:\n");
    for (i = 0; i < n; i++) {
        visited[i] = 0;
    }
    DFS(0, searchValue);
    printf("\nBFS:\n");
    for (i = 0; i < n; i++) {
        visited[i] = 0;
    }
    BFS(0, searchValue);
    return 0;
}
