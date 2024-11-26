/*
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements. 
The operation should be performed in-place without making a copy of the array, and the time complexity should be minimized.

Constraints:
------------
nums contains only integers.
You must maintain the relative order of the non-zero elements.
The operation must be done in-place with O(1) extra space.

Input Format:
-------------
Line-1: An integer, size of the array
Line-2 to n: A single array of integers nums with at least one element.

Output Format:
-------------
Line-1: The modified input array nums, where all zeros are moved to the end while maintaining the relative order of the non-zero elements.

Sample Input-1:
----------------
5
0 1 0 3 12

Sample Output-1:
----------------
1 3 12 0 0

Sample Input-2:
---------------
1
0

Sample Output-2:
-----------------
0

 */
import java.util.Scanner;
public class modify_zero{
    public static String remove(int[] arr){
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[j]!=0){
                        arr[i]=arr[j];
                        arr[j]=0;
                        break;
                    }
                    
                }
            }
        }

        
        return arr.toString();
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