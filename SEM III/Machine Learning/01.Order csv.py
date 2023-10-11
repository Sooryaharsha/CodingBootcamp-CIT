import pandas as pd

# Read the CSV data into a Pandas DataFrame
df = pd.read_csv("D:\College\SEM III\Machine Learning\order.csv")
print(df)


# Detect missing values and replace NaNs with median or mean of the specified columns
def replace_nans(df, column, method="median"):
    if method == "median":
        df[column].fillna(df[column].median(), inplace=True)
    elif method == "mean":
        df[column].fillna(df[column].mean(), inplace=True)
    else:
        raise ValueError("Invalid method specified.")


# Replace NaNs in the "Quantity" and "Sales" columns with the median
replace_nans(df, "Quantity")
replace_nans(df, "Sales", method="mean")
print(df)
# Find the sum, mean, max, min value of Sales
print("Sum of Sales:", df["Sales"].sum())
print("Mean of Sales:", df["Sales"].mean())
print("Max of Sales:", df["Sales"].max())
print("Min of Sales:", df["Sales"].min())

# Display the first five rows
print(df.head())

# Find the number of orders having quantity more than 95
print(
    "Number of orders having quantity more than 95:", df[df["Quantity"] > 95].shape[0]
)

