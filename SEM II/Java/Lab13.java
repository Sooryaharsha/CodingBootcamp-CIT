import java.util.*;

class Products
{
    String productName;
    int totQuantity,totAmount;

    void salesBot(){
        
        System.out.println("Hi this is the Sales Bot !!!");
    }
    void display(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\nProduct Name \t\t Price \t\t Qty \t\t BillAmount" );
        System.out.println("---------------------------------------------------------------------");
        System.out.print(productName+"\t\t");
    }
}

class Groceries extends Products{

    int pricePerKg,totRequiredKgs;

    Groceries(String productName, int pricePerKg ){

        this.productName = productName;
        this.pricePerKg = pricePerKg;
    }

    void salesBot()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("How many kilograms of "+this.productName+" is required : ");
        totRequiredKgs = input.nextInt();
        totAmount = totRequiredKgs * pricePerKg; 
    }
    void display(){
        super.display();
        System.out.println("\t"+pricePerKg+"/kg\t\t"+totRequiredKgs+" kg\t\t"+totAmount);
        System.out.print("---------------------------------------------------------------------");
    }

}

class Electronics extends Products
{
    int pricePerUnit , totRequiredUnits;

    Electronics(String productName,int pricePerUnit)
    {
        this.productName = productName;
        this.pricePerUnit = pricePerUnit;
    }

    void salesBot()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("How many units of "+productName+" is required : ");
        totRequiredUnits= input.nextInt();
        totAmount = pricePerUnit * totRequiredUnits;
    }

    void display()
    {
        super.display();
        System.out.println("\t"+pricePerUnit+"\t\t"+totRequiredUnits+" Units\t\t"+totAmount);
        System.out.print("---------------------------------------------------------------------");
    }
}

class Garments extends Products{

    int pricePerUnit,totRequiredUnits;

    Garments(String productName,int pricePerUnit)
    {
        this.productName = productName;
        this.pricePerUnit = pricePerUnit;
    }
    void salesBot()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("How many units of "+productName+" is required : ");
        totRequiredUnits= input.nextInt();
        totAmount = pricePerUnit * totRequiredUnits;
    }
    void display()
    {
        super.display();
        System.out.println("\t"+pricePerUnit+"\t\t"+totRequiredUnits+" Units\t\t"+totAmount);
        System.out.print("---------------------------------------------------------------------");
    }
}

public class Lab13 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int totNoOfGroceries=3;
        int totNoOfElectronic = 3;
        int totNoOfGarments = 3;
        int totNoOfProducts = totNoOfGarments + totNoOfElectronic + totNoOfGarments;
        int k=0;

        Products p[]=new Products[totNoOfProducts];

        p[k++] = new Groceries("Potato",30);
        p[k++] = new Groceries("Onion",20);
        p[k++] = new Groceries("Tomato",15);

        p[k++] = new Electronics("Monitor",5000);
        p[k++] = new Electronics("Smart Watch",2000);
        p[k++] = new Electronics("Airpods",15000);

        p[k++] = new Garments("Suits",15000);
        p[k++] = new Garments("Shorts",300);
        p[k++] = new Garments("Tshirts",200);

        System.out.println("\n\n\t\t\t\t WELCOME TO MULTI VENDOR SUPER BOT\n");
        System.out.print("Product You are looking for : ");
    
        String requiredProductName = input.nextLine();

        for(int i=0; i<totNoOfProducts;i++)
        {
            //System.out.println(p[i].productName);
            if(p[i].productName.equals(requiredProductName))
            {
                k=i;
                break;    
            }
        }
        
        p[k].salesBot(); 
        p[k].display();     
         
    }
}
