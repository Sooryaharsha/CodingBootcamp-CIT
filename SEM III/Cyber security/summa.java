public class summa {
    public static void main(String[] args){
        //pileOfCoins();
        //arrayEnsure();
    }

    static void pileOfCoins(){
        int [] a = {3,6,7,11};
        int h=8;
        int res=0;

        for(int i=1 ;i<=100;i++) {
            int b[] = a.clone();
            System.out.println("Array values : ");
            for(int j=0;j<b.length;j++){
                System.out.print(b[j]+" ");
            }
            res = helper(b,i);
            if(res<=h){
                res = i;
                break;
            } 

        }
        System.out.println("Result: " + res);
    }
    static int helper(int[] a, int k){
        int count=0;
        int i =0;
        int flag = 0;
        while(true){

                    if(a[i]>0){
                    a[i] = a[i]-k;
                    count++;
                    i++;
                }
                else{
                    flag++;
                    i++;
                }
                
                if(flag==a.length) break;
                if(i==a.length){
                    i=i%a.length;
                    flag = 0;
                }
            }
        return count;
        }

    static void arrayEnsure(){
        int[][] a = new int[5][5];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j]++;
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }
   
}
