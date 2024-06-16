class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> q = new LinkedList<>();
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i == m && j < n) {
                q.offer(nums2[j++]);
                continue;
            }
            if (i < m && j == n) {
                q.offer(nums1[i++]);
                continue;
            }
            if (nums1[i] < nums2[j]) {
                q.offer(nums1[i++]);
            } else {
                q.offer(nums2[j++]);
            }
        }
        i = 0;
        while(!q.isEmpty()) {
            nums1[i++] = q.poll();
        }
    }
}

/**
 class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;     
    int j = n - 1;     
    int k = m + n - 1; 

    while (j >= 0)
      if (i >= 0 && nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--]; 
      } else {
        nums1[k--] = nums2[j--];
      }
  }
}
 */
