import random
def merge(arr,L,mid,r):
    n1=mid-L+1
    n2=r-mid
    l=[0]*(n1)
    r=[0]*(n2)
    for i in range(0,n1):
        l[i]=arr[L+i] #why L+1 ?
    for j in range(0,n2):
        r[j]=arr[mid+j+1]
    i=0
    j=0
    k=L #k=L because L is the starting address of any subarray either left or right
    while(i<n1 and j<n2):
        if l[i]<=r[j]:
            arr[k]=l[i]
            i+=1
            k+=1
        else:
            arr[k]=r[j]
            j+=1
            k=k+1
    while i<n1:
        arr[k]=l[i]
        i=i+1
        k=k+1
    while j<n2:
        arr[k]=r[j]
        j+=1
        k+=1

def mergesort(arr,L,r):
    if(L<r):
        mid=L+(r-L)//2 #same as L+r//2 but avoids overflow for larger L and h
        mergesort(arr,L,mid)
        mergesort(arr,mid+1,r)
        merge(arr,L,mid,r)
a=[]
for i in range(4):
    col=[]
    for j in range(5):
        col.append(random.randint(0,100))
    a.append(col)
print("The original 4*5 array: ",a)
for i in range(4):
    for j in range(5):
        a[i][j]=a[i][j]-2
print("After subtracting 2 from each element",a)
r=0
c=1
for i in a:
    r=r+1
for j in a[0]:
    c=c+1
print("The dimension: ",r,"*",c)
r=len(a)
c=len(a[0])
print("The dimension: ",r,"*",c)
print("The shape of array: ")
for i in range(r):
    for j in range(c):
        print("*",end=" ")
    print()
b=[]
for i in range(r):
    for j in range(c):
        b.append(a[i][j])
print("Stored flattend array in another array: ",b)

#cummulative sum
for i in range(r):
    s=0
    for j in range(c):
        s+=a[i][j]
    print("Sum of row",i+1,"is:",s)
#To find minimum value  
m=0
n=0
for i in range(r):
    for j in range(c):
        if(a[i][j]<a[m][n]):
           m=i
           n=j
print("The minimum of all: ",a[m][n])

#To find min in each row
for i in range(r):
    minidx=0
    for k in range(c):
        if(a[i][k]<a[i][minidx]):
            minidx=k;
    print("The min value in row",i+1,"is:",a[i][minidx])

#Slicing array with first 2 rows and alternate columns
slice1=[]
for i in range(2):
    cc=[]
    for j in range(len(a[0])):
        if(j%2==0):
            cc.append(a[i][j])
    slice1.append(cc)

print("After slicing with first 2 rows & alternate columns: ", slice1)
print("Given array: ",a) 
#Merge sort calling

for i in range(r):
    n=len(a[i])
    mergesort(a[i],0,n-1)
print("Sorted array: ",a) 

    


            


        


