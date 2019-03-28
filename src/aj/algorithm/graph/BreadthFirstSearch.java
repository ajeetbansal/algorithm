package aj.algorithm.graph;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ajeet on 3/28/2019.
 */
public class BreadthFirstSearch extends Graph {
    public BreadthFirstSearch(int v) {
        super(v);
    }

    public void bfs(int start) {
        boolean visited[] = new boolean[v];
        Queue<Integer> pending = new LinkedList<Integer>();
        visited[start] = true;
        pending.add(start);
        bfsInternal(pending, visited);
    }

    private void bfsInternal( Queue<Integer> pending, boolean[] visited){
        if(pending.isEmpty())
            return;
        int v = pending.poll();
        System.out.println(v + " ");
        adj[v].stream()
                .forEach(w -> {
                    if(!visited[w]) {
                        visited[w] = true;
                        pending.add(w);
                    }
                });
        bfsInternal(pending, visited);
    }

    public static void main(String[] args) {
        BreadthFirstSearch g = new BreadthFirstSearch(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(2);
    }
}
