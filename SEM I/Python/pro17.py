dict={'b':20,'a':35}
dict['b']=-20
dict['c']=40
print("After negating: ",dict)
print("Sorted dictionary: ",sorted(dict.items()))
dict.pop('b')
print("After deleting : ",dict)
