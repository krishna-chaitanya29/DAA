// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void printBoard(int[][] board){
        int n = board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public static boolean isSafe(int[][] board , int row , int col, int N){
        for(int i=col;i>=0;i--){
            if(board[row][i]==1){
                return false;
            }
        }
        for(int i=row,j=col ;i>=0 && j>=0 ; j--,i--){
            if(board[i][j]==1){
                return false;
            }
        }
        for(int i=row,j=col ;i<N && j>=0 ; j--,i++){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }
    public static boolean placeQueen(int[][] board , int col , int N){
        if(col==N){
            return true;
        }
        for(int row=0;row<N;row++){
            if(isSafe(board,row,col,N)){
                board[row][col]=1;
                if(placeQueen(board,col+1,N)){
                    return true;
                }
                board[row][col]=0;
            }
        }
        return false;
    }
    public static void SolveNQ(int N){
        int[][] board = new int[N][N];
        if(placeQueen(board,0,N)){
            printBoard(board);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SolveNQ(N);
    }
}