package discfinal;
import java.util.*;
//Problem3

public class CycleDetector {
    
    private static int count = 0; // Number of cycles
    
    public static void main(String[] args) {
        
        // Read input from scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = sc.nextInt();
        
        // Create and populate the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        System.out.println("Enter the edges (u v): ");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // Perform depth-first search to detect cycles
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i, -1);
            }
        }
        
        // Output results
        System.out.println("Number of cycles: " + count);
        if (count == 0) {
            System.out.println("Graph has no cycle.");
        } else {
            System.out.println("Graph has cycle(s).");
        }
    }
    
    private static void dfs(List<List<Integer>> graph, boolean[] visited, int u, int parent) {
        visited[u] = true; // Mark the current vertex as visited
        for (int v : graph.get(u)) { // Explore the neighbors of the current vertex
            if (!visited[v]) { // If the neighbor has not been visited yet
                dfs(graph, visited, v, u); // Recursively call the dfs method on the neighbor
            } else if (v != parent) { // If the neighbor has been visited and is not the parent of the current vertex
                count++; // Increment the count of cycles
            }
        }
    }
}
