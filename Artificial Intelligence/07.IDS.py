from collections import defaultdict
 
n = int(input("Enter No of Nodes:"))
e = int(input("Enter No of Edge:"))
 
graph = defaultdict(list)

#print(graph)
for i in range(e):
    i,j = map(int,input().split())
    graph[i].append(j)
print(graph)

def ids(v,goal,limit):
    if v == goal:
        return 1;
   
    for i in graph[v]:
        if limit-1 >= 0:
            if ids(i,goal,limit-1) !=  -1:
                return 1
    return -1
 
 
goal = int(input("Enter Goal:"))
limit = int(input("Enter Limit:"))
 
res = ids(1,goal,limit)
 
if res == -1:
    print("not found")
else:
    print("found within depth limit")