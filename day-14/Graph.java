import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class representing the Graph
class Graph {
    // Map to store the adjacency list
    private Map<Integer, List<Integer>> adjList;

    // Constructor to initialize the adjacency list
    public Graph() {
        adjList = new HashMap<>();
    }

    // Method to add a vertex
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Method to add an edge (undirected graph)
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // For undirected graph
    }

    // Method to get neighbors of a vertex
    public List<Integer> getNeighbors(int vertex) {
        return adjList.get(vertex);
    }

    // Method to display the graph
    public void displayGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            for (int neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a new Graph
        Graph graph = new Graph();

        // Add vertices
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        // graph.addEdge(4, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        // Display the graph
        graph.displayGraph();
        System.out.println(graph.getNeighbors(1));
        
    }
}
