import java.util.Scanner;
public class reverse_string {
    public static string reverse(String s,int left, int right){
        if(left<=right){
            char temp = s.charAt(right);
            s[right] = s[left]
            s[left]=temp;
            right--;left++
            return reverse(s, left, right);
        }
        else
        return s;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        System.out.println(reverse(s,int 0,int n));
    }
    
}