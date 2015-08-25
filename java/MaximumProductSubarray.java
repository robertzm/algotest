public class Solution {
    public int maxProduct(int[] nums) {
        int result;
        if(nums.length == 1){
            return nums[0];
        }
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 0){
                if(i < nums.length - 1){
                    result = Math.max(maxProduct(Arrays.copyOfRange(nums, 0, i)), maxProduct(Arrays.copyOfRange(nums, i+1, nums.length)));
                }else{
                    result = maxProduct(Arrays.copyOfRange(nums, 0, i));
                }
                return Math.max(result, 0);
            }
        }
        return maxProductWoZero(nums);
    }
    
    private int maxProductWoZero(int[] nums){
        int first = 0, last = 0, c = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] < 0){
                if(c == 0){
                    c ++;
                    first = i;
                    last = i;
                }else{
                    c ++;
                    last = i;
                }
            }
        }
        if(c % 2 == 0){
            return product(nums);
        }else{
            return Math.max(product(Arrays.copyOfRange(nums, 0, last)), product(Arrays.copyOfRange(nums, first+1, nums.length)));
        }
    }
    
    private int product(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        double result = 1;
        for(int i = 0; i < nums.length; i ++){
            result *= nums[i];
        }
        return (int)Math.min(result, (double)Integer.MAX_VALUE);
    }
}