a=[1,2,3,4,5,1,2,5]
b=[]
c=[]
n=len(a)
start=0
print(n)

pfn=(int(input("Enter the no of Page frames : ")))
for i in range (0,pfn):
    b.append(a[i])
    start+=1
print("The Process in the Page Frames are :")
for i in b:
    print(i)
choice=1
while choice:
    print("Do you want to add a new Process from the list? (0/1) : ")
    choice = (int(input()))
    if(choice==1):
        for i in range(start+1,n):
            c.append(a[i])
        
        for i in c:
            print(i)
        
        for i in range(0,pfn):
            if(b[i] not in c ):
                 print("Deleted Process Id : ",b[i])
                 del b[i]
                 b.append(a[start])
                 start+=1
                 break;   
    else:
        choice=0;
    print("The Process in the Page Frames are :")   

    

