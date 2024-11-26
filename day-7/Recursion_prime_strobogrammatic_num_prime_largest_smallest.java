/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, print all prime strobogrammatic numbers that are of length n 
and print smallest and largest strobogrammatic numbers of length n.

Input Format:
-------------
Line-1: A single integer n, representing the length of the strobogrammatic numbers to generate.

Output Format:
--------------
Line-1: Return a list of all prime strobogrammatic numbers of length n.
Line-2: Space separated two values, smallest and largest strobogrammatic numbers of length n.

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
2

Sample Output-1: 
----------------
[11]
11 96


Sample Input-2:
---------------
5

Sample Output-2: 
----------------
[16091, 18181, 19861, 61819]
10001 99866

Sample Input-3:
---------------
4

Sample Output-3: 
----------------
[]
1001 9966

NOTE: Print the results in sorted order to pass the testcases
 */
import java.util.*;
class Recursion_prime_strobogrammatic_num_prime_largest_smallest {
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
		System.out.println(checkPrime(result));
        High_low(result );
    }
    
    // Main function to find strobogrammatic numbers of length n
    public static List<String> findStrobogrammatic(int n) {
        return buildStrobogrammatic(n, n);
    }

	public static String checkPrime(List<String> result ){
		List<Integer> primeNumList = new ArrayList<>();
	
		for (String num : result) {
			int i=Integer.parseInt(num);  
			if(isPrime(i)){
				primeNumList.add(i);
			}
		}
		return primeNumList.toString();
		
		
	}
	public static void  High_low(List<String> result ){


		
		System.out.println(result.get(0)+" "+result.get(result.size()-1));
		
		
	}
	

	static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
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