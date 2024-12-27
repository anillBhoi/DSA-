import java.util.ArrayList;
public class CycleDetection {
    static class Edge{
      int src; 
      int dest; 

      Edge(int s, int d){
         this.src = s; 
         this.dest = d; 
      }
   }

   // create graph 

   public static void  createGraph(ArrayList<Edge>graph[]){
      for(int i=0; i<graph.length; i++){
         graph[i] = new ArrayList<Edge>(); 
      }

      // add in graph 
      graph[0].add(new Edge(0,2)); 

      graph[1].add(new Edge(1,0)); 

      graph[2].add(new Edge(2,3));
      
      graph[3].add(new Edge(3,0)); 

   }

      // method for cycle detection 
      public static boolean isCyclic(ArrayList<Edge>graph[], int curr, boolean vis[], boolean rec[]){
       vis[curr] = true;
       rec[curr] = true;

       for(int i=0; i<graph[curr].size(); i++){
        Edge e = graph[curr].get(i);
         // agar neighbour recursion stack ke andar exist karta hai to cycle ki condition hoti hai
        if(rec[e.dest]){   // condition for cycle 
            return true;
        }
        else if(!vis[e.dest]){
            if(isCyclic(graph, e.dest, vis, rec)){
                return true;
            }

        }
       }
       rec[curr] = false; 
       return false; 
      }
    public static void main(String[] args) {
        int v = 4;
               ArrayList<Edge>[] graph = (ArrayList<Edge>[])new  ArrayList[v];
              
              createGraph(graph);
        boolean hasCycle =  isCyclic(graph, 0, new boolean[v], new boolean[v]);
        System.out.println("Does the graph contain a cycle?  "+hasCycle);
    }
}
