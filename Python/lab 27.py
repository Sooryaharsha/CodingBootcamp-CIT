import numpy as soorya 
a = soorya.matrix('1 2 3 4 5 ; 9 4 1 6 4 ; 8 32 1 5 3 ; 5 32 12 1 3 ; 7 64 43 2 1')
print("The values of matrix a are : ")
print(a)

print("Subracting 2 from matrix elements")
for i in a:
    i = i-2
    print(i)
