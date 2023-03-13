import random
import statistics
import numpy as np
import matplotlib.pyplot as plt

x = random.random()
list=[]
# Random float number
for i in range(250):
   list.append(random.uniform(0,5))
print("\nPrinting 250 random float values between 0 and 5\n")
#print(list)

sum=0
for i in list:
    sum=sum+i

mean = sum/250

print("The sum of given is ",sum)
print("The Mean is ",mean)
print("The median is : ",statistics.median(list))
print("The Mode is : ",statistics.mode(list))
print("The Standard Deviation is : ",statistics.stdev(list))
print("The 75th percentile is : ",np.percentile(list,75))

plt.hist(list)
plt.show() 