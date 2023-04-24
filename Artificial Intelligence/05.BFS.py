#BFS
n=int(input("Enter the number of nodes : "))
adjlist={}
for i in range (n):
    key = int(input("Enter the node : "))
    value = [int(item) for item in input("Enter the adjacent nodes : ").split()]
    adjlist[key]=value

visited =[]
q=[]

def bfs(root):
    q.append(root)
    visited.append(root)
    result=[]
    print("Pushed ",root,"into queue")
    while q:
        m = q.pop(0)
        result.append(m)
        
        for adjacent in adjlist[m]:
            if adjacent not in visited:
                visited.append(adjacent)
                q.append(adjacent)
        print("The values in queue are ",q)
    print(result)
                
print("The following is the Breadth First Traversal ")
x=(int(input("Enter the start node : ")))
bfs(x)