class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;
        long currentTime = 0;
        for (int[] c : customers) {
            if (currentTime < c[0]) {
                currentTime = c[0];
            }
            currentTime += c[1];
            totalWaitingTime += (currentTime - c[0]);
        }
        return totalWaitingTime / customers.length;
    }
}
