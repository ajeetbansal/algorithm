package aj.algorithm.graph;

// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPath
{
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V=9;

    // A utility function to print the constructed distance array
    void printSolution(ArrayList<Integer> dist, int n)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t "+dist.get(i));
    }

    // Funtion that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src)
    {
        ArrayList<Integer> distList = new ArrayList<Integer>(V);
        Set<Integer> spSet = new HashSet<Integer>();

        for(int i=0;i < V; i++) {
                distList.add(Integer.MAX_VALUE);
        }
        distList.set(src, 0);

        for(int j=0; j< V ; j++) {
            int nextV = minDistance(spSet, distList);
            spSet.add(nextV);

            for (int i = 0; i < V; i++) {
                if (!spSet.contains(i) &&
                        graph[nextV][i] != 0 &&
                        distList.get(nextV) + graph[nextV][i] < distList.get(i)) {
                    distList.set(i, distList.get(nextV) + graph[nextV][i]);
                }
            }
        }
        // print the constructed distance array
        printSolution(distList, V);
    }

    private int minDistance(Set<Integer> spSet, ArrayList<Integer> distList) {
        int minDist = Integer.MAX_VALUE;
        int minVertex = -1;
        for(int i=0; i< V; i++) {
            if(!spSet.contains(i) && distList.get(i) < minDist) {
                minVertex = i;
                minDist = distList.get(i);
            }
        }
        return minVertex;
    }


    // Driver method
    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}
//This code is contributed by Aakash Hasija
