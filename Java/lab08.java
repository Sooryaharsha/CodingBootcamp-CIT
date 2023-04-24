import java.io.*;

class Course
{
    String cname,code;
    private int internal,external;
    static int tot,count=0;
    int sum;
    static float avg;

    Course()
    {
        internal = 0;
        external = 0;
        sum = 0;
        
    }

    Course(String cname,String code)
    {
        this.cname = cname;
        this.code = code;
        ++count;
    }

    public void setInternal(int internal)
    {
        this.internal = internal;
    }

    public void setExternal(int external)
    {
        this.external = external;
    }

    public int getInternal()
    {
        return internal;
    }

    public int getExternal()
    {
        return external;
    }

    public int sum()
    {
        sum = internal + external;
        return sum;
    }

    public static void findTotal(Course c)
    {
        System.out.println(c.sum);
        tot = tot +c.sum; 
    }

    public static float findAverage()
    {
        try{
            avg = tot/count;
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
        return avg;
    }


}

public class lab08 {

    public static void main(String[] args) throws IOException
    {
        int x;
        String cname,code;
        int internal,external;

        

        System.out.print("Enter the no of courses : ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        x=Integer.parseInt(input.readLine());
        Course[] arr = new Course[x];

        try{

        for(int i=0;i<x;i++)
        {
            System.out.print("\nCourse name  : " );
            cname = input.readLine();
            System.out.print("Course code  : " );
            code = input.readLine();
            System.out.print("Internal Marks  : " );
            internal = Integer.parseInt(input.readLine());
            System.out.print("External Marks  : " );
            external = Integer.parseInt(input.readLine());

            arr[i] =  new Course(cname,code);
            arr[i].setInternal(internal);
            arr[i].setExternal(external);
            arr[i].sum();
            Course.findTotal(arr[i]);
        }
    } catch (NumberFormatException e) { e.printStackTrace(); }  
        

        System.out.println("\n\nCourse Name \t\t Course Code \t\t Internal \t\t External \t\t Final Mark ");
        for(int i=0;i<x;i++)
        {
            System.out.println("\n"+arr[i].cname+ "\t\t\t   "+ arr[i].code+"\t\t  "+ "  "+ arr[i].getInternal() + "\t\t\t   " + 
            arr[i].getExternal()+"\t\t\t   "+ arr[i].sum());

            if(i==x-1)
            {
                System.out.println("\nTotal marks : "+Course.tot+"\nAverage mark : "+Course.findAverage());
            }
        
        }
    }
    
}
