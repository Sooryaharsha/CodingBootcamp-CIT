def getsum(n):
    sum =0
    for digit in str(n):
      sum+=int(digit)
    return sum
print("---------TO FIND THE SUM OF THE DIGITS---------")
n=int(input("Enter the numbers to find sum : "))
print(getsum(n))
def num(n):
    count =0
    while(n>0):
      count=count+1
      n=n//10
    print("The no. of digits in the number are : ",count)
print("---------TO COUNT THE NUMBER OF THE DIGITS---------")
n = int(input("Enter the no. to count the number of digits : "))
num(n)    
def ispalindrome(n):
    temp=n
    rev=0
    while(n>0):
        dig=n%10
        rev=rev*10+dig
        n=n//10
    if(temp==rev):
        print("The number is a palindrome ")
    else:
        print("The number isn't a palindrome ")
print("---------TO CHECK WHEATHER THE GIVEN NUMBER IS PALINDROME OR NOT ---------")
n=int(input("Enter the number : "))
ispalindrome(n)
    
