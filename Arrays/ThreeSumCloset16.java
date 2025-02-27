// this problem is same as 3sum problem with slightly differance 
import java.util.Arrays;
public class ThreeSumCloset16 {

    public static int closet3Sum(int nums[], int target){  // time complexity is O(n^2)
        // step1 sort the array to use two pointer approach 
        Arrays.sort(nums);
        
        int minDiff = Integer.MAX_VALUE;
        int resultSum =0;

        // loop for taking one element out side and compare rest of all two sum 
        for(int i=0; i<nums.length-2; i++){

            int left = i+1; 
            int right = nums.length-1;

            while(left < right){
               
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == target){
                    return target;
                }
                if(sum < target){
                    left++;
                }else{
                    right--;
                }

                int diffToTarget = Math.abs(sum - target);  // main logic 
                if(diffToTarget < minDiff){
                   
                    resultSum = sum;
                    minDiff = diffToTarget;
                   
                }
            }
        }
        return resultSum;

    }
        
    public static void main(String args[]){
        int nums[] = {-1,2,1,-4};
        int target = 1;
        System.out.println("the closet 3sum of target is : "+closet3Sum(nums, target));
    }
}
