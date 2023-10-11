import java.util.*;

public class vigenes {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the key : ");
        String key = input.nextLine();
        System.out.print("Enter the Plain Text : ");
        String plainText = input.nextLine();

        String encryptedMessage = EncryptionAlgo(key, plainText);
        System.out.println();
        String decryptedMessage = DecryptionAlgo(key, encryptedMessage);
        
            
        } 

     static String EncryptionAlgo(String key, String plainText){

        String encryptedMessage = "";
        int loopCount = plainText.length();
        int i=0;
        int j=0;

        while(loopCount>0) {
            char c = (char) ((((plainText.charAt(i) - 'a') + (key.charAt(j) - 'a') ) % 26) + 'a') ;
            encryptedMessage += c;
            System.out.println("Encrypted Message : "+encryptedMessage); 
            i++;
            j= (j+1)%key.length();
            loopCount--;

    }
    return encryptedMessage;

    }

    static String DecryptionAlgo(String key, String encryptedMessage){

        String decryptedMessage = "";
        int loopCount = encryptedMessage.length();
        int i=0;
        int j=0;

        while(loopCount>0) {
            char c = (char) ((((encryptedMessage.charAt(i) - 'a') - (key.charAt(j) - 'a') +26 ) % 26) + 'a') ;
            decryptedMessage += c;
            System.out.println("Decrypted Message : "+decryptedMessage); 
            i++;
            j= (j+1)%key.length();
            loopCount--;

    }




























































































































































































































































        return decryptedMessage;
    }

   
}
    

