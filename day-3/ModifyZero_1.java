import java.util.Scanner;
import java.util.Arrays;

public class ModifyZero_1 {
    public static String remove(int[] arr) {
        int pos = 0;  // Position to place the next non-zero element
        
        // Move all non-zero elements to the front of the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[pos] = arr[i];
                pos++;
            }
        }
        
        // Fill the remaining positions with zeros
        while (pos < arr.length) {
            arr[pos] = 0;
            pos++;
        }
        
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Step 1: Input the size of the array
        int size = input.nextInt();
        int[] arr = new int[size];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        System.out.print(remove(arr));
    }
}