package TopInterview150;

//#Day 1      date - 01-03-2025

//Optimal Approach - 
    // 1.take 3pointer i,j,k from last 
    //  travese and compare and put the value in nums1
/*
✅ Time Complexity:
O(m + n) → We iterate over both arrays once.
✅ Space Complexity:
O(1) → In-place merge without extra space.
*/ 
public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // Last valid element index in nums1
        int j = m + n - 1;   // Last index of nums1 (including extra space)
        int k = n - 1;       // Last index of nums2

        while (i >= 0 && k >= 0) {
            if (nums1[i] > nums2[k]) {
                nums1[j--] = nums1[i--];
            } else {
                nums1[j--] = nums2[k--];
            }
        }

        // If nums2 has remaining elements, copy them to nums1
        while (k >= 0) {
            nums1[j--] = nums2[k--];
        }
    }
}
