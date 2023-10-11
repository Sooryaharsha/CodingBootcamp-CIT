import java.util.*;

public class HillCipher {
    static int flag = 0;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String plainText;      
        int n;
        System.out.print("Enter the N value : " );
        n = input.nextInt();
        
        int[][] model = new int[n][n];
        System.out.print("Enter the key values :");
        // Create a model using the key
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                model[i][j] = input.nextInt();
                //System.out.println("model[i][j]: " + model[i][j]);
            }
        }
        System.out.println();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(model[i][j]+" ");
            }
            System.out.println();
        }
         input.nextLine();

        //Split the plain text into n characters

        System.out.print("Enter the message : " );
        plainText = input.nextLine();
        List<Integer> threeLetters  = new ArrayList<Integer>();
        StringBuilder encryptedMessage = new StringBuilder();
        StringBuilder encryptedThreeLetters = new StringBuilder();
        int s=0;
        while(true){
            threeLetters = splitIntoThree(threeLetters,plainText.substring(s, plainText.length()) );
            // space logic
            if(flag==0) s=s+n;
            else if (flag==1) s=s+n+1;
            System.out.println(threeLetters);
            //Encrption 

            encryptedThreeLetters = encryption(threeLetters,model,n);
            encryptedMessage.append(encryptedThreeLetters);
            System.out.println("Encrypted message: " + encryptedMessage);
            if(s >= plainText.length() ) break;
        }

        //Decryption

        //Inverse of the key matrix

        float[][] inverseModel = new float[n][n];
        //inverseModel = inverseMatrix(model,n);

       // }    

        
    }


    static List<Integer> splitIntoThree(List<Integer> threeLetters, String text){
        flag =0;
        threeLetters.clear();
        int count = 0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==' ') {
                flag =1;
                continue;
            }
            else{
                threeLetters.add(text.charAt(i)-97);
                //System.out.println(threeLetters);
                count++;
            }
            if(count == 3) break;

        }

        return threeLetters;
    }
    
    static StringBuilder encryption(List<Integer> threeLetters,int[][] model,int n){
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        int sum;
        for(int i=0;i<1;i++){
            for(int j=0;j<n;j++){
                
                sum=0;
                for(int k=0;k<3;k++){
                    
                    sum += model[k][j] * threeLetters.get(k);
                    System.out.println("Sum : "+sum);
                    
			}
    
            sum = (sum % 26)+ 97;
            System.out.println("Sum after mod and +a : "+sum);
            sb.append((char)sum);
            System.out.println("Equivalent words : "+sb);

            }
        }
        return sb;
    }
   

    



}
