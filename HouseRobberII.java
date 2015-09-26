public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length-1)), helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    
    public int helper(int[] nums){
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }else{
            nums[1] = Math.max(nums[0], nums[1]);
            for(int i = 2; i < nums.length; i ++){
                nums[i] = Math.max(nums[i-2]+nums[i], nums[i-1]);
            }
            return nums[nums.length-1];
        }
    }
}