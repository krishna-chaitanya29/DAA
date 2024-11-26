import java.util.*;
public class shorest {
    public static int min(int[] dist , boolean[] vis , int V){
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if(!vis[i] && dist[i]<min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    static void printSolution(int[] dist, int V) {
        System.out.println("Vertex           Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "                " + dist[i]);
        }
    }
    public static void algo(int[][] g , int V , int src){
        int[] dist = new int[V];
        boolean[] vis = new boolean[V]; 
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(vis,false);

        dist[src] = 0;
        for(int c=0;c<V-1;c++){
            int u = min(dist , vis , V);
            vis[u] = true;
            for (int v = 0; v < V; v++) {
                if(!vis[v] && g[u][v]!= 0 && dist[u] != Integer.MAX_VALUE && dist[u] + g[u][v] < dist[v]){
                    dist[v] = dist[u] + g[u][v];
                }
            }
        }
        printSolution(dist, V);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in
        
        System.out.println("Vertex");
        int V = sc.nextInt();
        System.out.println("Graph");
        int[][] graph = new int[V][V];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println("Src");
        int src =sc.nextInt();
        algo(graph , V , src);
    }
}