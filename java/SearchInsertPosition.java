public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || target < nums[0]){
            return 0;
        }else if( target > nums[nums.length - 1]){
            return nums.length;
        }else{
            return find(nums, 0, nums.length-1, target);
        }
    }
    
    public int find(int[] nums, int m, int n, int target){
        if(m == (n-1)){
            if(nums[m] >= target){
                return m;
            }else{
                return n;
            }
        }
        if(nums[m + (n-m)/2] > target){
            return find(nums, m, m+(n-m)/2, target);
        }else if(nums[m + (n-m)/2] < target){
            return find(nums, m+(n-m)/2, n, target);
        }else{
            return m+(n-m)/2;
        }
    }
}