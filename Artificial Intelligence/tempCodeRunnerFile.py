from collections import defaultdict
 
n = int(input("Enter No of Nodes:"))
e = int(input("Enter No of Edge:"))
 
graph = defaultdict (list)
 
for i in range(e):
    key,value= map(int,input().split())
    #value = int(input())
    graph[key].append(value)

print(graph)