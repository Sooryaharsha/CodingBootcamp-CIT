import java.util.*;
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
        System.out.print(ename+"\t\t\t"+ id+"\t\t\t");
    }





    
}

class Salary extends Employee{

    double basicPay,grossPay; 

    Salary(String name , int id, double basicPay){
        super(name, id);
        this.basicPay = basicPay;

    }

    void calc_sal(){

        double ta = 0.03*basicPay;
        double hra = 0.05*basicPay;
         grossPay = basicPay + ta + hra;
        //System.out.println("The Gross Salary is : "+grossPay); 
    }

    void pay_slip()
    {
        super.display_name();
        System.out.print(basicPay+"\t\t\t"+grossPay+"\t\t\t");
    }

}

class Wage extends Employee{

    int noOfDays,totSalary ;
    int salPerDay = 300;

    Wage(String name, int id, int noOfDays)
    {
        super(name,id);
        this.noOfDays = noOfDays;
    }

    void calc_wage()
    {
        totSalary = noOfDays * salPerDay;
    }

    void pay_slip()
    {
        super.display_name();
        System.out.print(noOfDays+"\t\t\t"+totSalary+"\t\t\t");
    }
}


public class Lab09
{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int salEmp,wageEmp,id,noOfDays;
        double  basicpay;
        String name;
        System.out.print("Enter the no of Salary Employees : ");
        salEmp = input.nextInt();
        System.out.print("Enter the no of Waged Employees : ");
        wageEmp = input.nextInt();

        Salary sal[] = new Salary[salEmp];
        Wage w[]= new Wage[wageEmp];

        for(int i=0;i<salEmp;i++)
        {
            
            System.out.print("Employee name : ");
            name = input.next();
            System.out.print("Employee ID : ");
            id = input.nextInt();
            System.out.print("Basic Pay : ");
            basicpay =input.nextInt();
            sal[i] = new Salary(name, id,basicpay);
            sal[i].calc_sal();
            sal[i].pay_slip();
        }

        for(int j=0;j<wageEmp; j++){
           
            System.out.print("Employee name : ");
            name = input.next();
            System.out.print("Employee ID : ");
            id = input.nextInt();
            System.out.print("Working days : ");
            noOfDays = input.nextInt();
            w[j] = new Wage(name,id,noOfDays);
            w[j].calc_wage();
        }

        
    }
}

