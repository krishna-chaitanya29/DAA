/*Given an array of integers and a non-negative integer k, 
your task is to rotate the array to the right by k positions.

Rotation means that elements at the end of the array move to the beginning, 
and the rest of the elements shift to the right.

Input Format:
--------------
Line-1: An integer n, represents size of array
Line-2 to n: An integer array arr of length n.
Line-n+1: A non-negative integer k, representing the number of positions to rotate the array.

Output Format:
---------------
Line-1: Return the array after being rotated by k positions.

Constraints:
-------------
The rotation should be performed in place with O(1) extra space.
The time complexity should be O(n).

Sample Input-1:
---------------
5
1 2 3 4 5
2

Sample Output-1: 
----------------
4 5 1 2 3

Sample Input2:
--------------
5
1 2 3 4 5
5

Sample Output-2:
---------------
1 2 3 4 5

Sample Input-3:
---------------
5
1 2 3 4 5
7

Sample Output-3: 
----------------
4 5 1 2 3
 */
import java.util.Scanner;
import java.util.Arrays;

public class rotation_array {
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        int rot = input.nextInt();
        if(rot>=size){
            rot = rot%size;
        }
        for (int j = 0; j < rot; j++) {
            int temp = arr[arr.length-1];
             for (int i = arr.length-1; i>0; i--) {
            arr[i]=arr[i-1];
            }
            arr[0]=temp;
            
        }
        
        for (int i : arr) {
            System.out.print(i+" ");
            
        }
        
    }
}
