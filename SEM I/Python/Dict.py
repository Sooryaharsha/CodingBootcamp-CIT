dic={1:"Priscilla",
     2:"Shankar",
     3:"Gowsika",
     0:"keerthana",
     5:"junior"
     }
print(dic)
#TO SORT DICT BASED ON KEYS
for i in sorted(dic.keys()):
    print(i)

#OP:
0
1
2
3
5

'''for i in sorted(dic):
        print((i, dic[i]), end=" ")
#OP
(0, 'keerthana') (1, 'Priscilla') (2, 'Sidharth') (3, 'Gowsika') (5, 'Senior') 
'''

#SORT DICTIONARIES BASED ON VALUES
print(sorted(dic.items(), key=lambda kv:
                 (kv[1], kv[0])))