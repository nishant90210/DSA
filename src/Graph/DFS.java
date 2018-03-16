package Graph;

import java.util.LinkedList;

/**
 * Created by NISHANT on 2/15/18.
 */
public class DFS {

    int vertices;
    LinkedList<Integer> adj[];

    public DFS(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {

        DFS dfs = new DFS(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal (starting from vertex 2)");

//        dfs.printDFSStack(2);
        dfs.printDFS(2);

    }

    private void printDFS(int start) {


    }

//    private void printDFSStack(int start) {
//
//        boolean[] visited = new boolean[vertices];
//        LinkedList<Integer> stack = new LinkedList<>();
//        visited[start] = true;
//        stack.add(start);
//        while (!stack.isEmpty()){
//            start = stack.poll();
//            System.out.println(start + "\t");
//            for (int i = 0; i < adj[start].size(); i++) {
//                if (!visited[adj[start].get(i)]){
//                    stack.add(adj[start].get(i));
//                    visited[adj[start].get(i)] = true;
//                }
//            }
//        }
//    }


//    // The function to do DFS traversal. It uses recursive DFSUtil()
//    private void printDFS(int start) {
//
//        // Mark all the vertices as not visited(set as false by default in java)
//        Boolean[] visited = new Boolean[vertices];
//        // Call the recursive helper function to print DFS traversal
//        dfs(start, visited);
//
//    }
//
//    // A function used by printDFS
//    private void dfs(int start, Boolean[] visited) {
//
//        // Mark the current node as visited and print it
//        visited[start] = true;
//        System.out.print(start+" ");
//
//        // Recur for all the vertices adjacent to this vertex
//        Iterator<Integer> i = adj[start].listIterator();
//        while (i.hasNext()) {
//            int n = i.next();
//            if (!visited[n]){
//                dfs(n, visited);
//            }
//        }
//    }

    private void addEdge(int src, int dest) {

        adj[src].add(dest);
    }

}
