package aj.algorithm.graph;

/**
 * Created by ajeet on 3/28/2019.
 */
public class DepthFirstSearch extends Graph {
    public DepthFirstSearch(int v) {
        super(v);
    }

    public void dfs(int start) {
        boolean visited[] = new boolean[v];
        dfsInternal(start, visited);
    }

    private void dfsInternal(int v, boolean[] visited){
        if(visited[v])
            return;
        visited[v] = true;
        System.out.println(v + " ");
        adj[v].stream()
                .forEach(w -> dfsInternal(w, visited));
    }

    public static void main(String[] args) {
        DepthFirstSearch g = new DepthFirstSearch(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.dfs(2);
    }
}
