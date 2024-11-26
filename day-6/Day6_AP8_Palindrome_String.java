/*
 * In your English exam, there is a question that asks you to check whether a given string is a palindrome. Using your programming skills, you need to write a program that prints True if the string is the same when reversed, and False otherwise.

A palindrome is a word, phrase, or sequence that reads the same backward as forward.

Input Format:
--------------
Line-1: A single string str, which may contain lowercase letters.

Output Format:
---------------
Line-1: Print True if the string is a palindrome, otherwise print False.

Constraints:
------------
The string can contain up to 1000 characters.


Sample Input-1: 
---------------
liril

Sample Output-1: 
----------------
True

Sample Input-2: 
---------------
genesis

Sample Output-2: 
----------------
False
 */
import java.util.*;


class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        
        return isPalindrome(str, start + 1, end - 1);
    }
}