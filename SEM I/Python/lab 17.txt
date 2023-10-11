dict={'b':20,'a':35}
dict['b']=-20
dict['c']=40
print("After negating the first element and adding the last item: ",dict)
print("Sorted dictionary: ",sorted(dict.items()))
dict.pop('b')
print("After deleting the element: ",dict)