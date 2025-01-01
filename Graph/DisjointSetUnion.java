  // #. Disjoint Set Data Structure 

   /*
    * we can say it as union find ds and merge ds also
      it has basically perform two operation Find operation and Union operation 
      why we use this ds -> to store and track non-overlapping sets 
    */


    public class DisjointSetUnion{
        static int n=7; 
        static  int par[] = new int[n];
        static int rank[] = new int[n];
  
        // in this function we initialize the all arrays
        public static void initialize(){
          // parent initialize 
          for(int i=0; i<n; i++){
            par[i] = i; 
          }
         
        }
  
        // find function 
        public static int find(int x){ // in that we find our final leader
               if(x == par[x]){  // final leader wo hota hai jisme mera x = par[x] ke equal hi hota hai 
                 return x; 
               }
  
               // agar nahi hota to dobara se call lagao apne final leader ke liye 
  
               return par[x] = find(par[x]);
  
        }
  
        
        // union function 
        public static void union(int a, int b){
          int parA = find(a);  // it finds parent of a
          int parB = find(b); // it finds the parent of b 
  
          if(rank[parA] == rank[parB]){  // agar dono ke rank equal ho to kisi ko bhi parent bana sakte hai 
            par[parB] = parA; // here b jo hai a ke sath jud gaya hai parent ke sath
            rank[parA]++; // here rank will increase 
          } else if(rank[parA] < rank[parB]){
            par[parA] = parB;
          }else{
            par[parB] = parA;
          }
        }
        public static void main(String[] args) {
          initialize();
          union(1, 3);
          System.out.println(find(3));
          union(2, 4);
          union(3, 6);
          union(1, 4);
          System.out.println(find(3));
          System.out.println(find(4));
          union(1, 5);
  
        }
      }
  