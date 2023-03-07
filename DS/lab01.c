#include<stdio.h>
 #include<conio.h>
 struct details{
 char name[30],user_type[15],perm_add[30],temp_add[30],state[15],designation[15],driving_lic_no[10];
 int telephne_no,pincode;
 unsigned long long aadhar_no;
 }d;
 int main()
{
 printf("\n\n\n------------------------USER INPUT----------------------");
 printf("\n\nEnter your name: ");
 scanf("%s",&d.name);
 printf("Enter user type: ");
 scanf("%s",&d.user_type);
 printf("Enter your permanent address: ");
 scanf("%s",&d.perm_add);
 printf("Enter temporary address: ");
 scanf("%s",&d.temp_add);
 printf("Enter the pincode: ");
 scanf("%d",&d.pincode);
 printf("Enter your state: ");
 scanf("%s",&d.state);
 printf("Enter your telephone number: ");
 scanf("%d",&d.telephne_no);
 printf("Enter your Aadhaar number: ");
 scanf("%llu",&d.aadhar_no);
 printf("Enter your driving license number: ");
 scanf("%s",&d.driving_lic_no);
 printf("Enter your designation: ");
 scanf("%s",&d.designation);

 printf("\n\n\n------------------------USER PROFILE----------------------");
 printf("\n\nName: %s",d.name);
 printf("\nUser type: %s",d.user_type);
 printf("\nPermanent address: %s",d.perm_add);
 printf("\nTemporary address: %s",d.temp_add);
 printf("\nPincode: %d",d.pincode);
 printf("\nState: %s",d.state);
 printf("\nTelephone number: %d",d.telephne_no);
 printf("\nAadhaar number: %llu",d.aadhar_no);
 printf("\nDriving License: %s",d.driving_lic_no);
 printf("\nDesignation: %s",d.designation);
  }
