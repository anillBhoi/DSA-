import java.util.ArrayList;

public class Dfs {
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

     // function for DFS 
     public static void dfs(ArrayList<Edge>graph[], int curr, boolean vis[]){

        System.out.print(curr+" ");
        vis[curr] = true; 

        // go for curr neighours
        for(int i =0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false){
                dfs(graph, e.dest, vis);
            }
        }

     }

  
    public static void main(String[] args) {
         int v = 7; 
      ArrayList<Edge>graph[] = new ArrayList[v];

      createGraph(graph);
      boolean vis[] = new boolean[v];
      // bfs(graph, v);
      dfs(graph, 0, vis);
      System.out.println();
    }
}
