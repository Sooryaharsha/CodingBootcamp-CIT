def factorial(x):
    if x==1:
        return 1
    else:
        return x*factorial(x-1)
        
def binomialco(n,k):
    if(k<=n):
        a= factorial(n)/(factorial(k)*factorial(n-k))
        return a
    else:
        print("Enter a vaild input")
    
n=int(input("Enter the  n value :"))
k=int(input("Enter the  k value :"))
print("The given binomial equation is ",n,"C",k)
print("The binomial coefficent is : ",binomialco(n,k))





    
