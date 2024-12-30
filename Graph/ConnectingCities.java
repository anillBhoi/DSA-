
   //Q. Connecting cities with Minumum Cost 
        // find the minimum cost of connecting all cities on the map.

        import java.util.PriorityQueue;
        public class ConnectingCities{
            static class Edge implements Comparable<Edge>{
              int dest; 
              int cost; 
  
              public Edge(int d, int cost ){
                this.dest = d; 
                this.cost = cost;
              }
  
              @Override
              public int compareTo(Edge e2){
                return this.cost - e2.cost; // compare in ascending order 
              }
  
            }
  
            public static int connectCities(int cities[][]){   // tc is same as prims algo which is tc O(ElogE)
              // pq for track which edges being tracked 
              PriorityQueue<Edge>pq = new PriorityQueue<>();
  
              boolean vis[] = new boolean[cities.length];
  
              pq.add(new Edge(0,0));
              int finalCost = 0; 
  
              // prims algo
              while(!pq.isEmpty()){
                Edge curr = pq.remove();
                if(!vis[curr.dest]){
                  vis[curr.dest] = true; 
                  finalCost += curr.cost;
              
                    // loop for neigjbours
                    for(int i=0; i<cities[curr.dest].length; i++){
                      if(cities[curr.dest][i] != 0){  // edge not exist where 0 is present
                        pq.add(new Edge(i, cities[curr.dest][i]));
  
                      }
                    }
  
                }
              }
              return finalCost; 
            }
            public static void main(String[] args) {
              int cities[][] = {{0,1,2,3,4},
                                {1,0,5,0,7},
                                {2,5,0,6,0},
                                {3,0,6,0,0},
                                {4,7,0,0,0}};
                                System.out.println("the final cost is : "+connectCities(cities));
            }
          }
  
          
  
