public class Solution {
    public int missingNumber(int[] nums) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0;
        for(int i = 0; i < nums.length; i ++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        if(min != 0){
            return 0;
        }else if(max == min + nums.length -1){
            return (int)(min + nums.length);
        }else{
            return (int)((min + max) * (nums.length + 1) / 2 - sum);
        }
    }
}