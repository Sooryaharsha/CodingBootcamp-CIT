tup=[(6,24,12),(60,12,6,-300),(12,-18,21)]
temp=[]
def print_tuple(temp):
    for i in temp:
        if(i!=[]):
            print(tuple(i))
for i in tup:
    a=[]
    for j in i:
        if(j%6==0):
            a.append(j)
        else:
            a.clear()
            break;
    temp.append(a)
print("Tuples set having numbers only divisible by 6")
print_tuple(temp)

#FINDING POSITIVE ELEMENT
temp=[]
for i in tup:
    a=[]
    for j in i:
        if(j>0):
            a.append(j)
        else:
            a.clear()
            break;
    temp.append(a)
print("Tuples set having only positive numbers")
print_tuple(temp)

#SORTING ELEMENTS BASED ON LAST ELEMENT

for i in range(0,len(tup),1):
    for j in range(i+1,len(tup)-1,1):
        if(tup[i][-1]>tup[j][-1]):
           tup[i],tup[j]=tup[j],tup[i]
print("SORTing BASED ON LAST ELEMENT:\n",tup)

#SORTING BASED ON NUMBER OF ITEMS

ini=0
y=0
for i in range(0,len(tup)-1,1):
    if(len(tup[i])>len(tup[i+1])):
           temp=tup[i]
           tup[i]=tup[i+1]
           tup[i+1]=temp

print("SORTING BASED ON TOTAL COUNT:\n",tup)