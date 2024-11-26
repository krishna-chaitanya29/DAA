/*
 * Given an array nums of size n, return the majority element. 
The majority element is the element that appears more than ⌊n / 2⌋ times.

You may assume that the majority element always exists in the array.

Input Format:
--------------
Line-1: An integer n (the size of the array).
Line-2: n space-separated integers representing the elements of the array.

Output Format:
--------------
Line-1: Output a single integer, the majority element.

Constraints:
-------------
1 ≤ n ≤ 5 * 10^4
-10^9 ≤ nums[i] ≤ 10^9


Sample Input-1:
---------------
3
3 2 3

Sample Output-1:
----------------
3

Explanation:
The number 3 appears more than n/2 times, so it is the majority element.

Sample Input-2:
---------------
7
2 2 1 1 1 2 2

Sample Output-2:
----------------
2

Explanation:
The number 2 appears 4 times, which is more than n/2 = 3.5, so it is the majority element.

 */

 import java.util.*;

public class Majority_element{
    public static int MajorityElement(int[] arr){
        int count = 0;
        Integer candidate = null;
        for(int num:arr){
            if(count==0){
                candidate = num;
            }
            count += (candidate==num)? 1 : -1;
        }
        return candidate;
    }
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for(int i =0;i<arr.length;i++){
                arr[i] = sc.nextInt();
            }
            System.out.print(MajorityElement(arr));
        }
    }
}