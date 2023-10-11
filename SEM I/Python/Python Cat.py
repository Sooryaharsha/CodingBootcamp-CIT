string = "The quick brown fox jumps over the lazy dog"

#given string in upper case
print("\n\n1.UPPER CASE\n")
print("String : ",string)
print("string in Upper case : ",string.upper())


#removing blank spaces
string2=''
print("\n\nREMOVE BLANK SPACES\n")
for i in string:
    if (i != ' '):
        string2=string2+i
print(string2)

#occurance of O
print("\n\nOCCURANCE OF O\n")
count =0
for i in string:
    if(i== 'o'):
        count+=1
print("The number of occurance of the character o is : ",count)


#Print out brown
print("\n\nTO PRINT BROWN \n")
list=[]
list=string.split(" ")
print(list)
for i in list:
    if(i=='brown'):
        print(i)

#Jumps to end
print("\n\n TO PRINT FROM JUMP TO END\n")
a= string.find('jumps')
print(string[a:])

#string reverse
("\n\nTO PRINT STRING REVERSE\n")
i=len(string)-1
print(i)
while i>=0:
    x=string[i]
    print(x)
    i=i-1
    

