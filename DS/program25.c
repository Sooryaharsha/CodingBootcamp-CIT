#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_EDGES 100
#define MAX_VERTICES 100
#define INF 0x3f3f3f3f

int parent[MAX_VERTICES];

struct Edge {
    int src, dest, weight;
};

struct Graph {
    int V, E;
    struct Edge* edge;
};

int v,e,count,i;

struct Graph* createGraph(int V, int E) {
    struct Graph* graph = (struct Graph*) malloc(sizeof(struct Graph));
    graph->V = V;
    graph->E = E;
    graph->edge = (struct Edge*) malloc(graph->E * sizeof(struct Edge));
    return graph;
}

int find(int x) {
    if (parent[x] == x)
        return x;
    return find(parent[x]);
}

int cmp(const void* a, const void* b) {
    struct Edge* a1 = (struct Edge*) a;
    struct Edge* b1 = (struct Edge*) b;
    return a1->weight > b1->weight;
}

void KruskalMST(struct Graph* graph) {
    int V = graph->V;
    int E = graph->E;
    struct Edge result[V];
    int e = 0, i = 0;
    for ( v = 0; v < V; v++)
        parent[v] = v;
    qsort(graph->edge, E, sizeof(graph->edge[0]), cmp);
    while (e < V - 1 && i < E) {
        struct Edge next_edge = graph->edge[i++];
        int x = find(next_edge.src);
        int y = find(next_edge.dest);
        if (x != y) {
            result[e++] = next_edge;
            parent[x] = y;
        }
    }
    int total_weight = 0;
    printf("Following are the edges in the constructed MST\n");
    for (i = 0; i < e; ++i) {
        printf("%d -- %d == %d\n", result[i].src, result[i].dest, result[i].weight);
        total_weight += result[i].weight;
    }
    printf("Total weight of MST is %d\n", total_weight);
}

void primMST(struct Graph* graph) {
    int V = graph->V;
    int E = graph->E;
    int dist[V];
    int visited[V];
    int min_index;
    int total_weight = 0;
    for ( v = 0; v < V; v++) {
        dist[v] = INF;
        visited[v] = 0;
    }
    dist[0] = 0;
    parent[0] = -1;
    for ( count = 0; count < V - 1; count++) {
        min_index = 0;
        int min = INF;
        for ( v = 0; v < V; v++) {
if (visited[v] == 0 && dist[v] < min) {
min = dist[v];
min_index = v;
}
}
visited[min_index] = 1;
total_weight += dist[min_index];
for ( v = 0; v < V; v++) {
for ( e = 0; e < E; e++) {
if (graph->edge[e].src == min_index) {
if (visited[graph->edge[e].dest] == 0 && graph->edge[e].weight < dist[graph->edge[e].dest]) {
dist[graph->edge[e].dest] = graph->edge[e].weight;
parent[graph->edge[e].dest] = min_index;
}
}
}
}
}
printf("Following are the edges in the constructed MST\n");
for ( i = 1; i < V; i++) {
printf("%d - %d == %d\n", parent[i], i, dist[i]);
}
printf("Total weight of MST is %d\n", total_weight);
}

int main() {
int V = 4, E = 5;
struct Graph* graph = createGraph(V, E);
graph->edge[0].src = 0;
graph->edge[0].dest = 1;
graph->edge[0].weight = 10;
graph->edge[1].src = 0;
graph->edge[1].dest = 2;
graph->edge[1].weight = 6;
graph->edge[2].src = 0;
graph->edge[2].dest = 3;
graph->edge[2].weight = 5;
graph->edge[3].src = 1;
graph->edge[3].dest = 3;
graph->edge[3].weight = 15;
graph->edge[4].src = 2;
graph->edge[4].dest = 3;
graph->edge[4].weight = 4;
printf("Kruskal's MST:\n");
KruskalMST(graph);
printf("Prim's MST:\n");
primMST(graph);
return 0;
}
