
// 2. Bellman Ford Algorithm =>  tc (V.E)
             // (Shortest distance from src to all vertices )

   // Dijkstra's algo negative weight me work nhi karata but Bellaman Ford Algorithm sare cases me work karta hai
   // Dijkstra's algo greedy technique pe kam karta hai aur Bellaman ford Dp pe kam karata hai
   // time complexity of Dijkstra's algo is less than Bellman ford. bellman ford take more time complexity 
   
   // in this algorithm we have to perform this operation v-1 times 
   // for all edges(u,v)
   //if dist[u] +wt[u,v] < dist[v]
   // dist[v] =  dist[u] +wt[u,v] 


   // BFA doesnt work for Negative weight cycles



   import java.util.ArrayList;
   public class BellmanFordAlgo{

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

      public static void createGraph(ArrayList<Edge>graph[]){
         for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>(); 
         }

         graph[0].add(new Edge(0, 1, 2)); 
         graph[0].add(new Edge(0, 2, 4));
         
         graph[1].add(new Edge(1, 2, -4));
         
         graph[2].add(new Edge(2, 3, 2)); 

         graph[3].add(new Edge(3, 4, 4));
         
         graph[4].add(new Edge(4, 1, -1)); 
      }

      // bellman ford 
      public static void bellmanFord(ArrayList<Edge>graph[],int src, int v){
         int dist[] = new int[v]; 
         for(int i=0; i<v; i++){
            if( i != src){
               dist[i] = Integer.MAX_VALUE; 
            }
         }
         // bellman ford kahata hai sabse bahar walla loop v-1 time chalega 
         for(int k=0; k<v-1; k++){  //tc O(V)
            // inner loop me sare edges par loop lagana hota hai (kyoki sare edges nikalna hota hai )
            for(int i=0; i<v; i++){  // tc O(E)
               for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j); 

                int u = e.src;
                int V = e.dest; 
                
                // perform relaxation 
                if(dist[u] != Integer.MAX_VALUE &&   dist[u] +e.wt < dist[V]){  // normal math ke andar to agar hum 
                  // infinity me koi number add kar de to wo aur bhi bada number hota hai lekin java ke andar aisa nhi hota 
                  // java ke andar kisi positive value ko infinity ke andar add kar diya to us case me aap ki value choti ho jayegi 
                  // yani negatve ho jayegi aur negative value to hamesha hi sare ke sare value se choti hoti hai  
                  dist[V] = dist[u] +e.wt;
                }
               }
            }
         }
         // detect negative wt cycles 
         for(int i=0; i<v; i++){  // tc O(E)
            for(int j=0; j<graph[i].size(); j++){
             Edge e = graph[i].get(j); 

             int u = e.src;
             int V = e.dest; 
             
             // perform relaxation 
             if(dist[u] != Integer.MAX_VALUE &&   dist[u] +e.wt < dist[V]){  // normal math ke andar to agar hum 
               // infinity me koi number add kar de to wo aur bhi bada number hota hai lekin java ke andar aisa nhi hota 
               // java ke andar kisi positive value ko infinity ke andar add kar diya to us case me aap ki value choti ho jayegi 
               // yani negatve ho jayegi aur negative value to hamesha hi sare ke sare value se choti hoti hai  
               System.out.println("negatice wt cycle ");
             }
            }
         }


         // print all the distance 
         for(int i=0; i<dist.length; i++){
           System.out.print(dist[i]+" "); 
         }
         System.out.println();
      }
      public static void main(String[] args) {
         int v = 5; 
         ArrayList<Edge>graph[] = new ArrayList[v]; 
         createGraph(graph);
         bellmanFord(graph, 0, v);
      }
   }



