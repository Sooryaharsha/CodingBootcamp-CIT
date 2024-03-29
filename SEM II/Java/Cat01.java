
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
    

    VehicleLoan(String name,String address,int cifNo,int yearlyIncome,int principal,int yearOfRepayments) throws ArithmeticException 
    {
        super(name,address,cifNo,yearlyIncome,principal,yearOfRepayments);
        if(yearOfRepayments<currentYear)
        {
            throw new ArithmeticException("Repayment year cannot be less than currentYear");
        }
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
    

    HouseLoan(String name,String address,int cifNo,int yearlyIncome,int principal,int yearOfRepayments) throws ArithmeticException
    {
        super(name,address,cifNo,yearlyIncome,principal,yearOfRepayments);
        if(yearOfRepayments<currentYear)
        {
            throw new ArithmeticException("Repayment year cannot be less than currentYear");
        }
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

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the No of Vehicle Loans : ");
        int y = input.nextInt();

        VehicleLoan v[] = new VehicleLoan[y];

        for(int i=0;i<y;i++){

            System.out.println("Details for Vehicle Loan \n");
            v[i] = new VehicleLoan(getName(),getAddress(),getCifNo(),getYearlyIncome(),getLoanAmount(),getRepaymentyear());
            v[i].calcEMI();

            System.out.println("-------------------------------------------------------------");
            System.out.println("Vehicle Loan Details ");
            System.out.println("-------------------------------------------------------------");
            v[i].display();
            System.out.println("-------------------------------------------------------------");
            System.out.println();
            
        }
        
        int x;
        System.out.print("\nEnter the No of house Loans : ");
        x= input.nextInt();
        HouseLoan h[] = new HouseLoan[x];

        for(int i=0; i<x; i++)
        {
            System.out.println("Details for House Loan \n");
            h[i] = new HouseLoan(getName(),getAddress(),getCifNo(),getYearlyIncome(),getLoanAmount(),getRepaymentyear());
            h[i].calcEMI();

            System.out.println("\n-------------------------------------------------------------");
            System.out.println("House Loan Details ");
            System.out.println("-------------------------------------------------------------");
            h[i].display();
            System.out.println("-------------------------------------------------------------\n");
    }
}
    static String getName()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name : ");
        String name = input.nextLine();
        return name;
    }

    static String getAddress()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Address : ");
        String address = input.nextLine();
        return address;
    }

    static int getCifNo()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the CIF no : ");
        int cifNo = input.nextInt();
        return cifNo;
    }

    static int getYearlyIncome()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Yearly income : ");
        int yearlyIncome = input.nextInt();
        return yearlyIncome;
    }

    static int getLoanAmount()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Required Loan amount : ");
        int loanAmount = input.nextInt();
        return loanAmount;
    }

    static int getRepaymentyear()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Repayment Year : ");
        int repaymentYear = input.nextInt();
        return repaymentYear;
    }
}