public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int nd = 0;
        for(int i = 0 ; i < len; i ++){
            if(nums[i] > nums[nd]){
                nums[nd+1] = nums[i];
                nd++;
            }
        }
        return nd+1;
    }
}