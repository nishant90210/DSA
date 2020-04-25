package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by NISHANT on 2/15/18.
 */
public class BFS {

    int vertices;
    LinkedList<Integer> adj[];

    public static void main(String[] args) {

        BFS bfs = new BFS(4);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

//        bfs.printGraph(bfs);
        bfs.printBFS(2);
    }

    public BFS(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void printBFS(int start) {

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()){
            start = queue.poll();
            System.out.print(start + "\t");
//            Iterator<Integer> iterator = adj[start].listIterator();
//            while (iterator.hasNext()){
//                Integer next = iterator.next();
//                if (!visited[next]){
//                    visited[next] = true;
//                    queue.add(next);
//                }
//            }
            for (int i = 0; i < adj[start].size(); i++) {
                if (!visited[adj[start].get(i)]){
                    queue.add(adj[start].get(i));
                    visited[adj[start].get(i)] = true;
                }
            }
        }
    }

    private static void printGraph(BFS graph) {

        for (int i = 0; i < graph.adj.length; i++) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head ");
            for (Integer integers : graph.adj[i]) {
                System.out.print("-> " + integers);
            }
            System.out.println("\n");
        }
    }

    private void addEdge(int src, int dest) {

        adj[src].add(dest);
    }
}
