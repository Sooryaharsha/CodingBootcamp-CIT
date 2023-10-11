n=tuple(input("Enter the First tuple: ").split())
n1=tuple(input("Enter the Second tuple: ").split())
print("Comparing the tuples,n>n1: ",n>n1)
print("Comparing the tuples,n<n1: ",n<n1)
n,n1=n1,n
print("After Swapping:",n,n1)
x=n+n1
print("Concatenating the tuples:",x)
cnt=0
for i in x:
    cnt+=1
print("Length of the tuple:",cnt)
min=x[0]
max=x[0]
for i in x:
    if min>i:
        min=i
print("Minimum element",min)
for i in x:
    if max<i:
        max=i
print("Maximum element",max)
print("Reversing the tuple",x[::-1])