def removeodd(string):
    result = ''
    for i in (len(string)):
        if i%2==0:
          result=result+string[i]
    print("After removing odd index characters : ")
    print(result)
string = 'sooryaharsha'
print("Before removing odd index characters : ")
print(string)
removeodd(string)