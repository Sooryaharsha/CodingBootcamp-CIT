import java.util.*;

class ColumnTransposition{

    public static void display(char[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static String encrypt(String plaintext, String key) {
        int keyLength = key.length();
        int numRows = (int) Math.ceil((double) plaintext.length() / keyLength);
        char[][] grid = new char[numRows][keyLength];

        // Fill the grid with the plaintext
        int plaintextIndex = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < keyLength; col++) {
                
                if (plaintextIndex < plaintext.length()) {

                    // if(plaintext.charAt(plaintextIndex) == ' ') {
                    //     plaintextIndex++;
                    //     continue;
                    // }

                    grid[row][col] = plaintext.charAt(plaintextIndex);
                    plaintextIndex++;
                } else {
                    grid[row][col] = ' ';
                }
            }
        }

        display(grid);



        // Create an array to store the column order
        int[] order = new int[keyLength];
        for (int i = 0; i < keyLength; i++) {
            order[i] = key.charAt(i);
        }

        // Sort the order array and apply the same permutation to the grid
        Arrays.sort(order);
        StringBuilder ciphertext = new StringBuilder();
        char[][] encryptedGrid = new char[numRows][keyLength];
        for (int col = 0; col < keyLength; col++) {
            int originalIndex = key.indexOf(order[col]);
            for (int row = 0; row < numRows; row++) {
                // System.out.println(grid[row][originalIndex]);
                // encryptedGrid[col][row] = grid[row][originalIndex];

                ciphertext.append(grid[row][originalIndex]);


            }
        }
        // System.out.println("EncryptedGrid: " );
        // display(encryptedGrid);


        return ciphertext.toString();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Plain text : ");
        String plaintext = input.nextLine();
        System.out.print("Enter the key String : ");
        String key = input.nextLine();

        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);
    }
}