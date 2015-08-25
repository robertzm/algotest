public class Solution {
    public int findMin(int[] nums) {
         if(nums.length == 0){
             return 0;
         }
         int i = 0, j = nums.length - 1, tmp;
         while(i < j){
             if(i == j-1){
                 return Math.min(nums[i], nums[j]);
             }
             if(nums[i] < nums[j]){
                 return nums[i];
             }
             tmp = (i + j) / 2;
             if(nums[i] > nums[tmp]){
                 j = tmp;
             }else{
                 i = tmp;
             }
         }
         return nums[i];
    }
}