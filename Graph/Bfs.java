import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Bfs {
    // create Edge class 
    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s; 
            this.dest = d;
        }
    }

    // function for creating graph 
    public static void createGraph(ArrayList<Edge>graph[]){
        // initialize the every place of array with an empty ArrayList
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        // add all the src and dest 
        graph[0].add(new Edge(0, 1));
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

    // function for BFS(Breadth first search)
    public static void bfs(ArrayList<Edge>graph[], int v){    // tc O(V+E)
        
        // create a queue 
        Queue<Integer>q = new LinkedList<>();

        // create an boolean array to track each vertex 
        boolean visited[] = new boolean[v];
        
        // add the first in q
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(visited[curr] == false){  // never before visited 
                
              System.out.print(curr+" ");
              visited[curr] = true;

              // add curr neighours also in queue to visit 
              for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                q.add(e.dest);
              }
            }
        }

    }
    public static void main(String[] args) {
        int v = 7; 
        ArrayList<Edge>graph[] = new ArrayList[v];
        createGraph(graph);
        bfs(graph, v);
    }
}
