g={
    'P':[('Q',1),('R',4)],
    'Q':[('R',2),('L',5),('M',12)],
    'R':[('L',2)],
    'L':[('M',3)]
}
H_table={
    'P':7,
    'Q':6,
    'R':4,
    'L':2,
    'M':10
}
def path_cost(path):
    g_cost=0
    for(node,cost) in path:
        g_cost+=cost
    last_node=path[-1][0]
    h_cost=H_table[last_node]
    f_cost=g_cost+h_cost
    return h_cost,last_node
def best_first_search(g,start,goal):
    visited = []
    queue = [[(start,0)]]
    while queue:
        queue.sort(key=path_cost)
        path = queue.pop(0)
        node = path[-1][0]
        if node in visited:
            continue
        visited.append(node)
        if node == goal:
            return path
        else:
            adjacent_node=g.get(node,[])
            for(node2,cost) in adjacent_node:
                new_path = path.copy()
                new_path.append((node2,cost))
                queue.append(new_path)
                print(queue)
sol=best_first_search(g,'P','M')
print("\n\nSolution",sol)