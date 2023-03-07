d={}
n=int(input("Enter the number of items: "))
for i in range(n):
    key=input("Enter the Product name: ")
    value=input("Enter the Price: ")
    d[key]=value
print(d)
n=input("Enter the value to compare: ")
p={}
for i,j in d.items():
    if j<n:
        p[i]=j
print(p)