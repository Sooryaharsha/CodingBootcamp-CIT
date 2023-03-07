import numpy as np
r=4
c=5
d=r*c
a =[]
for j in range(d):
	a.append(int(input()))
print(a)
arr = np.array([a])
newarr = arr.reshape(4, 5)
print(newarr)

print(newarr-2)
print(np.ndim(newarr))
print(newarr.shape)
b=[]
b=newarr.flatten()
print(b)
print(newarr[0:2,0:5:2])
z=np.min(newarr)
print(z)

r=np.cumsum(newarr,axis=1)
print(r[0:4,-1])

r=np.sort(newarr,axis=1)
print(r)
#merge sort pending