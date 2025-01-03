
 
   // @ Strongly Connected Component =>
      // SCC is a componet which we can reach every vertex of the component from every other vertex 
      // in that component. 
       // and it perfom only in directed graph  
       // basically in that we are implementing the reverse dfs 


    // for print scc we use Kosaraju's Algorithm 

    // Kosaraju's Algo ->  tc O(V + E)
            // kosaRaju's algo says we have to perform DFS but reverse DFS.
            // 3 steps to follow in that 
            // Step 1 - Get nodes in stack (topolgical sort )
            // step 2 - transpose the graph (means reverse the edges(direction))
            // step 3 - Do DFS according to stack nodes on the transpose graph
            
            

            import java.util.*;            
public class StronglyConnectedComponentKosaRajusAlgo {
   static class Edge{
      int src; 
      int dest;
            
      Edge(int s, int d){
      this.src = s; 
      this.dest = d; 
                   
      }
   }
            
               // create graph 
               public static void createGraph(ArrayList<Edge>graph[]){
                  for(int i=0; i<graph.length; i++){
                     graph[i] = new ArrayList<Edge>(); 
                  }
            
                  graph[0].add(new Edge(0, 2));
                  graph[0].add(new Edge(0, 3));
            
                  graph[1].add(new Edge(1, 0)); 
            
                  graph[2].add(new Edge(2, 1));
            
                  graph[3].add(new Edge(3, 4));
               }
               public static void topSort(ArrayList<Edge>graph[], int curr, boolean vis[], Stack<Integer>s){
                  // topological sorting ye kahti hai ki noraml dfs perform karo bas jate jate stack ke andar curr ko add kardo 
                  vis[curr] = true; 
                  for(int i=0; i<graph[curr].size(); i++){
                     Edge e = graph[curr].get(i); 
                     // agar neigbour unvisited hai 
                     if(!vis[e.dest]){
                        topSort(graph, e.dest, vis, s);
                     }
                  }
                  s.push(curr); 
               }
               public static void dfs(ArrayList<Edge>graph[], int curr, boolean vis[]){
                  vis[curr] = true; 
                  System.out.print(curr+" ");
                  for(int i=0;i<graph[curr].size(); i++){
                     Edge e  = graph[curr].get(i); 
                     if(!vis[e.dest]){
                        dfs(graph, e.dest, vis);
                     }
                  }
               }
               public static void KosarajuAlgo(ArrayList<Edge>graph[], int v){  // tc O(V+E)
                  // step 1 perform topological sort and store all nodes in stack    O(V+E)  
                  Stack<Integer>s = new Stack<>();
                  boolean vis[] = new boolean[v]; 
                  for(int i=0; i<v; i++){
                     // sare ke sare vertices jo bhi unvisited rah jati hai uske liye topological sorting ko call kar do 
                     // and usko bhi hume store karwa lena hai mujhe stack ke andar 
                     if(!vis[i]){
                        topSort(graph, i, vis,s); 
                     }
                  }
                  // step 2 (create a clone graph in which we store transpose of graph)  O(V+E)
                  ArrayList<Edge>transpose[] = new ArrayList[v]; 
                  for(int i=0; i<graph.length; i++){
                     vis[i] = false;   //reInitialize 
                     transpose[i] = new ArrayList<Edge>();
                  }
                   // ab purane graph par loop laga kar uske edges nikalna hai 
                   for(int i=0; i<v; i++){
                     // find the neighbor of curr node 
                     for(int j=0; j<graph[i].size(); j++ ){
            
                        Edge e = graph[i].get(j);
                           // to change the direction 
                        transpose[e.dest].add(new Edge(e.dest,e.src)); // reverse edge 
                     }
                   }
                   // step 3 jo stack ke andar nodes the unko ak ak karke nikalna hai our dfs ko call karan hai     O(V+E)
            
                   while(!s.isEmpty()){
                     int curr = s.pop(); 
                     if(!vis[curr]){
                      System.out.println("SSC ->");
                        dfs(transpose, curr, vis);
                        System.out.println();
                     }
                   }
               }
   public static void main(String[] args) {
      int v = 5; 
      ArrayList<Edge>graph[] = new ArrayList[v]; 
      createGraph(graph);
      KosarajuAlgo(graph, v);
   }
}            
            