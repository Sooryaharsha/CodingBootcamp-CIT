import java.util.*;

class CaseInsensitiveString {
    private final String value;
    
    public CaseInsensitiveString(String value) {
        this.value = value;
        System.out.println(this);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CaseInsensitiveString)) {
            return false;
        }
        String otherValue = ((CaseInsensitiveString) o).value;
        return this.value.equalsIgnoreCase(otherValue);
    }
    
    // Other methods of the class
}
public class Ex01{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String name1 = input.nextLine();
        String name2 = input.nextLine();
        CaseInsensitiveString a = new CaseInsensitiveString(name1);
        CaseInsensitiveString b = new CaseInsensitiveString(name2);
        Boolean k = b.equals(a);
        System.out.println(k);

         
    }
}

