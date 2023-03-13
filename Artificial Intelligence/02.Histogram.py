import matplotlib.pyplot as plt
import random



array=random.randint(0,5,1000000)
#print(array)

plt.hist(array, edgecolor="red",bins=100,color="black")
plt.hist(array)
plt.show()


    
