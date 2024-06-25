package discfinal;
import java.util.*;
//Problem 1

public class Graph {
    private int V; // number of vertices
    private List<List<Integer>> adj; // adjacency list representation of the graph

    public Graph(int V) { // constructor to initialize the graph with V vertices
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) { // method to add an undirected edge between vertices u and v
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public boolean isConnected() { // method to check if the graph is connected
        boolean[] visited = new boolean[V]; // array to mark visited vertices
        dfs(0, visited); // perform DFS from vertex 0
        for (boolean b : visited) { // check if all vertices are visited
            if (!b) {
                return false; // if any vertex is not visited, the graph is not connected
            }
        }
        return true; // otherwise, the graph is connected
    }

    private void dfs(int v, boolean[] visited) { // recursive method to perform DFS
        visited[v] = true; // mark the current vertex as visited
        for (int u : adj.get(v)) { // visit all neighbors of the current vertex
            if (!visited[u]) { // if a neighbor is not visited, recursively visit it
                dfs(u, visited);
            }
        }
    }

    public int countConnectedComponents() { // method to count the number of connected components in the graph
        int count = 0; // initialize the count to zero
        boolean[] visited = new boolean[V]; // array to mark visited vertices
        for (int i = 0; i < V; i++) { // loop through all vertices
            if (!visited[i]) { // if a vertex is not visited, perform DFS from it and increment the count
                dfs(i, visited);
                count++;
            }
        }
        return count; // return the count of connected components
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // read the number of vertices
        int m = scanner.nextInt(); // read the number of edges
        Graph g = new Graph(n); // create a new graph with n vertices
        for (int i = 0; i < m; i++) { // loop through all edges and add them to the graph
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.addEdge(u, v);
        }
        if (g.isConnected()) { // check if the graph is connected
            System.out.println("The graph is connected");
        } else {
            System.out.println("The graph is not connected");
            System.out.println("Number of connected components: " + g.countConnectedComponents()); // if not, print the number of connected components
        }
    }
}
