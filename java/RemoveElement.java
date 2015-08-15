public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int tmp;
        for(int i = 0; i < len; i ++){
            if(nums[i] == val){
                if(i == len - 1){
                    return --len;
                }
                for(int j = len - 1; j > i; j --){
                    if(nums[j] == val){
                        len--;
                        if(j == i + 1){
                            return --len;
                        }
                        continue;
                    }else{
                        tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        len--;
                        break;
                    }
                    
                }
            }
        }
        return len;
    }
}