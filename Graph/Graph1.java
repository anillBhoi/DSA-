//create a graph from scratch using Adjacency List (Array of ArrayList)

import java.util.ArrayList;
public class Graph1 {

    // Edge class
    static class Edge{
        int src; 
        int dest; 

        // constructor for initializing 
        Edge(int s, int d){
            this.src = s;
            this.dest = d; 
        }
    }

    // function for adding the vertices in Array of ArrayList
    public static void createGraph(ArrayList<Edge>graph[]){
        // initialize the array by new Empty arrayList
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        // add vertices in arrayList
        graph[0].add(new Edge(0, 1));

        graph[1].add(new Edge(0, 1));
        graph[1].add(new Edge(0, 1));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));

        
 
    }

    public static void main(String args[]){
        int v = 4;
        ArrayList<Edge>graph[] = new ArrayList[v];
        createGraph(graph);
        
        // print the 2's neighbour
        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest+" ");
        }
    }

}
