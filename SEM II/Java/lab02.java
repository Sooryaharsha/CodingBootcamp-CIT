import java.util.*;

class shape
{
	int area,length,breadth,height;
	int perimeter;
	String shapetype;
	static int count;
	
     shape()
	{
		System.out.println("This is a default constructor");
	}
	
	 shape(int a)
	{
		shapetype = "Square";
		System.out.println("The Shape is : "+shapetype);
		length =a;
		area(shapetype);
		perimeter(shapetype);
	}
	
	 shape(int l , int b)
	{
		shapetype = "Rectangle";
		System.out.println("The Shape is : "+shapetype);
		length = l;
		breadth =b;
		area(shapetype);
		perimeter(shapetype);
		
	}
	
	 shape(int l, int b,int h)
	{
		shapetype = "Cuboid";
		System.out.println("The Shape is : "+shapetype);
		length = l;
		breadth =b;
		height =h;
		area(shapetype);
		perimeter(shapetype);
	}
	public void area(String shapetype)
	
	{
		if(shapetype=="Square")
		{
			area = length*length;
			System.out.println("The area of "+shapetype+" is "+area);
			
		}
		else if(shapetype=="Rectangle")
		{
			area = length*breadth;	
			System.out.println("The area of "+shapetype+" is "+area);
			
		}
		else
		{
			area = 2*(length*breadth + breadth*height + length*height);
			System.out.println("The area of "+shapetype+" is "+area);
		}
	}
	
	public void perimeter(String shapetype)
	{
		switch(shapetype)
		{
			case "Square":
					perimeter = 4*length;
					System.out.println("The perimeter of "+shapetype+" is "+perimeter);
					break;
			
			case "Rectangle":
					perimeter = 2*(length+breadth);
					System.out.println("The perimeter of "+shapetype+" is "+perimeter);
					break;
					
			case "Cuboid" :
					perimeter= 4*(length+breadth+height);
					System.out.println("The perimeter of "+shapetype+" is "+perimeter);
					break;
		}
	}
			
}
		


public class lab02
{
	public static void main(String[] args)
	{
		shape sh = new shape();
		shape sh1 = new shape(10);
		shape sh2 = new shape(6,8);
		shape sh3 = new shape(3,4,5);
	}
}
