   // @ Minimum spanning tree (MST) => 

   // a minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected
   // edge-weighted undirected graph that connects all the vertices together, without any cycles and with the 
   // minimum possible total edge-weight.
   
   // (yah ak aisa graph hota hai jiske andar cycle hut jate hai )
   // minimum spanning tree wo hota hai jisme edge weight minimum ho 


   // To calculte MST we use prim's Algorithm 
   
   import java.util.ArrayList; 
   import java.util.PriorityQueue; 
   public class MstPrimsAlgo{
      static class Edge{
         int src;
         int dest; 
         int wt; 

         Edge(int s, int d, int w){
            this.src = s; 
            this.dest = d; 
            this.wt = w; 
         }
      }

      // create graph 
      public static void createGraph(ArrayList<Edge>graph[]){
         for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>(); 
         }

        graph[0].add(new Edge(0, 1, 10));
         graph[0].add(new Edge(0, 2, 15));
         graph[0].add(new Edge(0, 3, 30));

         graph[1].add(new Edge(1, 0, 10));
         graph[1].add(new Edge(1, 3, 40));

         graph[2].add(new Edge(2, 0, 15));
         graph[2].add(new Edge(2, 3, 50));

         graph[3].add(new Edge(3, 1, 40));
         graph[3].add(new Edge(3, 2, 50));
   
      }

      // class for Pair 
      public static class Pair implements Comparable<Pair>{
         // agar kisi bhi class ke objects ko sorting karana hota hai ya usme define karana hota hai ki kis bases
         // pe compare ho ak dusare se to hum implement karte hai comparable interface ko 
          int node; 
          int cost; 

          Pair(int n, int c){
            this.node = n; 
            this.cost = c; 
          }

          @Override
          public int compareTo(Pair p2){
            return this.cost - p2.cost;   // ascending order
          }
      }

      public static void primsAlgo(ArrayList<Edge>graph[],int v){  //tc O(ElogE)
         PriorityQueue<Pair>pq = new PriorityQueue<>(); // ye ak tarh ka non-mst set hai 
         boolean vis[] = new boolean[v]; // ye mst set hai 
         pq.add(new Pair(0, 0)); 

         int mstCost = 0; 
         while(!pq.isEmpty()){
            Pair curr = pq.remove(); 
            if(!vis[curr.node]){
               vis[curr.node] = true; 
                mstCost += curr.cost; 

                // loop for neigbours 
                for(int i=0; i<graph[curr.node].size(); i++){
                  Edge e = graph[curr.node].get(i); 
                  if(!vis[e.dest]){
                     pq.add(new Pair(e.dest, e.wt));

                     
                  }
               }
            }

         }
         System.out.println("minimum cost of mst is : "+mstCost);

      }
      public static void main(String[] args) {
         int v = 4; 
         ArrayList<Edge>graph[] = new ArrayList[v]; 
          createGraph(graph);
          primsAlgo(graph,v);


      }
   }

