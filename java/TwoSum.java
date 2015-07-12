public class Solution {
    public int[] twoSum(int[] nums, int target) {
           HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
           for(int i = 0; i < nums.length; i++){
               if(numbers.get(target - nums[i]) != null){
                    int[] res = {numbers.get(target - nums[i])+1, i+1};
                   return res;
               }else{
                   numbers.put(nums[i], i);
               }
           }
           int[] res = {0, 0};
           return res;
    }
}