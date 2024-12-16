package Arrays;

// Grind 75          

//#Day 1            LeetCode #1

// Approach ->
    // use HashMap 
       //1.find the peer in map of that target sum doing subtraction from target 

import java.util.HashMap;
public class TwoSum01 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }else{
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
