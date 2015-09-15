public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], cur = 0, len = nums.length;
        for(int i = 0; i < len; i ++){
            cur += nums[i];
            if(cur < 0 || cur < nums[i]){
                cur = nums[i];
            }
            if(cur > max){
                max = cur;
            }
        }
        return max;
        
    }
}