package aj.algorithm.graph;

import java.util.LinkedList;

/**
 * Created by ajeet on 3/28/2019.
 */
public class Graph {
    protected int v;
    protected LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
    }
    public void addEdge(int v, int w) {
        if(adj[v] == null){
            adj[v] = new LinkedList<Integer>();
        }
        adj[v].add(w);
    }
}
