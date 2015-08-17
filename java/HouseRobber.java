public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }else if(len == 1){
            return nums[0];
        }else if(len == 2){
            return Math.max(nums[0], nums[1]);
        }
        int a1 = nums[0];
        int a2 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; i ++){
            int tmp = Math.max(a1 + nums[i], a2);
            a1 = a2;
            a2 = tmp;
        }
        return a2;
    }
}