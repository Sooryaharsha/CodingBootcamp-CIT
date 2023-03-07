import pandas as pd
import datetime
file=pd.read_excel('D:\CIT\Python\Book1.xlsx')
print("\n\t\tPrinting firstname alone\n")
print(pd.DataFrame(file,columns=['firstname'],))

df2=file.set_index(['hiredate'])
result = df2.loc["2006"]
print("\nData of emplyees joined in 2006:\n")
print(result)
date=datetime.datetime(2007,1,1)
print("\nList of employees where hiredate greater than 01-01-2007:\n")
i=[]
for index,row in file.iterrows():
    if(row['hiredate']>date):
        i.append(index)  
              
print(file.loc[i])        
print("\nSort the records by hiredate:\n")
result=file.sort_values('hiredate')
print(result)
print("\nList of employees where hiredate between 01-01-2005 to 01-01-2007:\n")
date1=datetime.datetime(2005,1,1)
date2=datetime.datetime(2007,1,1)
i=[]
for index,row in file.iterrows():
    if(row['hiredate']>=date1 and row['hiredate']<=date2):
        i.append(index)        
print(file.loc[i])




        
    
