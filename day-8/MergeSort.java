/*
 * You are given an unsorted array of integers. 
Your task is to implement the MergeSort algorithm to sort the array in ascending order.

MergeSort is a divide-and-conquer algorithm that:
	-Divides the array into two halves.
	-Recursively sorts the two halves.
	-Merges the two sorted halves to produce the final sorted array.
	-Your task is to write a function that sorts the given array using MergeSort.

Input Format:
--------------
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
12 11 13 5 6 7

Sample Output-1:
----------------
5 6 7 11 12 13


Sample Input-2:
---------------
5
10 1 2 8 5

Sample Output-2:
----------------
1 2 5 8 10

 */

 public class MergeSort {

    // Function to merge two halves of an array
    public static void merge(int[] arr, int left, int mid, int right) {
        // Find the sizes of the two subarrays to be merged
        int leftHalf = mid - left + 1;
        int rightHalf = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[leftHalf];
        int[] rightArray = new int[rightHalf];

        // Copy data to temporary arrays
        for (int i = 0; i < leftHalf; i++)
            leftArray[i] = arr[left + i];
        for (int i = 0; i < rightHalf; i++)
            rightArray[i] = arr[mid + 1 + i];

        // Initial indexes of the subarrays
        int i = 0, j = 0;

        // Initial index of the merged array
        int k = left;

        // Merge the temporary arrays
        while (i < leftHalf && j < rightHalf) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray[], if any
        while (i < leftHalf) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray[], if any
        while (j < rightHalf) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[left...right] using merge()
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Driver code to test the merge sort algorithm
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array");
        printArray(arr);
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
