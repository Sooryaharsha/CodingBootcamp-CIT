import java.util.*;

public class lab06 {
    
    public static void main(String[] args)
    {
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("Autoboxing of Integer ");
        System.out.print("Enter a int value : ");
        int a = input.nextInt();
        Integer a2 = a;
        System.out.println("The Integer value is : "+a2);
        System.out.println("Autounboxing of Integer ");
        Integer a3 = 300;
        int a4 = a3;
        System.out.println("The Integer value is : "+a3);
        System.out.println("The int value is : "+a4);
        System.out.println();


        System.out.println("Autoboxing of floating point number ");
        System.out.print("Enter a float value : ");
        float b = input.nextFloat();
        Float b2 = b;
        System.out.println("The Float value is : "+b2);
        System.out.println("Autounboxing of Float ");
        Float b3 = new Float(10.8);
        float b4 = b3;
        System.out.println("The Float value is : "+b3);
        System.out.println("The float value is : "+b4);
        System.out.println();

        System.out.println("Autoboxing of double");
        System.out.print("Enter a double value : ");
        double d = input.nextDouble();
        Double d2 = d;
        System.out.println("The Double value is : "+d2);
        System.out.println("Autounboxing of Double ");
        Double d3 = 345.7893643452;
        double d4 = d3;
        System.out.println("The Double value is : "+d3);
        System.out.println("The double value is : "+d4);
        System.out.println();

        System.out.println("Autoboxing of byte");
        System.out.print("Enter a byte value : ");
        byte c = input.nextByte();
        Byte c2 = c;
        System.out.println("The Byte value is : "+c2);
        System.out.println("Autounboxing of Double ");
        Byte c3 = 21;
        byte c4 = c3;
        System.out.println("The Byte value is : "+c3);
        System.out.println("The byte value is : "+c4);
        System.out.println();

        System.out.println("Autoboxing of char datatype");
        char x= 'b';
        Character x1 = x;
        System.out.println("The char value is : "+x);
        System.out.println("The Character value is : "+x1);
        System.out.println("Autounboxing of Character ");
        Character x3 = 'c';
        char x4 =x3;
        System.out.println("The Character value is : "+x3);
        System.out.println("The char value is : "+x4);
    }
}
