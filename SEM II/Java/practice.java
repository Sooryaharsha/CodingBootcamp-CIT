import java.util.*;

public class practice
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println(name);
        char c[] = name.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            System.out.println(c[i]);
            System.out.println(name.charAt(i));
        }
    }
}