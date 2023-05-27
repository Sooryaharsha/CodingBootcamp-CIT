import java.time.*;
import java.util.*;
class Author
{
    String authorName;
    Boolean issued;
    Boolean passedDueDate;
    int noOfDaysLeft,noOfDaysPassedDue,fineAmount,usedDays;
    final int maxIssueDays =30;
    final int fineAmountPerDay =5;

    Author()
    {

    }

    Author(String authorName,Boolean issued)
    {
        this.authorName = authorName;
        this.issued = issued;
    
    }

    void checkOut()
    {
        if(issued)
        {
            System.out.println("Sorry the requied resource is Not available");
        }
        else{
              System.out.println("Available for Checkout");
        }
    }

    void checkDelay()
    {
            if(usedDays >30)
            {
                noOfDaysPassedDue = usedDays - maxIssueDays;
                fineAmount = fineAmountPerDay * noOfDaysPassedDue;
                System.out.println("You have passed the due date by "+ noOfDaysPassedDue +" days you are requested 
                to return the book with the fine amount of ₹"+fineAmount+", Thank You! ");
            }
            else
            {
                noOfDaysLeft = maxIssueDays - usedDays;
                System.out.println("You have not passed the due date , you're still "+noOfDaysLeft+" beyond due date");
                
            }
    }

    void checkIn(int usedDays)
    {
        this.usedDays = usedDays;
        checkDelay();
    }

    void displayStatus()
    {

    }

}

class Books extends Author
{
    String bookName,authorName;

    Books()
    {
        checkOut();
    }

    Books(String bookName, String authorName,Boolean issued)
    {
        super(authorName,issued);
        this.bookName = bookName;
    }

}

class Journals extends Author
{
    String journalName,authorName;
    Journals(String journalName, String authorName)
    {
        super(authorName,issued);
        this.journalName = journalName;
    }
}


class eResources extends Author
{
    String eResourseName,authorName;
    eResources(String eResourseName, String authorName)
    {
        super(authorName);
        this.eResourseName = eResourseName;
    }
}

public class Cat3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int checkOut=0;

        Books b1 = new Books("Song of Ice and Fire","George RR Martin",false);
        Journals j1 = new Journals("Internet of Things","Jonas Smith");
        eResources e1 = new eResources("Neuro Computing","Martha Adams");

        System.out.println("\t\t\t \t\t WELCOME TO LIBRARY MANAGEMENT FRAMEWORK ");

        System.out.print("Resource Checking In or Checking out ? (1/2) : ");
        int choice = input.nextInt();

        if(choice == 1)
        {
            System.out.print("What you are Looking for  : 1.Books 2.Journals 3.eResources ? : ");
            checkOut = input.nextInt();
        }
        else
        {
            System.out.print("What you are Returning : 1.Books 2.Journals 3.eResources ? : ");
            choice = input.nextInt();
        }
        
        switch(choice){

            case 1:
            {
                switch(checkOut){
                    case 1:
                    {
                        String bookTitle = getTitle();
                        if(bookTitle.equals("Song of Ice and Fire")) 
                            b1.checkOut();
                        else b2.checkOut();

                        
                    }
                }
                
            }


        }
    }

    static String getTitle()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Title : ");
        String title = input.next();
        return title;
    }

    static int usedDays()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("No of days Used : ");
        int days = input.nextInt();
        return days;
    }
    
}
