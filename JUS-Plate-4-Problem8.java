package discfinal;
import java.util.*;
//Problem8

public class GraphIsomorphism {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Get the number of vertices in the graphs
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        
        // Create the adjacency matrices for the two graphs
        int[][] graph1 = new int[n][n];
        int[][] graph2 = new int[n][n];
        
        // Get the adjacency matrix for the first graph
        System.out.println("Enter the adjacency matrix for the first graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph1[i][j] = sc.nextInt();
            }
        }
        
        // Get the adjacency matrix for the second graph
        System.out.println("Enter the adjacency matrix for the second graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph2[i][j] = sc.nextInt();
            }
        }
        
        // Check if the two graphs are isomorphic
        if (isIsomorphic(graph1, graph2)) {
            System.out.println("The two graphs are isomorphic.");
        } else {
            System.out.println("The two graphs are not isomorphic.");
        }
        
        sc.close();
    }
    
    // Check if two graphs are isomorphic
    public static boolean isIsomorphic(int[][] graph1, int[][] graph2) {
        int n = graph1.length;
        
        // If the number of vertices in the graphs are different, they cannot be isomorphic
        if (n != graph2.length) {
            return false;
        }
        
        // Try all possible permutations of vertices
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        do {
            // Check if the adjacency matrices are equal after permuting the vertices
            int[][] permutedGraph1 = permuteVertices(graph1, perm);
            if (Arrays.deepEquals(permutedGraph1, graph2)) {
                return true;
            }
        } while (nextPermutation(perm));
        
        return false;
    }
    
    // Permutes the vertices in a graph according to a permutation
    public static int[][] permuteVertices(int[][] graph, int[] perm) {
        int n = graph.length;
        int[][] permutedGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                permutedGraph[perm[i]][perm[j]] = graph[i][j];
            }
        }
        return permutedGraph;
    }
    
    // Gets the next lexicographic permutation of an array
    public static boolean nextPermutation(int[] array) {
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = array.length - 1;
        while (array[j] <= array[i]) {
            j--;
        }
        swap(array, i, j);
        reverse(array, i + 1, array.length - 1);
        return true;
    }
    
    // Swaps two elements in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // Reverses the elements in an array between start and end (inclusive)
    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }
}    