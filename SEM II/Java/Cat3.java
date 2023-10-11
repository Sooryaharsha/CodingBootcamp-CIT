import java.time.*;
import java.util.*;
class Author
{
    String authorName,resourceType,name;
    Boolean issued;
    Boolean passedDueDate,isDelayed;
    int noOfDaysLeft,noOfDaysPassedDue,fineAmount,usedDays;
    final int maxIssueDays =30;
    final int fineAmountPerDay =5;

    Scanner input = new Scanner(System.in);

    Author(String authorName,String name,Boolean issued,String resourceType)
    {
        this.authorName = authorName;
        this.issued = issued;
        this.name = name;
        this.resourceType = resourceType;
    
    }

    void checkStatus()
    {
        if(issued)
        {
            System.out.println("\n!!! Sorry the requied resource is Not available !!!");
        }
        else{
              System.out.print("\nAvailable for Checkout ... Proceed ? (0/1) : ");
              int choice = input.nextInt();
              if(choice == 1 ){
                issued = true;
                System.out.println("\nYou have successfully checked out the "+ resourceType.toUpperCase()+" ! ");
              }
              else{
                System.out.println("Happy to provide you the Sevice ");
              }
        }
        displayStatus();
    }

    void displayStatus()
    {
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("\nResource Type \t Resource Name \t\t Author Name \t\t IsIssued ");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println(resourceType.toUpperCase() +"\t\t"+name.toUpperCase()+"\t\t"+authorName.toUpperCase()+"\t\t"+issued);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
    }


    void checkIn(int usedDays)
    {
        this.issued = true;
        this.usedDays = usedDays;
        checkDelay();
    }

    void checkDelay()
    {
            if(usedDays >30)
            {
                isDelayed = true;
                noOfDaysPassedDue = usedDays - maxIssueDays;
                fineAmount = fineAmountPerDay * noOfDaysPassedDue;
                System.out.println("\nYou have passed the due date by "+ noOfDaysPassedDue +" days you are requested to return the "+resourceType+" with the fine amount of "+fineAmount+" Rupees, Thank You! ");
            }
            else
            {
                isDelayed = false;
                fineAmount = 0;
                noOfDaysLeft = maxIssueDays - usedDays;
                System.out.println("\nYou have not passed the due date , you're still "+noOfDaysLeft+" day beyond due date");
                
            }
            displayChechkInDetails();
    }



    void displayChechkInDetails()
    {
        System.out.println("\n\n---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nResource Type \t\t Resource Name \t\t Author Name\t\t IsIssued \t\t IsDelayed \t\t FineAmount");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(resourceType.toUpperCase() +"\t\t\t"+name.toUpperCase()+"\t\t\t"+authorName.toUpperCase()+"\t\t"+issued+"\t\t\t"+isDelayed+"\t\t\t"+fineAmount);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

}

class Books extends Author
{
    String bookName,authorName;


    Books(String bookName,String authorName,Boolean issued,String resourceType)
    {
        super(authorName,bookName,issued,resourceType);
        this.bookName = bookName;
    }

}

class Journals extends Author
{
    String journalName,authorName;
    Journals(String journalName, String authorName,Boolean issued,String resourceType)
    {
        super(authorName,journalName,issued,resourceType);
        this.journalName = journalName;
    }
}


class eResources extends Author
{
    String eResourceName,authorName;
    eResources(String eResourceName,String authorName,Boolean issued,String resourceType)
    {
        super(authorName,eResourceName,issued,resourceType);
        this.eResourceName = eResourceName;
    }
}

public class Cat3 {


    public static void main(String[] args) {

        
        Scanner input = new Scanner(System.in);
        int checkOut=0,checkIn=0,i=0,usedDays;

        Books b[] =new Books[5];

        b[1] =  new Books("Song of Ice and Fire","George RR Martin",false,"book");
        b[2] =  new Books("Harry Potter","J K Rowling",false,"book");
        b[3] =  new Books("The Vampier Diaries","L J Smith",false,"book");
        b[4] =  new Books("It Ends with us","Collen Hoover",false,"book");

        Journals j[]= new Journals[3];

         j[1] = new Journals("Internet of Things","Jonas Smith",true,"Journal");
         j[2] = new Journals("Javascript","Benard",false,"Journals");

         eResources e[] = new eResources[3];

        e[1]= new eResources("Neuro Computing","Martha Adams",false,"eResources");
        e[2] = new eResources("Nodejs","Ryan",false,"eResources");

        System.out.println("\n\n\t\t\t \t\t WELCOME TO LIBRARY MANAGEMENT FRAMEWORK ");

        System.out.print("\nResource Checking Out or Checking In ? (1/2) : ");
        int checkOutOrCheckIn = input.nextInt();

        if(checkOutOrCheckIn == 1)
        {
            System.out.print("What you are Looking for  : 1.Books 2.Journals 3.eResources ? : ");
            checkOut = input.nextInt();
        }
        else
        {
            System.out.print("What you are Returning : 1.Books 2.Journals 3.eResources ? : ");
            checkIn = input.nextInt();
        }
        
        switch(checkOutOrCheckIn){

            case 1:
            {
                switch(checkOut){
                    case 1:
                    {
                        String bookTitle = getTitle();
                        if(bookTitle.equals(b[1].bookName)) i=1;
                        else if(bookTitle.equals(b[2].bookName)) i=2;
                        else if(bookTitle.equals(b[3].bookName)) i=3;
                        else if(bookTitle.equals(b[4].bookName)) i=4;
                        else System.out.println("Enter the Valid Name !!!");

                        b[i].checkStatus();
                        break;
                        
                    }

                    case 2:
                    {
                        String journalTitle = getTitle();
                        if(journalTitle.equals(j[1].journalName)) i=1;
                        else if(journalTitle.equals(j[2].journalName)) i=2;
                        else System.out.println("Enter the Valid Name !!!");

                        j[i].checkStatus();
                        break;
                    }

                    case 3:
                    {
                        String eResourceTitle = getTitle();
                        if(eResourceTitle.equals(e[1].eResourceName)) i=1;
                        else if(eResourceTitle.equals(e[2].eResourceName)) i=2;
                        else System.out.println("Enter the Valid Name !!!");

                        e[i].checkStatus();
                        break;
                    }
                }
                
            }

            case 2 :
            {
                switch(checkIn){
                    case 1: 
                    {
                        String bookTitle = getTitle();
                        usedDays = getUsedDays();
                        if(bookTitle.equals(b[1].bookName))  i=1;
                        else if(bookTitle.equals(b[2].bookName)) i=2;
                        else if(bookTitle.equals(b[3].bookName)) i=3;
                        else if(bookTitle.equals(b[4].bookName)) i=4;

                        b[i].checkIn(usedDays);
                        break;
                    }
                    case 2:
                    {
                        String journalTitle = getTitle();
                        usedDays = getUsedDays();
                        if(journalTitle.equals(j[1].journalName)) i=1;
                        else if(journalTitle.equals(j[2].journalName)) i=2;
                        else System.out.println("Enter the Valid Name !!!");

                        j[i].checkIn(usedDays);
                        break;
                    }

                    case 3:
                    {
                        String eResourceTitle = getTitle();
                        usedDays = getUsedDays();
                        if(eResourceTitle.equals(e[1].eResourceName)) i=1;
                        else if(eResourceTitle.equals(e[2].eResourceName)) i=2;
                        else System.out.println("Enter the Valid Name !!!");

                        e[i].checkIn(usedDays);
                        break;
                    }
                }
            }


        }
    }

    static String getTitle()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Title : ");
        String title = input.nextLine();
        return title;
    }

    static int getUsedDays()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("No of days Used : ");
        int days = input.nextInt();
        return days;
    }
    
}
