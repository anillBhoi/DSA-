package Arrays;

// Grind 75   


//#Day 3            LeetCode #57

// Approach ->
   // situation
     //1. if(intervals[i][1] < newInterval[0]) then we add interval[i] in result becos there is no any connection 
     // or relation in that interval becos newInterval[0] means start of newInterval is greater than end of that interval 

     //2. if(intervals[i][0] > newInterval[1]) then we break here becos there is no chance to go further becos it is sorted 

     //3.Merge 



  // tc -> O(n)
  // sc -> O(n)
  
  import java.util.*;
 class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
 
        int i = 0; 
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();

        while(i<n){
           //1.step 
           if(intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
           } 
           // 2.step
           else if(intervals[i][0] > newInterval[1]){
            break;
           }
           // 3 step Merge
           else{
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
           }

           i++;
        }

        // add newInterval
        result.add(newInterval);
        // now add all the remaining intervals further
        while(i<n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}    

    
   