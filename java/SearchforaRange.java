public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] error = {-1, -1};
        int[] result = new int[2];
        if(nums.length == 0){
            return error;
        }
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int i;
            if(nums[mid] == target){
                for(i = mid; i >= left; i --){
                    if(nums[i] != target){
                        break;
                    }
                }
                result[0] = i<left? left: i+1;
                for(i = mid; i <= right; i ++){
                    if(nums[i] != target){
                        break;
                    }
                }
                result[1] = i>right? right: i-1;
                return result;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return error;
    }
}