import java.util.Scanner;
class Employee{

    private String ename;
    private int id;

    Employee(String ename, int id)
    {
        this.ename = ename;
        this.id = id;
    }

    void display_name()
    {
        System.out.print("Employee Name : "+ename+"\nEmployee Id : "+ id+"\n");
    }
}

class Salary extends Employee{

    double basicPay,grossPay,ded,netPay; 
    
    
    Salary(String name , int id, double basicPay){
        super(name, id);
        this.basicPay = basicPay;

    }

    void calc_sal(){

        double ta = 0.03*basicPay;
        double hra = 0.05*basicPay;
        double da = 0.02*basicPay;
        double  pf = 0.05*basicPay;
        double it = 0.03*basicPay;

         grossPay = basicPay + ta + hra + da;
         ded = pf+it;
         netPay = grossPay - ded;
    }

    void pay_slip()
    {
        super.display_name();
        System.out.print("Basic Pay : "+basicPay+"\nDeduction : "+ded+"\nGross Pay : "+grossPay+"\nNet Pay : "+netPay);
    }

}

class Wage extends Employee{

    int noOfHours,totSalary ;
    int wagePerHour = 120;

    Wage(String name, int id, int noOfHours)
    {
        super(name,id);
        this.noOfHours = noOfHours;
    }

    void calc_wage()
    {
        totSalary = noOfHours * wagePerHour;
    }

    void pay_slip()
    {
        super.display_name();
        System.out.println("No of Working hours : "+noOfHours+"\nWages Per hour : "+wagePerHour+"\nNet Pay : "+totSalary+"\n");
    }
}


public class Lab09
{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int noOfSalEmp,noOfwageEmp,id,noOfHours;
        double  basicpay;
        String name;
        System.out.print("Enter the no of Salary Employees : ");
        noOfSalEmp = input.nextInt();
        System.out.print("Enter the no of Waged Employees : ");
        noOfwageEmp = input.nextInt();

        Salary sal[] = new Salary[noOfSalEmp];
        Wage w[]= new Wage[noOfwageEmp];

        //Salary Employee

        for(int i=0;i<noOfSalEmp;i++)
        { 
            System.out.print("\nEmployee name : ");
            name = input.next();
            System.out.print("Employee ID : ");
            id = input.nextInt();
            System.out.print("Basic Pay : ");
            basicpay =input.nextInt();
            sal[i] = new Salary(name, id,basicpay);
            sal[i].calc_sal();
            System.out.println("\n--------------------------------------------------------------");
            System.out.println("The Pay Slip of the Salary Employee "+name.toUpperCase());
            System.out.println("--------------------------------------------------------------");
            sal[i].pay_slip();
            System.out.println("\n--------------------------------------------------------------");
        }

        //Waged Employee

        for(int j=0;j<noOfwageEmp; j++){
           
            System.out.print("\nEmployee name : ");
            name = input.next();
            System.out.print("Employee ID : ");
            id = input.nextInt();
            System.out.print("Working hours : ");
            noOfHours = input.nextInt();
            w[j] = new Wage(name,id,noOfHours);
            w[j].calc_wage();
            System.out.println("\n--------------------------------------------------------------");
            System.out.println("The Pay Slip of the Daily Wage Employee "+name.toUpperCase());
            System.out.println("--------------------------------------------------------------");
            w[j].pay_slip();
            System.out.println("--------------------------------------------------------------");
        }

    }
}

