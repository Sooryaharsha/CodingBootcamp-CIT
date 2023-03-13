
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import norm
import statistics
    
# Plot between -30 and 30 with
# 0.1 steps.
x_axis = np.arange(-30, 30, 0.1)
    
# Calculating mean and standard 
# deviation
mean = statistics.mean(x_axis)
sd = statistics.stdev(x_axis)
    
plt.plot(x_axis, norm.pdf(x_axis, mean, sd))
plt.show()