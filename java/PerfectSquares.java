public class Solution {
    public int numSquares(int n) {
        if(n < 4){
            return n;
        }
        int[] dp = new int[n+1];
        for(int i = 0; i <= 3; i++){
            dp[i] = i;
        }
        for(int i = 4; i <= n; i++){
            int tmp = (int) Math.sqrt(i);
            if(tmp * tmp == i){
                dp[i] = 1;
            }else{
                int sumTmp = Integer.MAX_VALUE;
                for(int j = 2; j <= tmp; j++){
                    sumTmp = (dp[i - j * j] + 1 < sumTmp)? dp[i - j * j] + 1 :sumTmp;
                }
                dp[i] = sumTmp;
            }
        }
        return dp[n];
    }
    
    
}