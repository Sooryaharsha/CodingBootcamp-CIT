//finding all paths
#include <stdio.h>
#include <stdbool.h>

#define V 4

void DFS(int v, bool visited[], int adj[][V], int start, int target) {
    visited[v] = true;
    int i;
    if (v == target) {
        printf("Path found!\n");
        return;
    }
    for ( i = 0; i < V; i++) {
        if (!visited[i] && adj[v][i] == 1) {
            DFS(i, visited, adj, start, target);
        }
    }
}

void printAllPaths(int adj[][V], int start, int target) {
    bool visited[V];
    int i;
    for ( i = 0; i < V; i++)
        visited[i] = false;
    DFS(start, visited, adj, start, target);
}

int main() {
    int adj[V][V] = {{0, 1, 1, 0},
                     {1, 0, 0, 1},
                     {1, 0, 0, 1},
                     {0, 1, 1, 0}};
    int start = 0, target = 3;
    printAllPaths(adj, start, target);
}

