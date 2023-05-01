import java.util.*;
public class Sortedarray {

    public static void main(String[] args){
        int m,n,i,j;
        
        Scanner input = new Scanner(System.in);

        m= input.nextInt();
        n= input.nextInt();
        
        int []a=new int[m];
        int []b=new int[n];
        ArrayList<Integer> r = new ArrayList<Integer>();

        for(i=0;i<m;i++){
            a[i]=input.nextInt();
    }
    for(j=0;j<n;j++){
        b[j]=input.nextInt();
    }

    //merge two sorted arrays
    i=0;j=0;
    while(i<m && j<n){
        if(a[i]<=b[j]){
            r.add(a[i]);
            i++;
        }
        else{
            r.add(b[j]);
            j++;
        }
    }
    if(i<m ){
        while(i<m){
            r.add(a[i]);
            i++;
        }
    }
    if(j<n){
        while(j<n){
            r.add(b[j]);
            j++;
        }
    }
    System.out.println(r);
}
}
