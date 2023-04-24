#DFS
          
n=int(input("Enter the number of nodes : "))
adjlist={}
for i in range (n):
    key = int(input("Enter the node : "))
    value = [int(item) for item in input("Enter the adjacent nodes : ").split()]
    adjlist[key]=value

visited =[]
stack=[]
result=[]

def dfs(root):
    
    stack.append(root)
    print("Pushed ",root," into stack")
    while stack:
        n= stack.pop()
        if n not in visited:
            visited.append(n)
            result.append(n)
        for n in adjlist[n]:
            if n not in visited:
             stack.append(n)
        print("The values in stack are ",stack)
    print(result)


x=(int(input("Enter the start node : ")))
print("The DFS traversal is : ")
dfs(x)