package discfinal;
import java.util.Scanner;
//Problem6

public class AdjacencyMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices in the graph: ");
        int vertices = scanner.nextInt();

        int[][] adjacencyMatrix = new int[vertices][vertices];
        // Initialize the adjacency matrix with 0 for all edges.
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }

        System.out.print("Enter the number of edges in the graph: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (vertex pairs):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            // Check if it's a directed graph or undirected graph
            System.out.print("Is the graph directed? (y/n): ");
            String directed = scanner.next();
            // Check if it has multiple edges or loops
            System.out.print("Does it have multiple edges or loops? (y/n): ");
            String multipleEdges = scanner.next();

            // If it's an undirected graph, mark both edges
            if (directed.equalsIgnoreCase("n")) {
                if (multipleEdges.equalsIgnoreCase("n")) {
                    adjacencyMatrix[source][destination] = 1;
                    adjacencyMatrix[destination][source] = 1;
                } else {
                    adjacencyMatrix[source][destination]++;
                    adjacencyMatrix[destination][source]++;
                }
            }
            // If it's a directed graph, mark only one edge
            else {
                if (multipleEdges.equalsIgnoreCase("n")) {
                    adjacencyMatrix[source][destination] = 1;
                } else {
                    adjacencyMatrix[source][destination]++;
                }
            }
        }

        // Print the adjacency matrix
        System.out.println("The adjacency matrix for the given graph is: ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
