// leetcode 560
import java.util.HashMap;

class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {   // time complexity is O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0; 
        int cumulativeSum = 0; 

        // Add 0 in the map for corner cases
        map.put(0, 1);  // To handle cases where the cumulative sum itself is equal to k

        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];

            // Check if (cumulativeSum - k) has been seen before
            if (map.containsKey(cumulativeSum - k)) {
                result += map.get(cumulativeSum - k); // Add the count of previous occurrences
            }

            // Update the count of the cumulative sum
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }

        return result;
    }
}
