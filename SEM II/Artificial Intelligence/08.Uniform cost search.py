g={
    'R':[('X',2),('Y',3),('P',5)],
    'X':[('Z',4)],
    'Y':[('P',4)],
    'Z':[('P',1),('Q',2)],
    'P':[('Q',5)]
}
def path_cost(path):
    total_cost=0
    for(node,cost) in path:
        total_cost+=cost
    return total_cost,path[-1][0]
def uni_cost(g,s,goal):
    visited=[]
    queue=[[(s,0)]]
    
    while queue:
        queue.sort(key=path_cost)
        print(queue)
        path=queue.pop(0)
        node=path[-1][0]
        if node in visited:
            continue
        visited.append(node)
        if node==goal:
            return path
        else:
            adjacent_node=g.get(node,[])
            for(node2,cost) in adjacent_node:
                new_path = path.copy()
                new_path.append((node2,cost))
                queue.append(new_path)

sol=uni_cost(g,'R','Q')
print("Solution",sol)
print("cost of solution",path_cost(sol))