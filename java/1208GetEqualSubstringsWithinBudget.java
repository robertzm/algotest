class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] diff = new int[s.length()];
        for (int i = 0; i < s.length(); i ++ ) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0, right = 0;
        int total = 0;
        int maxSub = 0;
        for (; right < s.length(); right++) {
            total += diff[right];
            while (total > maxCost && left <= right) {
                total -= diff[left];
                left++;
            }
            if (total <= maxCost) {
                maxSub = Math.max(maxSub, right - left + 1);
            }
        }

        return maxSub;

    }
}
