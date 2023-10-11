m1=int(input("Enter no. of rows in A: "))
n1=int(input("Enter no. of columns in A: "))
arr=[]
for i in range(m1):
    row=[]
    for j in range(n1):
        print("Enter value [",i,",",j,"]:",end="")
        row.append(int(input()))
    arr.append(row)
m2=int(input("Enter no. of rows in B: "))
n2=int(input("Enter no. of columns in B: "))
brr=[]
for i in range(m2):
    row=[]
    for j in range(n2):
        print("Enter value [",i,",",j,"]:",end="")
        row.append(int(input()))
    brr.append(row)
print("The matrix A: ")
for i in range(m1):
    for j in range(n1):
        print(arr[i][j],end=" ")
    print()
print("The matrix B: ")
for i in range(m2):
    for j in range(n2):
        print(brr[i][j],end=" ")
    print()

if(m1==m2 and n1==n2):
    c=[]
    for i in range(m1):
        row=[]
        for j in range(m2):
            row.append(arr[i][j]+brr[i][j])
        c.append(row)
    print("The SUM of A and B: ")
    for i in range(m1):
        for j in range(n1):
            print(c[i][j],end=" ")
        print()
else:
    print("NOT VALID MATRIX FORM TO ADD")

if(n1==m2):
    mul=[]
    for i in range(m1):
        row=[]
        for j in range(n2):
            sum1=0
            for k in range(m2):
                sum1+=arr[i][k]*brr[k][j]
            row.append(sum1)
        mul.append(row)
    print("The MULTIPLICATION of A and B: ")
    for i in range(m1):
        for j in range(n2):
            print(mul[i][j],end=" ")
        print()
else:
    print("NOT VALID MATRIX FORM TO MULTIPLY")

#transpose

print("The transposed matrix A: ")
for i in range(m1):
    for j in range(n1):
        print(arr[j][i],end=" ")
    print()
print("The transposed matrix B: ")
for i in range(m2):
    for j in range(n2):
        print(brr[j][i],end=" ")
    print()

#store stransposematrix in another matrix
tarr=[]

for i in range(m1):
    for j in range(n1):
        tarr[i][j]=arr[j][i]
tbrr=[]
for i in range(m2):
    for j in range(n2):
        tbrr[i][j]=brr[j][i]
print("The transposed matrix TA: ")
for i in range(m1):
    for j in range(n1):
        print(tarr[j][i],end=" ")
    print()

print("The transposed matrix TB: ")
for i in range(m2):
    for j in range(n2):
        print(tbrr[j][i],end=" ")
    print()
                
    

            
