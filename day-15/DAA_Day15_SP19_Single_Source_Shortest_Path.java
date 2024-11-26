/*
 * Given a directed graph represented by an adjacency matrix, where each entry graph[i][j] represents the weight of the edge from vertex i to vertex j. If graph[i][j] is 0, it means there is no direct edge between i and j.

Your task is to determine the shortest paths from a given source vertex to all other vertices using Dijkstra’s algorithm.

Input Format:
-------------
Line-1: An integer N, representing the number of vertices in the graph.
Next-N lines: Each line contains N space-separated integers representing the adjacency matrix graph.
Last-line: An integer src, representing the source vertex.

Output Format:
--------------
A line that says: "Vertex 		Distance from Source".
Followed by N lines, each containing the vertex number and its shortest distance from the source.

Constraints:
------------
*1 <= N <= 100
*0 <= graph[i][j] <= 1000
*0 <= src < N
*All weights are non-negative integers.

Sample Input-1:
---------------
5
0 6 5 0 13
6 0 12 9 5
5 12 0 0 0
0 9 0 0 7
13 5 0 7 0
2

Sample Output-1:
----------------
Vertex           Distance from Source
0                5
1                11
2                0
3                20
4                16

Sample Input-2:
---------------
9
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0
5

Sample Output-2:
----------------
Vertex           Distance from Source
0                11
1                12
2                4
3                11
4                10
5                0
6                2
7                3
8                6
 */
import java.util.*;

public class DAA_Day15_SP19_Single_Source_Shortest_Path{

    // Function to find the vertex with minimum distance value
    static int minDistance(int[] dist, boolean[] visited, int N) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < N; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;//
    }

    // Function that implements Dijkstra's shortest path algorithm
    static void dijkstra(int[][] graph, int src, int N) {
        int[] dist = new int[N]; // dist[i] will hold the shortest distance from src to i
        boolean[] visited = new boolean[N]; // visited[i] will be true if vertex i is processed

        // Initialize all distances as INFINITE and visited[] as false
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        // Distance from source to itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < N - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed
            int u = minDistance(dist, visited, N);

            // Mark the picked vertex as processed
            visited[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex
            for (int v = 0; v < N; v++) {
                // Update dist[v] only if it's not visited, there is an edge from u to v,
                // and the total weight of path from src to v through u is smaller than the current value of dist[v]
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the constructed distance array
        printSolution(dist, N);
    }

    // Function to print the shortest distances from source vertex
    static void printSolution(int[] dist, int N) {
        System.out.println("Vertex           Distance from Source");
        for (int i = 0; i < N; i++) {
            System.out.println(i + "                " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of vertices
        int N = sc.nextInt();

        // Initialize the graph adjacency matrix
        int[][] graph = new int[N][N];

        // Read the graph input
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // Read the source vertex
        int src = sc.nextInt();

        // Call Dijkstra's algorithm
        dijkstra(graph, src, N);

        sc.close();
    }
}
