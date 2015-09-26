public class Solution {
    public void nextPermutation(int[] nums) {
        ArrayList<Integer> left = new ArrayList<>();
        int i;
        for(i = nums.length - 1; i >= 0; i--){
            if(left.size() == 0 || left.get(left.size() - 1) <= nums[i]){
                left.add(nums[i]);
                continue;
            }else{
                left.add(nums[i]);
                Collections.sort(left);
                for(int t: left){
                    if(t > nums[i]){
                        nums[i] = t;
                        break;
                    }
                }
                left.remove(new Integer(nums[i++]));
                for(int t: left){
                    nums[i++] = t;
                }
                return;
            }
        }
        i = 0;
        for(int t: left){
            nums[i++] = t;
        }
        return;
    }
}