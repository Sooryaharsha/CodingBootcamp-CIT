#include <stdio.h>
int main()
{
    long long num;
	int result,length;
 
    printf("Enter the number: ");
    scanf("%lli", &num);
    length=countDigit(num);
    printf("\n\nNo. of digits = %d",length);
    if (length>=6)
    {
    	 result = sum(num);
        printf("\n\nSum of the digits of %lli is %d\n", num, result);
	}
	else
	  printf("\n\nEnter a 6 digit number !!! ");
   
    return 0;
}
int countDigit(long long num)
{
    if (num/10 == 0)
        return 1;
    return 1 + countDigit(num / 10);
}
int sum (long long num)
{ 

    if (num == 0)
        return 0;
    return (num % 10 + sum (num / 10));


}
