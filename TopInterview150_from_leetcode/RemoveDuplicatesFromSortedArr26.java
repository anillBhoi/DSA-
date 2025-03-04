public class RemoveDuplicatesFromSortedArr26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i = 1; 
        int j = 0; 
        while(i < nums.length){
            if(nums[i] != nums[j]){
                 j++;
                nums[j] = nums[i];
               
            }
            i += 1;
        }
        return j+1;
    }
}
