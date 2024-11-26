/*
 * You are given an array of integers containing both positive and negative values. 
Your task is to rearrange the array such that all negative integers appear before the positive integers while preserving the relative order of the numbers. 
The order of positive and negative integers in the array should remain unchanged, but negatives must come before positives.

Input Format:
--------------
Line-1: An integer n, the number of integers in the array.
Line-2: n integers, which are a mix of positive and negative numbers.

Output Format:
---------------
Line-1: Print the rearranged list of integers where all negative numbers come before the positive numbers while preserving the relative order.

Constraints:
------------
* 1 ≤ n ≤ 10^5 (The size of the array can be up to 100,000 integers).
* The array contains both positive and negative integers. Zero is considered as a positive number.

Sample Input-1:
---------------
8
9 -3 5 -2 -8 -6 1 3

Sample Output-1:
[-3, -2, -8, -6, 9, 5, 1, 3]


Sample Input-2:
---------------
8
5 -4 3 -4 2 1 -5 -6

Sample Output-2:
-----------------
[-4, -4, -5, -6, 5, 3, 2, 1]
 */

import java.util.*;

public class Rearrange_numbers{
    public static void ArrangeArray(int[] arr, int low, int middle, int high){
        int n1 = middle-low+1;
        int n2 = high-middle;
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for(int i = 0; i<n1;i++){
            left[i] = arr[low+i];
        }
        for(int i = 0; i<n2; i++){
            right[i] = arr[middle+1+i];
        }
        int i = 0;
        int k = low;
        while(i<n1){
            if (left[i]<0){
                arr[k] = left[i];
                k++;
            }
            i++;
        }
        int j = 0;
        while(j<n2){
            if (right[j]<0){
                arr[k] = right[j];
                k++;
            }
            j++;
        }
        
        i = 0;
        while(i<n1){
            if (left[i]>=0){
                arr[k] = left[i];
                k++;
            }
            i++;
        }
        j = 0;
        while(j<n2){
            if (right[j]>=0){
                arr[k] = right[j];
                k++;
            }
            j++;
        }
    }
    public static void RearrangeNumbers(int[] arr, int low, int high){
        if (low >= high){
            return;
        }
        
        int middle = (low+high)/2;
        RearrangeNumbers(arr, low, middle);
        RearrangeNumbers(arr, middle+1, high);
        ArrangeArray(arr, low, middle, high);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        RearrangeNumbers(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
    
}
 */