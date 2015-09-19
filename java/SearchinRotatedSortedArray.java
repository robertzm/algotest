public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while(end - start > 1){
            int tmp = (start + end) / 2;
            if(nums[tmp] == target){
                return tmp;
            }
            if(nums[start] < nums[tmp] && target <= nums[tmp] && target >= nums[start]){
                end = tmp;
            }else if(nums[start] < nums[tmp] && (target >= nums[tmp] || target <= nums[start])){
                start = tmp;
            }else if(nums[tmp] < nums[end] && target <= nums[end] && target >= nums[tmp]){
                start = tmp;
            }else if(nums[tmp] < nums[end] && (target <= nums[tmp] || target >= nums[end])){
                end = tmp;
            }
        }
        if(nums[start] == target){
            return start;
        }else if(nums[end] == target){
            return end;
        }else{
            return -1;
        }
    }
}