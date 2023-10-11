import java.util.*;

class electricityBill
{
    private String customerName;
    private  static int customerId=0;
    protected int lastMonthReading , currentMonthReading,totUnits;
    protected double totCost;
    

    electricityBill(String customerName)
    {
        this.customerName  = customerName;
        customerId ++;
    }
    void displayBill()
    {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Customer Name \t Customer Id\t Consumed Units \t Bill Amount");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(customerName+"\t\t\t"+customerId+"\t\t"+totUnits+" \t\t"+totCost);
        System.out.println("------------------------------------------------------------------------");
    }
    
}

class domesticConsuption extends electricityBill
{
    double costPerUnit = 2.5;
    domesticConsuption(String customerName, int lastMonthReading, int currentMonthReading)
    {
        super(customerName);
        this.lastMonthReading = lastMonthReading;
        this.currentMonthReading = currentMonthReading;
    }

    void calcBill()
    {
        if(currentMonthReading < lastMonthReading)
        {
            throw new NumberFormatException("Current month reading cannot be less than last month reading");
        }
        totUnits = currentMonthReading - lastMonthReading ;
        totCost = totUnits * costPerUnit;
        displayBill();
    }
}

class commercialConsuption extends electricityBill
{
    double costPerUnit = 4.5;
    commercialConsuption(String customerName, int lastMonthReading, int currentMonthReading)
    {
        super(customerName);
        this.lastMonthReading = lastMonthReading;
        this.currentMonthReading = currentMonthReading;
    }

    void calcBill() throws NumberFormatException
    {
        if(currentMonthReading < lastMonthReading)
        {
            throw new NumberFormatException("Current month reading cannot be less than last month reading");
        }
        totUnits = currentMonthReading - lastMonthReading ;
        totCost = totUnits * costPerUnit;
        displayBill();
    }
}



public class Cat02 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the no. of Domestic Bills : ");
        int noOfDomestics = input.nextInt();

        System.out.print("Enter the no. of Commercial Bills : ");
        int noOfCommercial = input.nextInt();

        domesticConsuption dc[]= new domesticConsuption[noOfDomestics]; 
        commercialConsuption cc[] = new commercialConsuption[noOfCommercial];
        
        for(int i=0;i<noOfDomestics;i++)
        {
            dc[i] = new domesticConsuption(getName(),getLastReading(),getCurrentReading()); 
            dc[i].calcBill();
           
        }

        for(int i=0;i<noOfCommercial;i++)
        {
            cc[i] = new commercialConsuption(getName(),getLastReading(),getCurrentReading()); 
            cc[i].calcBill();
           
        }
    }
    

     static String getName ()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Customer Name : ");
        String name = input.nextLine();
        return name;
    }

    static int getLastReading () throws NumberFormatException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Last Month Reading  : ");
        int lastReading = input.nextInt();
        return lastReading;
    }
    
    static int getCurrentReading()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Current Month Reading : ");
        int currentReading =input.nextInt();
        return currentReading;
    }

    
}
