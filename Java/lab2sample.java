import java.util.*;

class shape
{
	int len,wid,hei;
	
	shape()
	{
		len=0;
		wid=0;
		hei=0;
	}
	
	shape(int l,int b,int h)
	{
		len=l;
		wid=b;
		hei=h;
	}
	public  int area(int l)
	{
		int area= l*l;
		
		return area;
	}
	
	public int area(int l,int b)
	{
		int area= l*b;
		return area;
	}
	
	public int area(int l,int b,int h)
	{
		int area= 2*(l*b + l*h + h*b);
		return area;
	}
	
	public int perimeter(int l)
	{
		return 4*l;
	}
	
	public int perimeter(int l,int b)
	{
		return 2*(l+b);
	}
	
	public int perimeter(int l,int b,int h)
	{
		return 4*(l+b+h);
	}
	
	
}

public class lab2sample
{
	public static void main(String[] args)
	{
		shape sh = new shape(10,7,8);
		System.out.println("Area of Square is : "+sh.area(sh.len));
		System.out.println("Area of Rectangle is : "+sh.area(sh.len,sh.wid));
		System.out.println("Area of Cuboid is : "+sh.area(sh.len,sh.wid,sh.hei));
		System.out.println("Perimeter of Square is : "+sh.perimeter(sh.len));
		System.out.println("Perimeter of Rectangle is : "+sh.perimeter(sh.len,sh.wid));
		System.out.println("Perimeter of Cuboid is : "+sh.perimeter(sh.len,sh.wid,sh.hei));
	}
}
	