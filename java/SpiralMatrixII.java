public class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0){
            return new int[0][0];
        }
        int[][] result = new int[n][n];
        int cur = 1, target = n*n;
        int up = 0, bottom = 0, left = 0, right = 0;
        while(true){
            for(int i = left; i < n-right; i ++){
                result[up][i] = cur++;
            }
            up++;
            if(cur > target){
                return result;
            }
            for(int i = up; i < n-bottom; i ++){
                result[i][n-right-1] = cur++;
            }
            right++;
            if(cur > target){
                return result;
            }
            for(int i = n-right-1; i >= left; i --){
                result[n-bottom-1][i] = cur++;
            }
            bottom++;
            if(cur > target){
                return result;
            }
            for(int i = n-bottom-1; i >= up; i --){
                result[i][left] = cur++;
            }
            left++;
            if(cur > target){
                return result;
            }
        }
    }
}