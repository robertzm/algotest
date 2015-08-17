public class Solution {
    public void rotate(int[] nums, int k) {
        int[] tmp = nums.clone();
        int len = nums.length;
        for(int i = 0; i < len; i ++){
            nums[(i+k) % len] = tmp[i];
        }
    }
}