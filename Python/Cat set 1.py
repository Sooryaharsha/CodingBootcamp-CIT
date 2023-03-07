#Python cat exam list of tuples

list=[('25 july 2022','25 july 2022','25 july 2022','25 july 2022',),('43.50','42.80','42.10','37.58'),('25','50','75','100'),('CAT','DD','EK','GM'),('92.45','51.19','34.87','37.58')]

#EXAMINE EACH BLOCK,MULTIPLY SHARES BY PURCHASE PRICE AND DETERMINE THE TOTAL PURCHASE PRICE OF THE PORTFOLIO

while(j<len)

list_mul=[]
for i in range (1,2,1):
    print(list[i])
    for j in range(0,4,1):
        print(list[i][j])
        list_mul.append(list[i][j]*list[i][j+1])
        print(list_mul)