l1=[5,3,7]
l1[0]=-l1[0]
print(l1)
l1.append(10)
print(l1)
l1.insert(2,22)
print(l1)
del l1[0]
print(l1)
l2=[1,23,56]
l1.extend(l2)
print(l1)
print(l1.index(7))
l1.sort()
print(l1)