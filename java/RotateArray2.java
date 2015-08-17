public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int i = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        while(i < len){
            q.add(nums[i++]);
        }
        k %= len;
        k = len - k;
        while(k-- > 0){
            q.add(q.remove());
        }
        i = 0;
        while(q.peek() != null){
            nums[i++] = q.remove();
        }
    }
}