import java.util.*;

class shape
{
	//int l,b,h,area,perimeter;
	
	public  int area(int l)
	{
		int area= l*l;
		//System.out.println("The area is : "+area);
		return area;
	}
	
	public int area(int l,int b)
	{
		int area= l*b;
		//System.out.println("The area is : "+area);
		return area;
	}
	
	public int area(int l,int b,int h)
	{
		int area= 2*(l*b + l*h + h*b);
		//System.out.println("The area is : "+area);
		return area;
	}
}

public class lab2sample
{
	public static void main(String[] args)
	{
		shape sh = new shape();
		System.out.println("Area of Square is : "+sh.area(10));
		System.out.println("Area of Rectangle is : "+sh.area(7,8));
		System.out.println("Area of Cuboid is : "+sh.area(2,3,4));
	}
}
	