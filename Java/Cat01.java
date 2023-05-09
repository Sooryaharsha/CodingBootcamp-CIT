import java.lang.*;
import java.util.*;
class Loan{
    private String name,address;
    private int cifNo,yearlyIncome;
    int noOfInstallments,principal,yearOfRepayments;
    double emiAmount,totalInterest,totalRepayment,interestRate;
    int currentYear=2023,noOfYears ;

    Loan(String name,String address,int cifNo,int yearlyIncome,int principal,int yearOfRepayments)
    {
        this.name = name;
        this.address = address;
        this.cifNo = cifNo;
        this.yearOfRepayments = yearOfRepayments;
        this.principal = principal;
        this.yearlyIncome = yearlyIncome;
    }
    void display()
    {
        System.out.println("\nCustomer Name : "+name+"\nLoan Amount : "+principal+"\nLoan Period : "+noOfYears+" years"+"\nInterest Rate : "+interestRate+
        "\nNo of Installments : "+noOfInstallments+"\nTotal Interest Amount : "+totalInterest+
        "\nTotal Repayment Amount : "+totalRepayment+"\nMonthly Emi :"+emiAmount);
    }
}

class VehicleLoan extends Loan{
    

    VehicleLoan(String name,String address,int cifNo,int yearlyIncome,int principal,int yearOfRepayments)
    {
        super(name,address,cifNo,yearlyIncome,principal,yearOfRepayments);
        noOfYears =  yearOfRepayments-currentYear;
        interestRate = noOfYears <= 10 ? 13 : 11;
    }

    void calcEMI()
    {
        try{
            totalInterest = principal*interestRate*noOfYears/100 ;
            totalRepayment  =principal + totalInterest;
            noOfInstallments = noOfYears *12;
            emiAmount =    totalRepayment/noOfInstallments;
        }
        catch(ArithmeticException e)
        {
            e.printStackTrace();
            System.out.println("The Customer Closes his loan in a same Single Year");
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
            System.out.println("Enter the Integer value");
        }
        
    }

    void display()
    {
        super.display();
    }
}

class HouseLoan extends Loan{
    

    HouseLoan(String name,String address,int cifNo,int yearlyIncome,int principal,int yearOfRepayments)
    {
        super(name,address,cifNo,yearlyIncome,principal,yearOfRepayments);
        noOfYears =  yearOfRepayments-currentYear;
        interestRate = noOfYears <= 10 ? 9 : 7;
    }

    void calcEMI()
    {
        try
    {
        totalInterest = principal*interestRate*noOfYears/100 ;
        totalRepayment  =principal + totalInterest;
        noOfInstallments = noOfYears *12;
        emiAmount =    totalRepayment/noOfInstallments;
    }catch(ArithmeticException e)
    {
        e.printStackTrace();
        System.out.println("The Customer Closes his loan in a same Single Year");
    }
    catch(NumberFormatException e)
    {
        e.printStackTrace();
        System.out.println("Enter the Integer value");
    }
    }

    void display()
    {
        super.display();
    }
}

public class Cat01{
    public static void main(String[] args) {

        String name,address;
        int cifNo,yearlyIncome,loanAmount,repaymentYear;

        Scanner input = new Scanner(System.in);

        System.out.println("Details for Vehicle Loan \n");
        System.out.print("Enter the name : ");
        name = input.nextLine();
        System.out.print("Enter the Address : ");
        address = input.nextLine();
        System.out.print("Enter the CIF no : ");
        cifNo = input.nextInt();
        System.out.print("Enter the Yearly income : ");
        yearlyIncome = input.nextInt();
        System.out.print("Enter the Required Loan amount : ");
        loanAmount = input.nextInt();
        System.out.print("Enter the Repayment Year : ");
        repaymentYear = input.nextInt();


        System.out.println("-------------------------------------------------------------");
        System.out.println("Vehicle Loan Details ");
        System.out.println("-------------------------------------------------------------");

        VehicleLoan v1 = new VehicleLoan(name,address,cifNo,yearlyIncome,loanAmount,repaymentYear);
        v1.calcEMI();
        v1.display();
        System.out.println("-------------------------------------------------------------");
        System.out.println();

        

        int x;
        System.out.print("\nEnter the No of house Loans : ");
        x= input.nextInt();
        HouseLoan h[] = new HouseLoan[x];

        for(int i=0; i<x; i++)
        {
            System.out.println("Details for House Loan \n");
            System.out.print("Enter the name : ");
            name = input.next();
            System.out.print("Enter the Address : ");
            address = input.next();
            System.out.print("Enter the CIF no : ");
            cifNo = input.nextInt();
            System.out.print("Enter the Yearly income : ");
            yearlyIncome = input.nextInt();
            System.out.print("Enter the Required Loan amount : ");
            loanAmount = input.nextInt();
            System.out.print("Enter the Repayment Year : ");
            repaymentYear = input.nextInt();


            System.out.println("\n-------------------------------------------------------------");
            System.out.println("House Loan Details ");
            System.out.println("-------------------------------------------------------------");

            h[i] = new HouseLoan(name,address,cifNo,yearlyIncome,loanAmount,repaymentYear);
            h[i].calcEMI();
            h[i].display();
            System.out.println("-------------------------------------------------------------\n");
            
    }
}
}