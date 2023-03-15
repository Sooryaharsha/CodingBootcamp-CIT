import numpy
import random
from matplotlib import pyplot as plt

a=[]
for i in range(100000):
    a.append(random.randint(0,100))
x=numpy.array(a)
plt.hist(x,bins=100,edgecolor='Black')
plt.show()