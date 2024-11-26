/*
 * You are given an unsorted array of integers. 
Your task is to implement the QuickSort algorithm to sort the array in ascending order.

QuickSort is a divide-and-conquer algorithm that:
	-Picks an element as a pivot and partitions the given array around the pivot.
	-Recursively applies the same process to the subarrays on the left and right of the pivot.
	-You need to implement QuickSort using the Lomuto partition scheme (where the pivot is chosen as the last element of the array).

Input Format:
-------------
Line-1: An integer n (the size of the array).
Line-2: n space-separated integers representing the elements of the array.

Output Format:
---------------
Line-1: Output the sorted array in a single line, with each element separated by a space.

Constraints:
------------
1 ≤ n ≤ 10^5
-10^9 ≤ arr[i] ≤ 10^9


Sample Input-1:
---------------
6
10 7 8 9 1 5

Sample Output-1:
----------------
1 5 7 8 9 10


Sample Input-2:
---------------
5
3 2 1 5 4

Sample Output-2:
----------------
1 2 3 4 5
 */

import java.util.*;
class SP8_QuickSort
{
    public static class mergeSort
    {
        void merge(int[] arr, int l, int m, int r)
        {
            int[] left_arr = new int[m - l + 1];
            int[] right_arr = new int[r - m];
            
            for(int i=0; i < m-l+1; ++i)
            {
                left_arr[i] = arr[l + i];
            }
            for(int j=0; j < r-m; ++j)
            {
                right_arr[j] = arr[m + 1 + j];
            }
            
            int k = l;
            int i=0, j=0;
            while (i < m-l+1 && j < r-m) {
                if (left_arr[i] <= right_arr[j]) {
                    arr[k] = left_arr[i];
                    i++;
                }
                else {
                    arr[k] = right_arr[j];
                    j++;
                }
                k++;
            }

        // Copy remaining elements of L[] if any
            while (i < m-l+1) {
                arr[k] = left_arr[i];
                i++;
                k++;
            }
    
            // Copy remaining elements of R[] if any
            while (j < r-m) {
                arr[k] = right_arr[j];
                j++;
                k++;
            }
        }
        void sort(int[] arr, int l, int r)
        {
            int m;
            if (l < r)
            {
                m = (l + r) / 2;
                sort(arr, l, m);
                sort(arr, m+1, r);
                merge(arr, l, m, r);
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        
        mergeSort obj = new mergeSort();
        obj.sort(arr, 0, n-1);
        for(int i=0; i<n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
 */