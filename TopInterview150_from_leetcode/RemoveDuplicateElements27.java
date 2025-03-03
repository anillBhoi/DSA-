
// time complexity is O(n)
public class RemoveDuplicateElements27 {
    public int removeElement(int[] nums, int val) {
        int i=0; 
        int j = 0; 
        while(i < nums.length){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
            i += 1;
        }
        return j;
    }
}
