import java.util.*;

 class Product
{
	private String pname;
	String cname;
	private int price,amount;
	int avail_stock;
	static int sno=1,gtot=0,invoice=1024;
	
  Product()
  {
	  System.out.println("This is the default constructor");
  }
  Product(String name, int avl_stock)
  {
	  pname = name;
	  avail_stock = avl_stock;
  }
  
  public void setprice(int p)
  {
	  price = p;
	  
  }
  
  public void orderamt(int qty,String cname)
  {
	  this.cname=cname;
	  if(qty<avail_stock)
	  {
		  amount = qty * price;
		  gtot+=amount;
		  avail_stock-=qty;
		  invoice(qty,cname);
		  
	  }
	  else
	  {
		  System.out.println("Your Required amount of stock is not available");
	  }
  }
  
    public int getTot()
  {
	  return gtot;
  }
	
  public void invoice(int qty,String cname)
  {
	  System.out.println();
	  System.out.println();
	  System.out.print(sno+"\t\t"+pname+"\t\t\t"+qty+"\t\t"+price+"\t\t"+amount+"\t\t");
	  sno=sno+1;
  }
 
}
  

public class lab04
{
	public static void main(String[] args )
	{
		int k=1;
		int qty1,qty2,qty3;
		String name;
		Scanner input = new Scanner(System.in);
		
		Product p1 = new Product("Laptop",40);
		p1.setprice(30000);
		
		//p1.invoice(5);
		
		Product p2 = new Product("Mouse",20);
		p2.setprice(100);
		
		
		Product p3 = new Product("Monitor",10);
		p3.setprice(7000);
		
		
		//System.out.println("\t\t"+p3.getTot());
		
		while(k==1)
		{
			System.out.print("Customer Name : ");
			name = input.next();
			System.out.print("No. of Laptops : ");
			qty1= input.nextInt();
			System.out.print("No. of Mouse : ");
			qty2= input.nextInt();
			System.out.print("No. of Monitor : ");
			qty3= input.nextInt();
			System.out.println("\n\n\tInvoice No. : "+p1.invoice+"\t\t Customer name : "+name+"\t\tDate : "+java.time.LocalDate.now());
			System.out.println("\n S.no.  \tProduct Name  \t\tQty \t\tPrice  \t\tAmount  \tGrand total ");
			System.out.println("---------------------------------------------------------------------------------------------------");
			p1.orderamt(qty1,name);
			p2.orderamt(qty2,name);
			p3.orderamt(qty3,name);
			System.out.println(p3.getTot());
			System.out.println("\n\n\n\n\t\tAVAILABILITY\n\n");
			System.out.println("Laptop  \t\t Mouse 3\t\t Monitor ");
			System.out.println("-------------------------------------------------------");
			System.out.println(p1.avail_stock+"\t\t\t  "+p2.avail_stock+"\t\t\t\t  "+p3.avail_stock);
			
			k=0;	
		
	}
}
}

  
	  
	  