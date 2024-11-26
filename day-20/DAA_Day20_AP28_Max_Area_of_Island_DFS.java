<!-- Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5 -->
import java.util.*;

public class DAA_Day20_AP28_Max_Area_of_Island_DFS {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] grid = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        

        int max = 0;

       
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                
                if (grid[i][j] == 1) {
                    int val = dfs(grid, i, j, M, N);
                    max = Math.max(max, val);
                }
            }
        }
        System.out.println(max);
    }

    public static int dfs(int[][] grid, int i, int j, int M, int N) {
        
        if (i < 0 || j < 0 || i >= M || j >= N || grid[i][j] == 0) {
            return 0;
        }

        int size = 1;
        grid[i][j] = 0; 

      
        for (int go = 0; go < 8; go++) {
            size += dfs(grid, i + dx[go], j + dy[go], M, N);
        }
        return size;
    }
}

