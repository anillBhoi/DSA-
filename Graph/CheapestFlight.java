
   // Q. Cheapest Fligts within k stops 

   /*
    * There are n cities connected by some number of fligts, You are given 
      an array flights where flights[i] = [from,to,price] includes that there is a flight.
      You are also given three integers src,dst,and k, return the cheapest price form src to dest with
      at most k stops. If there is no such route, return -1
      (all values are positive)
      ex - flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]
      src = 0, dst = 3, k=1
    */


    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.Queue;
    public class CheapestFlight{
        static class Edge{
           int src; 
           int dest; 
           int wt; 
  
           public Edge(int s, int d, int wt){
              this.src = s; 
              this.dest = d; 
              this.wt = wt; 
           }
        }
  
        public static void createGraph(int flights[][],ArrayList<Edge>graph[]){
           // initialize the Array with empty
           for(int i=0; i<graph.length; i++){
              graph[i] = new ArrayList<Edge>();
           }
  
           // create loop on flight and in that where edge is exist then there create one edge
           for(int i=0; i<flights.length; i++){
              int src = flights[i][0];
              int dest = flights[i][1];
              int wt = flights[i][2];
  
              Edge e = new Edge(src,dest,wt);
              graph[src].add(e);
  
  
           } 
        }
  
        static class Info{
           int vertex;
           int cost; 
           int stops; 
  
           public Info(int v, int c, int s){
              this.vertex = v; 
              this.cost = c; 
              this.stops = s; 
           }
        }
  
        // function for cheapest flight 
        public static int cheapestFlight(int n, int flight[][], int src, int dest, int k){
           ArrayList<Edge>graph[] = new ArrayList[n];
           createGraph(flight, graph);
  
           int dist[] = new int[n];
           for(int i=0; i<n; i++){
              if(i != src){
                 dist[i] = Integer.MAX_VALUE;
              }
           }
          // here priorityQueue is not required becos the Info is being storing in sorted order due to k stops 
          // becos when it goes next vertex it autmatically increase the stop by 1 so there is no required of priorityQueue
           Queue<Info>q = new LinkedList<>();
           q.add(new Info(src, 0, 0));
  
           while(!q.isEmpty()){
              Info curr = q.remove();
               if(curr.stops > k){  // agar q me stops k se jyada hai to aage dekhani ki jaroorat hi nhi hai wahi se break karna hai 
                 break;
               }
               // go for neighbours 
               for(int i=0; i<graph[curr.vertex].size(); i++){
                 Edge e = graph[curr.vertex].get(i);
                 int u = e.src;
                 int v = e.dest; 
                 int wt = e.wt; 
  
                 // relaxation step 
                 // in this step we dont use dist[u]  here we use curr.cost means we dont compare the global cost of u we have to compare only curr cost 
                 // curr.cost isliye kyoki jis raste se hum pahuch rahe hai hame usika cost dekhana hai na ki final cost  
                 if( curr.cost+wt < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost+wt;
                    q.add(new Info(v,dist[v] , curr.stops+1));
                 } 
               }
           }
  
           // finaly return dest ka distance kitna aaya hai 
           if(dist[dest] == Integer.MAX_VALUE){
              return -1; 
           }else{
              return dist[dest];
           }
        }
        public static void main(String[] args) {
           int n = 4; 
           int flight[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
           int src = 0, dst = 3, k = 1;
           System.out.println(cheapestFlight(n, flight, src, dst, k));
          
        }
      }
  
