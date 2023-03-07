r= [(6, 24, 12), (60, 12, 6, -300), (12, -18, 21)]
K = 6
res = [x for x in r if all(ele % K == 0 for ele in x)]
print("tuples which All the  elements divisible by 6 are : " + str(res))
res = [x for x in r if all(ele >0 for ele in x)]
print("tuples which All the  elements are positive : " + str(res))
def Sort_Tuple(r):
    r.sort(key=lambda x: x[-1])
    return r
print("sort a list of tuples in increasing order by the last element in each tuple are :" ,Sort_Tuple(r))
digitSortedTuple = sorted(r, key = lambda r : sum([len(str(vals)) for vals in r ]))
print("Sorted Tuple list : " + str(digitSortedTuple))