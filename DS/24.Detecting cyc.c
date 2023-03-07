#include <stdio.h>
#include <stdbool.h>

#define V 4

bool DFS_visit(int v, bool visited[], int adj[][V], int parent) {
    visited[v] = true;
    int i;
    for ( i = 0; i < V; i++) {
        if (!visited[i] && adj[v][i] == 1) {
            if (DFS_visit(i, visited, adj, v))
                return true;
        } else if (i != parent && adj[v][i] == 1) {
            return true;
        }
    }
    return false;
}

bool isCyclic(int adj[][V]) {
    bool visited[V];
    int i,u;
    for ( i = 0; i < V; i++)
        visited[i] = false;
    for ( u = 0; u < V; u++) {
        if (!visited[u]) {
            if (DFS_visit(u, visited, adj, -1))
                return true;
        }
    }
    return false;
}

int main() {
    int adj[V][V] = {{0, 1, 1, 0},
                     {1, 0, 0, 1},
                     {1, 0, 0, 1},
                     {0, 1, 1, 0}};
    if (isCyclic(adj))
        printf("Graph contains a cycle\n");
    else
        printf("Graph doesn't contain a cycle\n");
}
