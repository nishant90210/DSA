package Graph;

import java.util.LinkedList;

/**
 * Created by NISHANT on 2/15/18.
 */
public class GraphImpl {

    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices in graph)
    static class Graph {

        int vertices;
        LinkedList<Integer> adjListArray[];

        // constructor
        public Graph(int vertices) {
            this.vertices = vertices;

            // define the size of array as
            // number of vertices
            adjListArray = new LinkedList[vertices];

            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            for (int i = 0; i < vertices; i++) {
                 adjListArray[i] = new LinkedList<>();
            }
        }
    }

    // Adds an edge to an undirected graph
    private static void addEdge(Graph graph, int src, int dest) {

        // Add an edge from src to dest.
        graph.adjListArray[src].addFirst(dest);
        // Since graph is undirected, add an edge from dest to src also
        graph.adjListArray[dest].addFirst(src);
    }

    // A utility function to print the adjacency list representation of graph
    private static void printGraph(Graph graph) {

        for (int i = 0; i < graph.adjListArray.length; i++) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head ");
            for (Integer integers : graph.adjListArray[i]) {
                System.out.print("-> " + integers);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {

        int vertices = 5;
        Graph graph = new Graph(vertices);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        // print the adjacency list representation of the above graph
        printGraph(graph);
    }
}
