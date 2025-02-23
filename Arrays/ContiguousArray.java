import java.util.HashMap;

public class ContiguousArray {
    public static int contigousArray(int nums[]){  // time complexity is O(n)
        HashMap<Integer,Integer>map = new HashMap<>();
        // insert 0 in map becos it is a corner case 
        map.put(0,-1);
        int maxLength = 0; 
        int sum = 0; 
        for(int i =0; i<nums.length;i++){
            // find sum 
            sum = sum + ((nums[i]==0) ?-1:1); // here we replace 0 by -1 
            if(map.containsKey(sum)){
                int length = i-map.get(sum);
                maxLength = Math.max(maxLength,length);
            }else{
                map.put(sum,i);
            }
        }
        return maxLength;
    }
     public static void main(String[] args) {
        // int nums[] = {1,1,0,0,1,1,1,0,0,0,0,1,0,0};
        // int nums[] = {0,1,0};
        int nums[] = {0,0,1,0,0,0,1,1};
        System.out.println("the max length of contiguous SubArray is : "+contigousArray(nums));
     }
}
