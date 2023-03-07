import os
poem=open(r"C:\Users\Soorya harsha\AppData\Local\Microsoft\WindowsApps\poem.txt","r")

#To read 1st four lines
print("First four lines: ")
for i in range(4):
        print(poem.readline(),end="")
        
#To count no. of lines
c=0
for i in poem:
    c+=1
print("\nThe number of lines: ",c)

#File size
#using file object(seek)
poem.seek(0,os.SEEK_END)
print("\nFILE SIZE: ",poem.tell())

#Find longest word
poem.seek(0)
wordlist=poem.read().split()
print(wordlist)
maxlength=len(max(wordlist,key=len))
result=[words for words in wordlist if len(words)==maxlength]
print("\nLongest Words: ",result)

#Find occurance of a word
poem.seek(0)
c=0
word=input("\nEnter word: ")
for item in wordlist:
    if item==word:
        c+=1
print("\nOccurance of word",word,"is :",c)

#copy contents to another file
file=open("new.txt",'w+')
file.writelines(poem)
print("\nCopied to another file successfully\n")
file.seek(0)
print(file.read())
file.close()
poem.close()
        
            

