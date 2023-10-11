import pandas as pd
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

df = pd.read_csv("D:\College\SEM III\Machine Learning\emp.csv")
print(df.to_string())

# Visualizing the relationships
plt.figure(figsize=(12, 6))

plt.subplot(1, 2, 1)
plt.scatter(df["Interest_Rate"], df["Stock_Index_Price"], color="blue")
plt.title("Interest Rate vs Stock Index Price")
plt.xlabel("Interest Rate")
plt.ylabel("Stock Index Price")

plt.subplot(1, 2, 2)
plt.scatter(df["Unemployment_Rate"], df["Stock_Index_Price"], color="red")
plt.title("Unemployment Rate vs Stock Index Price")
plt.xlabel("Unemployment Rate")
plt.ylabel("Stock Index Price")

plt.tight_layout()
plt.show()

# Perform multiple linear regression
X = df[["Interest_Rate", "Unemployment_Rate"]]
y = df["Stock_Index_Price"]

model = LinearRegression()
model.fit(X, y)

# Predicting stock index price for specific values
interest_rate = 2.75
unemployment_rate = 5.3
predicted_price = model.predict([[interest_rate, unemployment_rate]])

print(f"STOCK PRICE: {predicted_price[0]:.2f}")

# Save the plot as Q3.png
plt.figure(figsize=(12, 6))
plt.scatter(
    df["Interest_Rate"], df["Stock_Index_Price"], color="blue", label="Interest Rate"
)
plt.scatter(
    df["Unemployment_Rate"],
    df["Stock_Index_Price"],
    color="red",
    label="Unemployment Rate",
)
plt.plot(df["Interest_Rate"], model.predict(X), color="green", label="Regression Line")
plt.plot(df["Unemployment_Rate"], model.predict(X), color="green")
plt.title("Multiple Linear Regression")
plt.xlabel("Interest Rate / Unemployment Rate")
plt.ylabel("Stock Index Price")
plt.legend()
plt.show()
