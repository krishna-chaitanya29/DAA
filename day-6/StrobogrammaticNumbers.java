/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, return all strobogrammatic numbers that are of length n.

Input Format:
-------------
Line-1: A single integer n, representing the length of the strobogrammatic numbers to generate.

Output Format:
--------------
line-1: Return a list of all strobogrammatic numbers of length n. The list can be in any order.

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
2

Sample Output-1: 
----------------
[11, 69, 88, 96]

Explanation:
-------------
All valid strobogrammatic numbers of length 2 are:
11: Rotates to 11
69: Rotates to 96
88: Rotates to 88
96: Rotates to 69

Sample Input-2:
---------------
1

Sample Output-2: 
----------------
[0, 1, 8]

Explanation:
------------
The strobogrammatic numbers of length 1 are:
0: Rotates to 0
1: Rotates to 1
8: Rotates to 8

NOTE: Print the results in sorted order to pass the testcases
 */

 import java.util.*;

public class StrobogrammaticNumbers {
    
    // Define pairs of valid strobogrammatic digit pairs
    private static final char[][] PAIRS = {
        {'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        List<String> result = findStrobogrammatic(n);
        Collections.sort(result); // Sort the result to pass the test cases
        System.out.println(result);
    }
    
    // Main function to find strobogrammatic numbers of length n
    public static List<String> findStrobogrammatic(int n) {
        return buildStrobogrammatic(n, n);
    }

    // Recursive function to build the strobogrammatic numbers
    private static List<String> buildStrobogrammatic(int n, int targetLength) {
        // Base cases
        if (n == 0) {
            return new ArrayList<>(Collections.singletonList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        
        // Recursively generate strobogrammatic numbers of length n-2
        List<String> prevList = buildStrobogrammatic(n - 2, targetLength);
        List<String> result = new ArrayList<>();
        
        // Add pairs of strobogrammatic digits around the smaller numbers generated
        for (String s : prevList) {
            for (char[] pair : PAIRS) {
                // Skip numbers starting with 0 unless it's the only digit
                if (pair[0] == '0' && n == targetLength) {
                    continue;
                }
                result.add(pair[0] + s + pair[1]);
            }
        }
        return result;
    }
}
