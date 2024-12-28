              
//  # TopoLogical Sorting (imp) =>  in this basically perform dfs and stack 

  // Directed Acyclic graph(DAG) is a directed graph with no cycles.
  // topological sorting is used only for DAGs (Not for non-DAGs) 
  // it is linear order of vertices such that every directed  edge U -> v, 
  // the vertex u comes before v in the order.

   // Fact -> A DAG has at least one vertex with in-degree 0 and one vertex with out-degree 0.
  /*
   * basically wo kaam jiski aur kam pe dependency hai aur wo pahle hona chahiye bad me baki ke kam hone chahiye.
   * for ex - Action 1. Boil water
   *                 2. add masala
   *                 3. add maggie
   *                 4. serve maggie
   * 
   *              1
   *           /     \
   *          2       3
   *           \     /
   *              4
   * 
   * its topological sorting will be -> 1. 1 -> 2 -> 3 -> 4
   *                                    2. 1 -> 3 -> 2 -> 4
   * 
   * 
   * 
   */

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
     static class Edge{
      int src; 
      int dest;

      Edge(int s, int d){
         this.dest = d; 
         this.src = s; 
      }
   }

   public static void createGraph(ArrayList<Edge>graph[]){
      for(int i=0; i<graph.length; i++){
         graph[i] = new ArrayList<Edge>(); 

      }
      graph[2].add(new Edge(2, 3)); 
      graph[3].add(new Edge(3, 1));
      
      graph[4].add(new Edge(4,0));
      graph[4].add(new Edge(4,1));

      graph[5].add(new Edge(5,0));
      graph[5].add(new Edge(5,2));
   }

   // function for top sort 
   public static void topSort(ArrayList<Edge>graph[]){    // tc O(V+E)
        // create a implicit stack 
        Stack<Integer>s = new Stack<>();
        // visited array 
        boolean visited[] = new boolean[graph.length];


        // traverse for each vertex 
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){  // if vertex is never before visited 
                // call for dfs  
                topSortUtil(graph,i,visited,s);
            }
        }

        // remove elements from the stack and print it 
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
   }


   //  function for dfs in topSort
   public static void topSortUtil(ArrayList<Edge>graph[], int curr, boolean vis[], Stack<Integer>s){
      
           vis[curr] = true; 

           // go for neighbours 
           for(int i=0; i<graph[curr].size(); i++){
               Edge e = graph[curr].get(i);
               if(!vis[e.dest]){
                    topSortUtil(graph, e.dest, vis, s);
               }
           }

           s.push(curr);
   }

    public static void main(String[] args) {
        int v = 6; 
        ArrayList<Edge>graph[] = new ArrayList[v]; 
        createGraph(graph);
        topSort(graph);
    }
    
}
