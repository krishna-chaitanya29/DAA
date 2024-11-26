/*
 * Given an array of strings strs, find the longest common prefix among all strings.

If there is no common prefix, return an empty string "".

NOTE: Solve Using Binary Search

Input Format:
-------------
Line-1: An integer n, the number of strings in the array.
Line-2: The next n lines contain n space-separated strings representing the elements of the string array strs.

Output Format:
--------------
Line-1: Print a single string, which is the longest common prefix among all the strings. If no common prefix exists, print an empty string.

Constraints:
------------
1 ≤ n ≤ 200
0 ≤ strs[i].length ≤ 200
strs[i] consists of only lowercase English letters.


Sample Input-1:
---------------
3
flower flow flight

Sample Output-1:
----------------
fl

Explanation:
The longest common prefix of the strings flower, flow, and flight is "fl".

Sample Input-2:
---------------
3
dog racecar car

Sample Output-2:
----------------
""

Explanation:
There is no common prefix among the input strings.
 */


import java.util.*;
class Day9_SP15_Longest_Common_Prefix{
    public static boolean iscommonprefix(int high,String s[]){
        String check=s[0].substring(0,high);
        
        for(int i=1;i<s.length;i++){
            if(!s[i].startsWith(check)){
                return false;
            }
            
        }
        return true;
    }
    public static String binarySearch(String[] s,int high){
        int low=1;
        while(low<=high){
            int mid=(low+high)/2;
            if(iscommonprefix(mid,s)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
         return s[0].substring(0,(low+high)/2);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] s=new String[n];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        int min=Integer.MAX_VALUE;
        for(String i:s){
            min=Math.min(min,i.length());
        }
    
        String f=binarySearch(s,min);
        System.out.println(f);
        
    }
}
 