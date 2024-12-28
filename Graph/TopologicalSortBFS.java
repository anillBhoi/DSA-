// # Topological Sort using BFS ->

        // Fact -> A DAG has at least one vertex with in-degree 0 and one vertex with out-degree 0.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
    
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

   // function for calculate inDegree 
   public static void inDegree(ArrayList<Edge>graph[], int inDeg[]){
      for(int i=0; i<graph.length; i++){
         int v = i; 
         for(int j=0; j<graph[v].size(); j++){
            Edge e = graph[v].get(j);
            inDeg[e.dest]++;
         }
      }
   }

   // function for topSort using bfs

   public static void topSort(ArrayList<Edge> graph[]){
      int indeg[] = new int[graph.length];
      inDegree(graph, indeg);
     Queue<Integer>q = new LinkedList<>();

     for(int i=0; i<indeg.length; i++){
      if(indeg[i] == 0){
         q.add(i);
      }
     }

     //bfs 
     while(!q.isEmpty()){
       int curr = q.remove();
       System.out.print(curr+" ");

       for(int i=0; i<graph[curr].size(); i++){
         Edge e = graph[curr].get(i);
         indeg[e.dest]--;
         if(indeg[e.dest] == 0){
            q.add(e.dest);
         }
       }
     }
     System.out.println();
   }

   public static void main(String[] args) {
      int v = 6; 
      ArrayList<Edge>graph[] = new ArrayList[v]; 
      createGraph(graph);
      topSort(graph);
   }
} 
