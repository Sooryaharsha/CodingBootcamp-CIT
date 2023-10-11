import java.util.*;
public class PlayfairCipher{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("\n\nEnter the Key String : " );
        String key = input.nextLine();
        key = key.toLowerCase();
        char[][] model = new char[5][5];

        // Remove duplicates from key and replace j with i if exists
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i <key.length(); i++) {

            if(list.contains(key.charAt(i))) continue;
            else list.add(key.charAt(i));
        }
        System.out.println("Key after removing the duplicates : "+ list);

        // Store the remaining alphabets in the 2D array
        for (char i = 'a'; i<='z'; i++) {
            if(list.contains(i)) {

                // key contains i but not j then skip j
                if(i=='i' && !list.contains('j')) i++;
                // key contains j and we added i then remove j
               else if(i=='j' && list.contains('i')){
                    list.remove('j');
                }
                
                continue;
            }
            else{
                
                // key does not contain i we added i and check if j is present 
                // if true remove i else skip j 
                list.add(i);

                if(i=='i' && list.contains('j')){
                    int a=list.indexOf('i');
                    list.remove(a);
                }
                else if(i=='i') i++;
            } 
        }
        System.out.println("Key after adding remaining alphabets : "+ list);


        // Store the list in 2D array
        int row,col;
        row = col = 0;
        for(Character c : list){
            if(col<5){
                model[row][col] = c;
                col++;
            } 
            else {
                col=0;
                row = row + 1;
                model[row][col] = c;
                col++;
            } 
        }
        
        // printing the model 
        for(int i=0; i<5 ;i++){
            for(int j=0; j<5;j++){
                System.out.print(model[i][j]+" ");
            }
            System.out.println(" ");
            
        }

        // input the Message string
        System.out.print("\nEnter the Message string : ");
        String message = input.nextLine();
        message = message.toLowerCase();
        int charCount =0;

        // replace adjacent duplicates 
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<message.length()-1; i++){ 

            if (message.charAt(i) == ' ')  continue;
            sb.append(message.charAt(i));
            charCount++;
            if(message.charAt(i)==message.charAt(i+1)){
                sb.append("x");
                charCount++;
               
            }

            //last Character logic
            if(i==message.length()-2) {
                sb.append(message.charAt(i+1));
                charCount++;
            }
        }

        //Even pairs checking
        if(charCount % 2 != 0){
            sb.append("x");
            charCount++;
        } 
        
    
        System.out.println(sb.toString());
        
        //separating each pairs into the stringlist
        List<String> stringList = new ArrayList<String>();
        StringBuilder pairString = new StringBuilder();
        String encryptedMessage  = new String();
        encryptedMessage = "";
        for(int i =0;i<charCount-1;i+=2) {
            pairString.append(sb.charAt(i));
            pairString.append(sb.charAt(i+1));
            stringList.add(pairString.toString());
            pairString.setLength(0);
        }

        System.out.println(stringList.toString());

        //Encryption algorithm
        int firstRowIndex , secondRowIndex , firstColumnIndex , secondColumnIndex;
        firstRowIndex = firstColumnIndex = secondColumnIndex = secondRowIndex  = -1;
        for(String pair : stringList){

            //retrive the row and column number to check whether the pair occurs in the same row or column
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(model[i][j] == pair.charAt(0))  {
                        firstRowIndex = i;
                        firstColumnIndex = j;
                    }
                    if(model[i][j] == pair.charAt(1)){
                        secondRowIndex = i;
                        secondColumnIndex = j;
                        
                    }
                }

            // System.out.println("First Character row and column: " + firstRowIndex + " " + firstColumnIndex);
            // System.out.println("Second Character row and column: " + secondRowIndex + " " + secondColumnIndex);
        }

        // same row logic
                if(firstRowIndex == secondRowIndex) {
                    //first letter
                    int shiftIndex = (firstColumnIndex + 1)%5;
                    encryptedMessage = encryptedMessage+ model[firstRowIndex][ shiftIndex ];
                    //second letter
                    shiftIndex = (secondColumnIndex + 1)%5;
                    encryptedMessage = encryptedMessage+ model[secondRowIndex][ shiftIndex ];
                }
                //same column logic
                else if(firstColumnIndex == secondColumnIndex){
                    //first 
                    int shiftIndex = (firstRowIndex + 1)%5;
                    encryptedMessage = encryptedMessage+ model[ shiftIndex ][firstColumnIndex];
                    //second
                    shiftIndex = (secondRowIndex + 1)%5;
                    encryptedMessage = encryptedMessage+ model[ shiftIndex ][secondColumnIndex];
                }
                //Neither same row nor same column logic
                else{
                    //first letter
                    encryptedMessage = encryptedMessage+ model[firstRowIndex][ secondColumnIndex];
                    encryptedMessage = encryptedMessage+ model[secondRowIndex][ firstColumnIndex];
                }


            System.out.println("The Encrypted Message : " + encryptedMessage   );
        } 
        System.out.println("The Encrypted Message : " + encryptedMessage   );


        //Decryption algorithm
        List<String> encryptedMessageList = new ArrayList<String>();
        StringBuilder encryptedPairString = new StringBuilder();
        String decryptedMessage  = new String();
        decryptedMessage = "";

        // Making the encrypted message pairs
        for(int i =0;i<charCount-1;i+=2) {
            pairString.append(encryptedMessage.charAt(i));
            pairString.append(encryptedMessage.charAt(i+1));
            encryptedMessageList.add(pairString.toString());
            pairString.setLength(0);
        }

        System.out.println(encryptedMessageList.toString());

        for(String pair : encryptedMessageList){

            //retrive the row and column number to check whether the pair occurs in the same row or column
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(model[i][j] == pair.charAt(0))  {
                        firstRowIndex = i;
                        firstColumnIndex = j;
                    }
                    if(model[i][j] == pair.charAt(1)){
                        secondRowIndex = i;
                        secondColumnIndex = j;
                        
                    }
                }
        }

        // same row logic
                if(firstRowIndex == secondRowIndex) {
                    //first letter
                    int shiftIndex = (firstColumnIndex - 1+5)%5;
                    decryptedMessage +=  model[firstRowIndex][ shiftIndex ];
                    //second letter
                    shiftIndex = (secondColumnIndex - 1 +5)%5;
                    decryptedMessage += model[secondRowIndex][ shiftIndex ];
                }
                //same column logic
                else if(firstColumnIndex == secondColumnIndex){
                    //first 
                    int shiftIndex = (firstRowIndex - 1+5)%5;
                    decryptedMessage +=  model[ shiftIndex ][firstColumnIndex];
                    //second
                    shiftIndex = (secondRowIndex - 1+5)%5;
                    decryptedMessage +=  model[ shiftIndex ][secondColumnIndex];
                }
                //Neither same row nor same column logic
                else{
                    
                    decryptedMessage  = decryptedMessage + model[firstRowIndex][ secondColumnIndex];
                    decryptedMessage  = decryptedMessage + model[secondRowIndex][ firstColumnIndex];
                }


            System.out.println("The Decrypted Message : " + decryptedMessage   );
        } 
        System.out.println("The Decrypted Message : " + decryptedMessage  );
}
}
