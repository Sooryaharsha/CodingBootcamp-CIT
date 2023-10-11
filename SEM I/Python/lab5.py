List1 = [12, 15, 32, 42, 55, 75, 122, 132, 150,400, 180, 200]
print("To print the numbers below 200 which are divisible by  4 from the given array")
for i in range(0, len(List1), 1):
 if List1[i]<=200:
  if List1[i]%4==0:
    print(List1[i])