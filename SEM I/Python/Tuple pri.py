
#tuples divisible by 6
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
print("\n\nTuples set having numbers only divisible by 6")
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
print("\n\nTuples set having only positive numbers")
print_tuple(temp)


#sorting based on the last element of the tuple
print("\n\nSorting tuples based on last element")
def last(n):
    return n[-1]
def sort(tuples):
    return sorted(tuples,key=last)
print(sort(tup))

#Sort the tuples on basis of total digits in tuple.
print("Sorting tuples based on number of digits")
def count_digs(tup):
    return sum([len(str(ele)) for ele in tup])
tup.sort(key=count_digs)
print("Sorted tuples based on number of digits:",str(tup))

