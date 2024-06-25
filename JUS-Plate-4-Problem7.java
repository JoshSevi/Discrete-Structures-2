package discfinal;
import java.util.*;
//Problem7

public class IncidenceMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         // get number of vertices and edges from user
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];

        // get vertex pairs and number of times each edge appears from user
        for (int i = 0; i < m; i++) {
            System.out.print("Enter the vertex pair for edge " + (i+1) + ": ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            System.out.print("Enter the number of times edge " + (i+1) + " appears: ");
            int count = sc.nextInt();

            // update incidence matrix for edge
            matrix[u-1][i] = count;
            matrix[v-1][i] = count;
        }

        // print incidence matrix
        System.out.println("The incidence matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
