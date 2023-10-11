import java.util.*;
public class CatOne {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Plain text : ");
        String plaintext = input.nextLine();
        System.out.print("Enter the key Sentance : ");
        String keySentance = input.nextLine();

        String generatedKey = KeyGenerator(keySentance);
        System.out.println("Generated Key : "+generatedKey);

        String encryptedText = encrypt(plaintext, generatedKey);
        System.out.println("Encypted Text : " + encryptedText);

        char[][] decryptMatrix = findMatrix(encryptedText,generatedKey.length());

        String decryptedText = decrypt(encryptedText, generatedKey,decryptMatrix);
        System.out.println("Decypted Text : " +decryptedText );
    }

    public static String KeyGenerator(String key) {

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<key.length()-1;i++) {
            if (key.charAt(i+1)==' '){
                sb.append(key.charAt(i));
            }
        }
        //last letter logic
        sb.append(key.charAt(key.length()-1));

        return sb.toString();
    }


    public static String encrypt(String plaintext, String key) {
        int keyLength = key.length();

        //find the plain text length 
        int plaintextLength = findLength(plaintext);

        System.out.println("plaintextLength: " + plaintextLength);

        //find No of Rows required
        int numRows = (int) Math.ceil((double) plaintextLength / keyLength);
        char[][] matrix = new char[numRows][keyLength];

        //Remove spaces 
        StringBuilder msg = new StringBuilder();

        for(char c : plaintext.toCharArray()){
            if(c!=' '){
                msg.append(c);
            }
        }
        System.out.println("Plain text after removing Spaces : "+msg.toString());

         int plaintextIndex = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < keyLength; col++) {
                
                if (plaintextIndex < plaintextLength) {

                    matrix[row][col] = msg.charAt(plaintextIndex);
                    plaintextIndex++;
                    //}
                } 
                else {
                    matrix[row][col] = ' ';
                }
            }
        }

        display(matrix);



        // Create a clone of Key and store ASCII values and sort them
        int[] cloneKey = new int[keyLength];
        for (int i = 0; i < keyLength; i++) {
            cloneKey[i] = key.charAt(i);
        }
        Arrays.sort(cloneKey);


        StringBuilder encryptedText = new StringBuilder();
       
        for (int col = 0; col <keyLength  ; col++) {
            int originalIndex = key.indexOf(cloneKey[col]);
            for (int row = 0; row < numRows; row++) {

                encryptedText.append(matrix[row][originalIndex]);
            }
        }


        return encryptedText.toString();
    }

    public static void display(char[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int findLength(String str){
        int len=0;
        for(char i : str.toCharArray()){
            if (i!=' ')
                len++;
        }
        return len;
    }

    public static char[][] findMatrix(String encryptedText, int keyLength){

        int numRows = (int) Math.ceil((double) encryptedText.length() / keyLength);
        char [][] matrix = new char[numRows][keyLength];

        // ArrayList<ArrayList<Character>> encrpt = new ArrayList<ArrayList<Character>>();

        // for(int i=0;i<keyLength;i++){

        //     encrpt.get(i).add('l')
        // }

        int index=0;

        for(int row=0;row<numRows;row++){
            for(int col=0;col<keyLength;col++){
                if(index < encryptedText.length()){
                    matrix[row][col] = encryptedText.charAt(index++);
                }
                else{
                    matrix[row][col] = ' ';
                }
            }
        }

        System.out.println("Decrytion Matrix : " );
        display(matrix);

        return matrix;
    }

    public static String decrypt(String encryptedText, String key,char[][] decryptMatrix){

        StringBuilder decryptText = new StringBuilder();
        
        int keyLength = key.length();
        int numRows = (int) Math.ceil((double) encryptedText.length() / keyLength);

        int[] cloneKey = new int[keyLength];
        for (int i = 0; i < keyLength; i++) {
            cloneKey[i] = key.charAt(i);
        }
        Arrays.sort(cloneKey);


        StringBuilder decrytText = new StringBuilder();
       
        for (int col = 0; col <keyLength  ; col++) {
            int originalIndex = key.indexOf(cloneKey[col]);
            for (int row = 0; row < numRows; row++) {

                decryptText.append(decryptMatrix[row][originalIndex]);
            }
        }


        return decryptText.toString();
    }

    
    
}
