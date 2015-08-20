public class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1){
            return 0;
        }
        if(len == 2){
            if(nums[0]>nums[1]){
                return 0;
            }else{
                return 1;
            }
        }else{
            int tmp = len / 2;
            if(nums[tmp] > nums[tmp-1] && nums[tmp] > nums[tmp+1]){
                return tmp;
            }else if(nums[tmp] > nums[tmp-1] && nums[tmp+1] > nums[tmp]){
                return findPeakElement(Arrays.copyOfRange(nums, tmp, len))+tmp;    
            }else{
                return findPeakElement(Arrays.copyOfRange(nums, 0, tmp));
            }
        }
        
    }
}