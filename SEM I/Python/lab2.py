p=int(input("Enter the Principle amount :"))
r=int(input("Enter the Rate of Interest :"))
n=int(input("Enter the no. of years : "))
si=(p*n*r)/100
ci=p*((((1+(r/100))**(n))-1))
print("Simple Interest : ",si)
print("Compound Interest ; ",ci)