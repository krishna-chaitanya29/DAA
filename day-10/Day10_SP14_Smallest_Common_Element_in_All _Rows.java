/*
 * You are given an m x n matrix mat where each row is sorted in non-decreasing order.

Your task is to find the smallest common element in all rows. If there is no common element, return -1.

Input Format:
--------------
Line-1: Two integers m and n, representing the number of rows and columns, respectively.
Line-2: The next m lines contain n space-separated integers each, representing the elements of the matrix. Each row of the matrix is sorted in non-decreasing order.

Output Format:
---------------
Line-1: Print a single integer, the smallest common element in all rows. If no common element exists, print -1.

Constraints:
-------------
1 ≤ m, n ≤ 500
1 ≤ mat[i][j] ≤ 10^4
Each row is sorted in non-decreasing order.

Sample Input-1:
----------------
3 4
1 2 3 4
2 3 5 7
3 5 6 7

Sample Output-1:
-----------------
3

Explanation: The number 3 is the smallest common element in all rows.


Sample Input-2:
---------------
2 3
1 2 3
4 5 6

Sample Output-2:
----------------
-1

Explanation: There is no common element in all rows, so the output is -1.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day10_SP14_Smallest_Common_Element_in_All _Rows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        int[][] mat = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        
        int result = findSmallestCommonElement(mat, m, n);
        System.out.println(result);
    }

    public static int findSmallestCommonElement(int[][] mat, int m, int n) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int j = 0; j < n; j++) {
            frequencyMap.put(mat[0][j], 1);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentNum = mat[i][j];
                if (frequencyMap.containsKey(currentNum) && frequencyMap.get(currentNum) == i) {
                    frequencyMap.put(currentNum, i + 1);
                    if (i == m - 1) {
                        return currentNum;
                    }
                }
            }
        }
        
        int smallestCommon = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == m) {
                smallestCommon = Math.min(smallestCommon, entry.getKey());
            }
        }
        
        return smallestCommon == Integer.MAX_VALUE ? -1 : smallestCommon;
    }
}
 */