package discfinal;
import java.util.Scanner;
//Problem 2

public class EdgeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the number of vertices in the graph from the user
        System.out.print("Enter the number of vertices in the graph: ");
        int n = sc.nextInt();

        int[][] adjMatrix = new int[n][n];

        // Get the adjacency matrix from the user
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = sc.nextInt();
            }
        }

        // Initialize a count array to keep track of the number of times each edge appears
        int[] count = new int[n * (n - 1) / 2];

        int k = 0; // Index for count array
        // Loop through the upper triangle of the matrix (excluding the diagonal)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjMatrix[i][j] == 1) { // If the edge exists
                    count[k]++; // Increment the count for this edge
                }
                k++; // Move to the next index in the count array
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and their counts:");
        k = 0; // Reset the index for count array
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjMatrix[i][j] == 1) { // If the edge exists
                    System.out.printf("(%d, %d): %d\n", i + 1, j + 1, count[k]);
                }
                k++; // Move to the next index in the count array
            }
        }
    }
}
