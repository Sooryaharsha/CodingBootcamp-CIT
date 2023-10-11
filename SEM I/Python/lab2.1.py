def check(string1,string2):
    if(sorted(string1)==sorted(string2)):
        print("The given strings are anagrams")
    else:
        print("The given strings are not anagrams")
string1 = input("Enter the string one values : ")
string2 = input("Enter the string two values : ")
check(string1,string2)