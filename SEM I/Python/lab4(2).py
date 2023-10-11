def num(n):
    count=0
    while(n>0):
      count=count+1
      n=n//10
    print("The no. of digits in the number are : ",count)
n = int(input("Enter the no. : "))
num(n)    
    