import numpy
import random
from matplotlib import pyplot as plt

a=[]
#for i in range(100000):
a=numpy.random.randint(0,99,100000)
x=numpy.array(a)
plt.hist(x,bins=100,edgecolor='Black')
plt.xlabel("Value")
plt.ylabel("Frequency")
plt.show()