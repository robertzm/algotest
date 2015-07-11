public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> tmp = new LinkedList<Integer>();
        int i = 0, j = 0;
        while(i < m + n){
            if(i < m)
                tmp.add(nums1[i]);
            if(j < n){
                if(tmp.peek() != null && tmp.peek() <= nums2[j]){
                    nums1[i++] = tmp.remove();
                }else{
                    nums1[i++] = nums2[j++];
                }
            }else{
                nums1[i++] = tmp.remove();
            }
        }
    }
}