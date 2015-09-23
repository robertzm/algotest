public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        int pivot = nums[0];
        int i = 1, j = nums.length-1;
        while(i<j){
            if(nums[i] >= pivot){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
            }else{
                i++;
            }
        }
        if(i >= nums.length || nums[i] >= pivot) i--;
        int right = nums.length - i -1;
        if(right == k - 1){
            return pivot;
        }else if(right > k - 1){
            return findKthLargest(Arrays.copyOfRange(nums, i+1, nums.length), k);
        }else{
            return findKthLargest(Arrays.copyOfRange(nums, 1, i+1), k-right - 1);
        }
    }
}