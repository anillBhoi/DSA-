import java.util.ArrayList;

public class AllPathsSrcToTarget {
    static class Edge{
      int src;
      int dest;

      // constructor
      public Edge(int s,int d){
         this.src = s; 
         this.dest = d; 
      }
   }

   // Create graph edges and put in Adjacency List 
   public static void createGraph(ArrayList<Edge>graph[]){
      // create each index empty by assinging an empty ArrayList
      
      for(int i=0; i<graph.length; i++){
         graph[i] = new ArrayList<>(); 
      }

     // add neibours of each vertex  

        graph[0].add(new Edge( 0, 1));
        graph[0].add(new Edge( 0, 2));

        graph[1].add(new Edge( 1, 0));
        graph[1].add(new Edge( 1, 3));

        graph[2].add(new Edge( 2, 0));
        graph[2].add(new Edge( 2, 4));

        graph[3].add(new Edge( 3, 1));
        graph[3].add(new Edge( 3, 4));
        graph[3].add(new Edge( 3, 5));

        graph[4].add(new Edge( 4, 2));
        graph[4].add(new Edge( 4, 3));
        graph[4].add(new Edge( 4, 5));

        graph[5].add(new Edge( 5, 3));
        graph[5].add(new Edge( 5, 4));
        graph[5].add(new Edge( 5, 6));

        graph[6].add(new Edge( 6, 5));
   

   }

   // function for Print all path src to target 
   public static void printAllPath(ArrayList<Edge>graph[], boolean visit[], int curr, int target, String path){   //tc = O(v^V)
      // base case 
      if(curr == target){
         System.out.println(path);
         return;
      }

      for(int i=0; i<graph[curr].size(); i++){
         Edge e = graph[curr].get(i);

         // check if the neigbours of curr is allready visited or not 
         if(visit[e.dest] == false){
            visit[curr] = true;
            printAllPath(graph, visit, e.dest, target, path+e.dest);
            visit[curr] = false;
         }
      }
   }



    
    public static void main(String[] args) {
        int v = 7; 
        ArrayList<Edge>graph[] = new ArrayList[v];
  
        createGraph(graph);
        boolean vis[] = new boolean[v];
        int src = 0, target = 5; 
      printAllPath(graph, vis, 0, 5, "0");
        
    }
}
