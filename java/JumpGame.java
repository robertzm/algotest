public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return true;
        }
        int life = nums[0];
        for(int i = 1; i < nums.length; i ++){
            if(life <= 0){
                return false;
            }else{
                life = Math.max(life-1, nums[i]); 
            }
        }
        return true;
    }
}