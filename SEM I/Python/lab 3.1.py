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
print("Tuples set having only positive numbers")
print_tuple(temp)

list7=[12,34,32,34]
print(list7)
print(tuple(list7))           

#sorting based on the last element

        
       
