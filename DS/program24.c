#include <stdlib.h>
int index;
struct AjlistNode
{
	int id;
	struct AjlistNode *next;
};
struct Vertices
{
	int data;
	struct AjlistNode *next;
	struct AjlistNode *last;
};
struct Graph
{
	int size;
	struct Vertices *node;
};
void setData(struct Graph *g)
{
	if (g->node != NULL)
	{
		int index = 0;
		for (index = 0; index < g->size; index++)
		{
			g->node[index].data = index;
			g->node[index].next = NULL;
			g->node[index].next = NULL;
		}
	}
	else
	{
		printf("Vertic Node is Empty");
	}
}

struct Graph *newGraph(int size)
{
	if (size < 1)
	{
		printf("\n Invalid graph size ");
		exit(0);
	}
	struct Graph *g = (struct Graph *)
	malloc(sizeof(struct Graph));
	g->size = size;
	g->node = (struct Vertices *)
	malloc(sizeof(struct Vertices) *size);
	setData(g);
	return g;
}
void connect(struct Graph *g, int start, int last)
{
	struct AjlistNode *edge = (struct AjlistNode *)
	malloc(sizeof(struct AjlistNode));
	if (edge != NULL)
	{
		edge->id = last;
		edge->next = NULL;
		if (g->node[start].next == NULL)
		{
			g->node[start].next = edge;
		}
		else
		{
			g->node[start].last->next = edge;
		}
		g->node[start].last = edge;
	}
	else
	{
		printf("\n Memory overflow to create edge");
	}
}
void addEdge(struct Graph *g, int start, int last)
{
	if (start < g->size && last < g->size)
	{
		connect(g, start, last);
	}
	else
	{
		printf("Invalid Node Vertices %d  %d", start, last);
	}
}
void printGraph(struct Graph *g)
{
	if (g != NULL)
	{
		struct AjlistNode *temp = NULL;
		for ( index = 0; index < g->size; index++)
		{
			printf("\n Adjacency list of vertex %d  :", index);
			temp = g->node[index].next;
			while (temp != NULL)
			{
				printf("  %d", g->node[temp->id].data);
				temp = temp->next;
			}
		}
	}
	else
	{
		printf("Empty Graph");
	}
}
int detectCycle(struct Graph *g,
                int start, int point, int visit[])
{
	if (visit[start] == 1 && point == start)
	{

		return 1;
	}
	else if (visit[point] == 1)
	{
		return 0;
	}
    visit[point] = 1;
	struct AjlistNode *temp = g->node[point].next;
	int status = 0;
	while (temp != NULL && !status)
	{
		status = detectCycle(g, start, temp->id, visit);
		temp = temp->next;
	}
	return status;
}
void checkCycle(struct Graph *g)
{
	if (g->size <= 0)
	{
		printf("Empty Graph\n");
		return;
	}
	printGraph(g);
	int visit[g->size];
	int result = 0;
	int location = 0;
	while (location < g->size && result == 0)
	{
		for ( index = 0; index < g->size; index++)
		{
			visit[index] = 0;
		}
		result = detectCycle(g, location, location, visit);
		location++;
	}
	if (result == 1)
	{
		printf("\n Result : Detect Cycle\n");
	}
	else
	{
		printf("\n Result : No Cycle\n");
	}
}
int main()
{
	struct Graph *g = newGraph(6);
	addEdge(g, 0, 1);
	addEdge(g, 0, 3);
	addEdge(g, 1, 2);
	addEdge(g, 2, 5);
	addEdge(g, 3, 4);
	addEdge(g, 4, 2);
	// Test A
	checkCycle(g);

	addEdge(g, 5, 1);
	// Test B
	checkCycle(g);
	return 0;
}
