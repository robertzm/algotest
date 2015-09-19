public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int curNum = nums[0], count = 0, curPos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == curNum){
                if(count < 2){
                    nums[curPos++] = nums[i];
                }
                count++;
            }else{
                nums[curPos++] = nums[i];
                curNum = nums[i];
                count = 1;
            }
        }
        return curPos;
    }
}