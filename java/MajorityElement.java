public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int size = nums.length;
        if(size == 1){
            return nums[0];
        }
        
        for(int i = 0; i < size; i++){
            if(hm.containsKey(nums[i])){
                int tmp = hm.get(nums[i]);
                if((tmp + 1) > (size/2)){
                    return nums[i];
                }
                hm.put(nums[i], tmp + 1);
            }else{
                hm.put(nums[i], 1);
            }
        }
        return 0;
    }
}