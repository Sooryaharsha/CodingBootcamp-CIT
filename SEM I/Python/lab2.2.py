def swap(string):
    start = string[0]
    end = string[-1]
    newstring = end + string[1:-1] + start
    print(newstring)
string = input("Enter the string : ")
swap(string)