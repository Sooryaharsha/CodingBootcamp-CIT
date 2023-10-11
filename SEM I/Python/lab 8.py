l1= ['soorya','harsha','jaime','jon','raeghar',]
l2=[]
for i in  l1:
    l2.append(i[0])
l2 = sorted([*set(l2)])
print(l2)
l3=[]
for i in l2:
    for j in l1:
        if(i==j[0]):
           l3.append(j)
print(l3)
s=['a','b','c','d','f','h','a','f','c','c']
i=int(input("Enter the first number:" ))
j=int(input("Enter the second number:" ))
print(s[:i])
print(s[i:j])
print(s[j:])
s.insert(2,'e')
s.remove('a')
a=([*set(s)])
print("Result after inserting and removing elements: ",a)
n=[21.4,56.34,9.6,21.9]
n1=[]
for i in range(0,len(n)):
    n1.append(round(n[i]))
print("Sorted list: ",n1)
print("Maximum number in list: ",max(n1))
print("Minimum number in list: ",min(n1))
print("Sum of all numbers: ",sum(n1))
n1.sort()
print("Sorted List",n1)