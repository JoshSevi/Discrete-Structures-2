package discfinal;
import java.util.*;
//problem4

public class GraphDegreeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read in the edges of the graph
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter edge " + (i+1) + ": ");
            int[] edge = new int[2];
            edge[0] = scanner.nextInt();
            edge[1] = scanner.nextInt();
            edges.add(edge);
        }
        
        // Compute the degree of each vertex
        Map<Integer, Integer> degreeMap = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            degreeMap.put(u, degreeMap.getOrDefault(u, 0) + 1);
            degreeMap.put(v, degreeMap.getOrDefault(v, 0) + 1);
        }
        
        // Output the degree of each vertex
        System.out.println("Vertex Degrees:");
        for (int vertex : degreeMap.keySet()) {
            int degree = degreeMap.get(vertex);
            System.out.println(vertex + ": " + degree);
        }
    }
}
