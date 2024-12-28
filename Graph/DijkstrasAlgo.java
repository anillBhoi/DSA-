import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.PipedInputStream;
import java.util.ArrayList;  
// # Shortest Path Algorithm => 


       // 1. Dijkstra's Algorithm => 
          // shortes distance from the source to all vertices 

          public class DijkstrasAlgo{
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
          
                 graph[0].add(new Edge(0,1,2));
                 graph[0].add(new Edge(0,2,4));
          
                 graph[1].add(new Edge(1,3,7));
                 graph[1].add(new Edge(1,2,1));
                
                 graph[2].add(new Edge(2,4,3));
          
                 graph[3].add(new Edge(3,5,1));
          
                 graph[4].add(new Edge(4,3,2));
                 graph[4].add(new Edge(4,5,5));
          
             }
             // pair class 
             public static class Pair implements Comparable<Pair>{  // pahle to comparable ko implement kar diya comparable 
                // ak interface hai java ke andar jo pair ke uper upwork karega yani pair ko comparable type ka banayega 
                // ki comapre ho payenge do pair 
                int node; 
                int dist; 
          
                Pair(int n, int d){
                  this.node = n; 
                  this.dist = d; 
                }
                // ab do pair ko compare hone ke liye uske ke andar ak compare 2 name ka function hona chaiye 
                @Override
                public int compareTo(Pair p2){
                   return this.dist - p2.dist; // ascending 
                   // agar decsending chahiye to 
                   // return p2.dist - this.dist;
          
                }
             }
             public static void Dijkstra(ArrayList<Edge>graph[], int src, int v){  // Tc O(E+ElogV)
               PriorityQueue<Pair>pq = new PriorityQueue<>(); 
               int dist[] = new int[v]; 
               // initialize distance with infinity 
          
               for(int i=0; i<v; i++){
                // agar i ki value not equal to src hai to i ki value infinity initialize kar denge 
                  if( i != src){
                   dist[i] = Integer.MAX_VALUE;
                  }
               }
               boolean vis[] = new boolean[v];
          
               // add first pair in priority queue 
               pq.add(new Pair(0, 0));
               
               // main dijkstra's code which is same as bfs code 
                while(!pq.isEmpty()){
                  Pair curr = pq.remove(); // shortest distance wala pair hum nikalenge 
          
                       if(!vis[curr.node]){
                         vis[curr.node] = true; 
                              // loop for neigbours 
                             for(int i=0; i<graph[curr.node].size(); i++){
                                 Edge e = graph[curr.node].get(i); 
                                 int u = e.src; 
                                 int V = e.dest; 
          
                      // condtion for relaxation 
                        if(dist[u]+e.wt < dist[V]){   // isi step ke vajah se sare ka sare nodes ka distance update hota hai 
                         dist[V] =  dist[u]+e.wt; 
                         //add neigbour in priority Queue 
                         pq.add(new Pair(V, dist[V]));
                      }
                   }
                }
          
               }
          
                 // print nodes 
                 for(int i=0; i<v; i++){
                   System.out.print(dist[i]+" ");
                 }
                 System.out.println();
             }
             public static void main(String[] args) {
                int v = 6; 
                ArrayList<Edge>graph[] = new ArrayList[v]; 
                createGraph(graph);
                Dijkstra(graph, 0, v);
             }
          }          
          
          
          