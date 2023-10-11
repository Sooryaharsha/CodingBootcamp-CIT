import java.util.*;

class CaeserCipher
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Shift value : ");
        int k = input.nextInt();
        System.out.print("Enter the message : ");
        input.nextLine();
        String message = input.nextLine();
        char messageArray[] = message.toLowerCase().toCharArray();
        StringBuilder encryptedMessage = new StringBuilder();
        for(char i : messageArray){
            if(i == ' ' )
            {
                encryptedMessage.append(" ");
            }
            else{
                int algo = (i+k)%123  ;
                algo = algo<97 ? 97+algo : algo; 
                char encryption = (char) algo;
                encryptedMessage.append(encryption);
                // System.out.println(encryptedMessage);
            }
            
        }
        System.out.println("Encrypted message : "+encryptedMessage);

        //Decryption
        StringBuilder decryptedMessage = new StringBuilder();
        for(int i=0 ; i<encryptedMessage.length() ; i++){
            if(encryptedMessage.charAt(i) == ' ' )
            {
                decryptedMessage.append(" ");
            }
            else{
                int algo = (encryptedMessage.charAt(i)-k) %123   ;
                algo = algo<97 ? algo+26 : algo;
                char decryption = (char) algo;
                decryptedMessage.append(decryption);
                // System.out.println(decryptedMessage);
            }
        }
        System.out.println("Decrypted message : "+decryptedMessage);

    }
}