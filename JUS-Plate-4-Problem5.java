package discfinal;
import java.util.*;
//Problem5

public class BipartiteGraph {

    // DFS algorithm to check if the graph is bipartite
    static boolean checkBipartite(int V, List<List<Integer>> edges) {
        int[] colors = new int[V];
        Arrays.fill(colors, -1);

        // Check each component of the graph
        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, colors, edges)) {
                    return false;
                }
            }
        }
        return true;
    }

// DFS helper method
    static boolean dfs(int u, int color, int[] colors, List<List<Integer>> edges) {
        colors[u] = color;
        for (int v : edges.get(u)) {
            if (colors[v] == -1) {
                if (!dfs(v, 1 - color, colors, edges)) {
                    return false;
                }
            } else if (colors[v] == color) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the input
        System.out.print("Enter the number of vertices in the graph: ");
        int V = sc.nextInt();

        System.out.print("Enter the number of edges in the graph: ");
        int E = sc.nextInt();

        // Create an adjacency list to store the edges
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            edges.add(new ArrayList<>());
        }

        // Read the edges and store them in the adjacency list
        System.out.println("Enter the edges of the graph (0-indexed):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        // Check if the graph is bipartite
        if (checkBipartite(V, edges)) {
            System.out.println("The given graph is bipartite");
        } else {
            System.out.println("The given graph is not bipartite");
        }
    }
}
