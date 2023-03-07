a=[]
r = int(input('Enter the no of rows : '))
c=int(input('Enter the no of columns : '))


def get_input():
    for i in range(0,r):
        a.append([])
        for j in range(0,c):
             a[i].append(int(input('Enter the list value : ' )))
    print(a)

def display():
    for i in range(0,r):
        for j in range(0,c):
            print(a[i][j],end=" ")
        print()
get_input()
display()