class Solution {
    public in minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        int[] identical = new int[5];
        int index = 0;
        Arrays.fill(identical, Integer.MIN_VALUE);
        for (int num : nums) {
            for (int i = 0; i < 5; i++) {
                if (identical[i] == num) {
                    break;
                } else if (identical[i] == Integer.MIN_VALUE) {
                    identical[i] = num;
                    index++;
                    break;
                }
            }
            if (index == 5) {
                break;
            }
        }
        if (index <= 4) {
            return 0;
        }
        int[] min = new int[4];
        int[] max = new int[4];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num < min[0]) {
                min[3] = min[2];
                min[2] = min[1];
                min[1] = min[0];
                min[0] = num;
            } else if (num < min[1]) {
                min[3] = min[2];
                min[2] = min[1];
                min[1] = num;
            } else if (num < min[2]) {
                min[3] = min[2];
                min[2] = num;
            } else if (num < min[3]) {
                min[3] = num;
            }
            if (num > max[3]) {
                max[0] = max[1];
                max[1] = max[2];
                max[2] = max[3];
                max[3] = num;
            } else if (num > max[2]) {
                max[0] = max[1];
                max[1] = max[2];
                max[2] = num;
            } else if (num > max[1]) {
                max[0] = max[1];
                max[1] = num;
            } else if (num > max[0]) {
                max[0] = num;
            }
        }
        int m = 0, n = 3;
        for (int i = 0; i < 3; i++) {
            if (min[m+1] - min[m] > max[n] - max[n-1]) {
                m++;
            } else {
                n--;
            }
        }

        return max[n] - min[m];

    }
}
