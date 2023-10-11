#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define V 6
int i;

void printPath(int path[], int len) {
    for ( i = 0; i < len; i++) {
        printf("%d ", path[i]);
    }
    printf("\n");
}

void findAllPaths(int adjMatrix[V][V], int start, int end, bool visited[], int path[], int len) {
    visited[start] = true;
    path[len] = start;
    len++;

    if (start == end) {
        printPath(path, len);
    } else {
        for ( i = 0; i < V; i++) {
            if (adjMatrix[start][i] && !visited[i]) {
                findAllPaths(adjMatrix, i, end, visited, path, len);
            }
        }
    }

    // backtrack
    visited[start] = false;
    len--;
}

void findAllPathsBetweenNodes(int adjMatrix[V][V], int start, int end) {
    bool visited[V];
    memset(visited, false, sizeof(visited));
    int path[V];

    findAllPaths(adjMatrix, start, end, visited, path, 0);
}

int main() {
    int adjMatrix[V][V] = {
        {0, 1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0}
    };

    int start = 0;
    int end = 5;

    printf("All paths from node %d to node %d: \n", start, end);
    findAllPathsBetweenNodes(adjMatrix, start, end);

    return 0;
}
