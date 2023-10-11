#list of dictionaries

d=[{'name':'Todd','phone':'555-1414','email':'todd@mail.net'},{'name':'Helga','phone':'555-1618','email':'helga@mail.net'},{'name':'Princess','phone':'555-3141','email':''},{'name':'LJ','phone':'555-2718','email':'lj@mail.net'}]

#Display all the users whose phone no. ends in 8

for i in range(0,len(d),1):
   phn= d[i]['phone']
   print(phn)
   last_digit=repr(phn)[-2]
   print(last_digit)
   if(last_digit=='8'):
       print(d[i])
       
       
#Display all the users who dont have an email address listed

for i in range (0,len(d),1):
    if d[i]['email']=='':
        print(d[i])
        
        
n = 162329
last_digit = int(repr(n)[-1])
print(f"The last digit of {n} is {last_digit}")