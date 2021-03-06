public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i ++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return sum;
                }else if(sum < target){
                    left++;
                }else{
                    right--;                    
                }
                closest = Math.abs((long)sum - (long)target) < Math.abs((long)closest - (long)target)? sum : closest;
            }
        }
        return closest;
    }
}