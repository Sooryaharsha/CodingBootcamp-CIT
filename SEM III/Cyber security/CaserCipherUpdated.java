import java.util.Scanner;

public class CaserCipherUpdated {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Shift value : ");

        int k = input.nextInt();
        System.out.print("Enter the message : ");

        input.nextLine();
        String message = input.nextLine();

        char messageArray[] = message.toLowerCase().toCharArray();
        StringBuilder encryptedMessage = new StringBuilder();

        encryptedMessage.setLength(0);

        
        
        // for(char i : messageArray){
        //     if(i == ' ' )
        //     {
        //         encryptedMessage.append(" ");
        //     }
        //     else{
        //         int algo = (i+k)%123  ;
        //         k = (k + shiftDiff) % 26;
        //         algo = algo<97 ? 97+algo : algo; 
        //         char encryption = (char) algo;
        //         encryptedMessage.append(encryption);
        //         System.out.println(encryptedMessage);
        //     }
            
        // }
        
    }
}
