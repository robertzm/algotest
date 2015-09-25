public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int zIndex = 0, cur = 0;
        while(zIndex < nums.length){
            if(nums[zIndex] == 0){
                cur = zIndex;
                break;
            }
            zIndex ++;
        }
        if(zIndex == nums.length){
            return;
        }
        for(; cur < nums.length; cur++){
            if(nums[cur] != 0){
                nums[zIndex] = nums[cur];
                nums[cur] = 0;
                zIndex ++;
            }
        }
    }
}