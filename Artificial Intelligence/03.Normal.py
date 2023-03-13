import random
import statistics
import numpy 
import matplotlib.pyplot as plt
from scipy.stats import norm

x=numpy.random.uniform(0.0, 5.0, 100000)



mean=statistics.mean(x)
sd = statistics.stdev(x)

plt.plot(x, norm.pdf(x, mean,sd))
plt.show()