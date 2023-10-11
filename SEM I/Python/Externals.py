import numpy as np

r=int(input("Enter the no of rows : "))
c=int(input("Enter the no of columns : "))
totval =r*c

print("Enter the A matrix values : ")
list1=[]
for i in range(totval):
    an=int(input())
    list1.append(an)
print(list1)

print("A Matrix values")
arr = np.array(list1)
a=arr.reshape(r,c)
print(a)


print("Enter the B matrix values : ")
list2=[]
for i in range(totval):
    an=int(input())
    list2.append(an)

print(" B matrix values : ")
arr2 = np.array(list2)
b=arr2.reshape(r,c)
print(b)

#min elem in each row

for i in range(0,r) :
    min=0
    for j in range(0,c-1):
        if a[i][j]<a[i][min]:
            min=j
    print("Minimum elem in", i+1, "row is : ",a[i][min])

#sum of columns

for j in range(c):
    sum=0
    for i in range(r):
        sum+=b[i][j]
    print("sum of ",j+1,"column :",sum)
    
#sub matrix

r2=int(input("Enter the rows of sub matrix :  "))
c2=int(input("Enter the col of sub matrix :  "))

for i in range(0,r2) :
    for j in range(0,c2):
        print(a[i][j],end=" ")
    print("\n")
    
#upper triangular matrix
f=0
print("The upper triangular matrix is : ")
for i in range(0,r):
    for s in range(i):
        print("0",end=" ")
    for j in range(i,c):
        print(a[i][j],end=" ")
    print("\n")
            


#symmentic or not

bt=[[0,0,0],[0,0,0],[0,0,0]]
for i in range(0,r):
    for j in range(0,c):
        bt[i][j]=b[j][i]
print("Transpose matrix is : ")
for i in range(0,r):
    for j in range(0,c):
        print(bt[i][j],end=" ")
    print("\n")

flag=0
for i in range(r):
    for j in range(c):
        if(b[i][j]!=bt[i][j]):
            flag+=1
if flag==0:
    print("The  matrix B is symmentric ")
else:
    print("The  matrix B is not symmentric !!!")
    

            
        
            
        
    
    