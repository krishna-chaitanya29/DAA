/*
 * A school kid named John Doe, wants to find the value of N^P
Pth power of a number N.

You will be given two integers N and P.
Your task is to help John Doe to find the value of N^P.

NOTE:
---------
Value of N and P can be both positive and negative

Input Format:
-------------
Line-1: Two integers N and P, where N is the number and P is the power

Output Format:
--------------
Line-1: Print a float number, N power P


Sample Input-1:
---------------
3 2

Sample Output-1:
----------------
9.000000


Sample Input-2:
---------------
2 -3

Sample Output-2:
----------------
0.125000
 */
import java.util.*;

public class Power_calculation{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        float n=sc.nextFloat();
        int p=sc.nextInt();
        System.out.print(solve(n,p));
    }
    public static float solve(float n, int p) {
        if(p==0) {
            return 1;
        }
        if(p<0) {
            n=1/n;
            p=-p;
        }
        float temp=solve(n,p/2);
        float res=temp*temp;
        if(p%2!=0) {
            return res*n;
        }
        return res;
    }
}
 */