/*
 * In a school, the 5th standard class is divided into two sections, Rose and Lotus. 
The teacher has recorded the scores of students from both sections in their Mathematics exam. 
The marks for both sections are provided in ascending order. 
The task is to compute the median of the combined marks of both sections.

You are given the number of students in each section and their respective marks. Your task is to find the median of the combined sorted marks from both sections.

The overall run-time complexity of your solution should be O(log(min(m + n))).

Input Format:
-------------
Line-1: An integer m, representing the number of students in section Rose.
Line-2: An integer n, representing the number of students in section Lotus.
Line-3: m space-separated integers, representing the scores of students in section Rose, sorted in ascending order.
Line-4: n space-separated integers, representing the scores of students in section Lotus, sorted in ascending order.

Output Format:
--------------
Line-1: Print a single float representing the median of the combined sorted marks from both sections.

Constraints:
------------
0 ≤ m, n ≤ 1000
The marks of students are in the range 0 ≤ marks ≤ 100.
Time complexity: O(log(min(m + n)))
Space complexity: O(1)

Sample Input-1:
---------------
4
6
32 45 70 95
40 50 59 67 73 84

Sample Output-1:
----------------
63.0

Explanation: The combined sorted marks are: [32, 40, 45, 50, 59, 67, 70, 73, 84, 95].
The median is 63.0.


Sample Input-2:
---------------
5
6
10 20 30 40 50
35 44 60 70 80 90

Sample Output-2:
----------------
44.0

Explanation: The combined sorted marks are: [10, 20, 30, 35, 40, 44, 50, 60, 70, 80, 90].
The median is 44.0.

Sample Input-3:
---------------
4
6
3 6 8 10
14 17 20 33 44 55

Sample Output-3:
-----------------
15.5

Explanation: The combined sorted marks are: [3, 6, 8, 10, 14, 17, 20, 33, 44, 55].
The median is (10 + 14) / 2 = 15.5.


Sample Input-4:
----------------
3
5
50 60 80
7 10 20 30 40

Sample Output-4:
----------------
35.0

Explanation: The combined sorted marks are: [7, 10, 20, 30, 40, 50, 60, 80].
The median is 35.0.
 */
import java.util.Scanner;

public class Day10_SP16_Median_of_Two_SortedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        int[] roseScores = new int[m];
        int[] lotusScores = new int[n];
        
        for (int i = 0; i < m; i++) {
            roseScores[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            lotusScores[i] = scanner.nextInt();
        }
        
        double median = findMedianSortedArrays(roseScores, lotusScores);
        System.out.println(median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
 */