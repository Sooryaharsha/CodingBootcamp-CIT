dic={1:[1,2],
     2:[3,4],
     3:[5,4],
     0:[4,5],
     5:[2,6]
     }

#items() keyword
for i,j in dic.items():
    count=0
    for k in j:
        count=count+k
    print("key:",i,"TOTAL:",count)