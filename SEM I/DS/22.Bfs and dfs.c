/*BFS and DFS in C


Kishor M
BFS and DFS in graph using c program

Breadth-first search (BFS) and depth-first search (DFS) are both methods for traversing and searching a graph.

Here is an example of a C program that implements BFS using an adjacency list representation of a graph:

Copy code*/

#include <stdio.h>
#include <stdlib.h>

#define MAX_VERTICES 100

struct Vertex {
    int visited;
    int adj_vertices[MAX_VERTICES];
    int adj_vertex_count;
} vertices[MAX_VERTICES];

struct Queue {
    int data[MAX_VERTICES];
    int front, rear;
} queue;

void enqueue(int vertex) {
    queue.data[queue.rear] = vertex;
    queue.rear++;
}

int dequeue() {
    int vertex = queue.data[queue.front];
    queue.front++;
    return vertex;
}

int is_empty() {
    return queue.front == queue.rear;
}

void bfs(int start_vertex) {
    int i, current_vertex;

    vertices[start_vertex].visited = 1;
    enqueue(start_vertex);

    while (!is_empty()) {
        current_vertex = dequeue();
        printf("%d ", current_vertex);

        for (i = 0; i < vertices[current_vertex].adj_vertex_count; i++) {
            if (!vertices[vertices[current_vertex].adj_vertices[i]].visited) {
                vertices[vertices[current_vertex].adj_vertices[i]].visited = 1;
                enqueue(vertices[current_vertex].adj_vertices[i]);
            }
        }
    }
}

int main() {
    int i, j, n, e, v1, v2;

    // input number of vertices and edges
    scanf("%d %d", &n, &e);

    // initialize adjacency list
    for (i = 0; i < n; i++) {
        vertices[i].visited = 0;
        vertices[i].adj_vertex_count = 0;
    }

    // input edges
    for (i = 0; i < e; i++) {
        scanf("%d %d", &v1, &v2);
        vertices[v1].adj_vertices[vertices[v1].adj_vertex_count] = v2;
        vertices[v1].adj_vertex_count++;
        vertices[v2].adj_vertices[vertices[v2].adj_vertex_count] = v1;
        vertices[v2].adj_vertex_count++;
    }

    // perform BFS starting from vertex 0
    bfs(0);
}



