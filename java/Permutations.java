public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0){
            return result;
        }
        
        for(int i = 0; i < nums.length; i ++){
            tmp.add(nums[i]);
        }
        result = recPerm(tmp);
        return result;
    }
    
    public List<List<Integer>> recPerm(List<Integer> nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.size() == 1){
            result.add(nums);
            return result;
        }
        int len = nums.size();
        for(int i = 0; i < len; i ++){
            int t = nums.remove(0);
            List<List<Integer>> tmps = recPerm(nums);
            for(List<Integer> tmp : tmps){
                tmp.add(t);
                result.add(tmp);
            }
            nums.add(t);
        }
        return result;
    }
}