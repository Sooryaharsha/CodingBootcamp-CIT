def length(string):
    count=0
    for i in string:
        if i !=' ':
            count = count+1
    print("No of Character in a string =  ",count)

string= input("Enter the string : " )
length(string)
y=string.split(" ")
print(y)
print("No of words in a string = ",len(y))

