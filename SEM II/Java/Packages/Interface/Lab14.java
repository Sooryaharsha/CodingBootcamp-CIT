package Java.Packages.Interface;
import java.util.*;

public class Lab14{

    public static void main(String[] args) {
 
        System.out.println("\n\n\t\t\t\t ELECTRICITY BILL APPLICATION USING INTERFACE");
        Scanner input = new Scanner(System.in);
        System.out.print("No of Bills : ");
        int noOfBills = input.nextInt();

        ElectricityBill eb[] = new ElectricityBill[noOfBills];

        for(int i = 0; i < noOfBills; i++)
        {
            eb[i] = new ElectricityBill(getName(),getLastMonthReading(),getCurrentMonthReading(),getUserType());
            eb[i].findTotalUnit();
            eb[i].findTotalAmount();
            eb[i].printBill();
        }
        
    }
    
    static String getName()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Customer Name : ");
        String name = input.nextLine();
        return name;
    }

    static Double getLastMonthReading()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Last month reading : ");
        Double x = input.nextDouble();
        return x;
    }

    static  Double getCurrentMonthReading()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Current month reading : ");
        Double x = input.nextDouble();
        return x;
    }

    static String getUserType()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Customer Type : ");
        String type = input.nextLine();
        return type;
    }
}
