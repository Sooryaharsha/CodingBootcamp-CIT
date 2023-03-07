#include<stdio.h>
int cal(int a[],int opt)
{
  int max,min,num,i;
 if(opt==1)
 {
     max=a[0];
     for( i=1;i<5;i++)
     {
         if (max < a[i])
          {
          max =a[i];
          }
     }
     return (max);
 }
 else if (opt==2)
    {
     min=a[0];
     for(i=1;i<5;i++)
     {
         if (min > a[i])
          {
          min =a[i];
          }
     }
     return (min);
 }
else if (opt==3)
{
    printf("enter the number to find it's location: ");
    scanf("%d",&num);
    for( i=0;i<5;i++)
    {
        if (a[i] == num)
        {
            return(i+1);
            
        }
    }
}
}

void main()
{
    int a[5],i,opt;
    int result = 0;
    printf("Enter the Array elements : ");
    for(i=0;i<5;i++)
    {
    scanf("%d",&a[i]);
    }

    printf("1.to find maximum number\n");
    printf("2.to find minimum number\n");
    printf("3.to find the location of a value\n");
    printf("Enter your option: ");
    scanf("%d",&opt);

   result = cal(a,opt);
   printf("The returned value is : %d",result);

}

