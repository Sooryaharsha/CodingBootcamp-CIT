

lower = 100
upper = 400
print("Armstrong Number within the range 100 to 400 : ")
for num in range(lower, upper + 1):
   length = len(str(num))
   sum = 0
   temp = num
   while temp > 0:
       digit = temp % 10
       sum += digit ** length
       temp //= 10
   if num == sum:
       print(num)