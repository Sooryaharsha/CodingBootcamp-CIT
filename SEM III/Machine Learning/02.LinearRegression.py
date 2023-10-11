import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

# Read the CSV data into a Pandas DataFrame
df = pd.read_csv("D:\College\SEM III\Machine Learning\score.csv")

# Extract the x and y variables
x = df[["Hours"]]  # Convert to a DataFrame or a 2D array-like structure
y = df["Score"]

# Fit a linear regression model
model = LinearRegression()
model.fit(x, y)

# Print the coefficients of the model
print("Coefficient:", model.coef_)
print("Intercept:", model.intercept_)

# Plot the data and the fitted line
plt.scatter(x, y)
plt.plot(x, model.predict(x), color="red")  # Use color for clarity
plt.xlabel("Hours")
plt.ylabel("Score")
plt.title("Linear Regression")
plt.show()
