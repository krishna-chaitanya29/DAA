/*
 * 
 */
import java.util.*;

public class Recursion_strobogrammatic_number_prime_number {
    // Define pairs of valid strobogrammatic digit pairs
    private static final char[][] PAIRS = {
        {'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        
        List<String> result = findStrobogrammatic(count(n));
        Collections.sort(result); // Sort the result to pass the test cases
        System.out.println(result);
    }
    public static int count(int n ){
        int count =1;
        while(n>0){
            n = n/10;

            count++;
        }
        return count;
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
