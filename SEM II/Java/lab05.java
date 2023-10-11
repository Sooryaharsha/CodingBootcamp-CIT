import java.util.*;

class obj implements Cloneable
{
    int rno;
    String name;

    obj(int rno, String name)
    {
        this.rno = rno;
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override protected void finalize()
    {
        System.out.println("Finalize method called");
    }
}

public class lab05
{
    
    public static void main(String[] args)
    {
        obj s1 = new obj(1,"Jaime");
        obj s3 = new obj(3,"Lannister");
        obj s4 = new obj(4,"Jon Snow");
        try 
        {
            System.out.println("Clone of the object s1");
            obj s2 = (obj)s1.clone();
            System.out.println(s1.rno+" "+s1.name);
            System.out.println(s2.rno+" "+s2.name);
            System.out.println("obj s1 equals to s2 ? "+s1.equals(s2));
            System.out.println("Hash code of the object s2 is "+s2.hashCode());

        } catch (CloneNotSupportedException c) {}

        System.out.println("Hash code of the object s1 is "+s1.hashCode());
        System.out.println("String representation of the object s1 is "+s1.toString());
        System.out.println("obj s1 equals to s3 ? "+s3.equals(s1));
        System.out.println(" s1 is the instance of the : "+s1.getClass());
        System.gc();
        
    }
   
}