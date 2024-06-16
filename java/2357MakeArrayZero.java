class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums) {
            if (n == 0) {
                continue;
            }
            s.add(n);
        }
        return s.size();
    }
}
