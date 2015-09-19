public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0, bottom = 0, left = 0, right = 0;
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int m = matrix.length, n = matrix[0].length;
        while(true){
            for(int i = left; i < n-right; i ++){
                result.add(matrix[up][i]);
            }
            if(++up + bottom >= m){
                return result;
            }
            for(int i = up; i < m-bottom; i ++){
                result.add(matrix[i][n-right-1]);
            }
            if(++right + left >= n){
                return result;
            }
            for(int i = n-right-1; i >= left; i--){
                result.add(matrix[m-bottom-1][i]);
            }
            if(++bottom + up >= m){
                return result;
            }
            for(int i = m-bottom-1; i >= up; i--){
                result.add(matrix[i][left]);
            }
            if(++left + right >= n){
                return result;
            }
        }
    }
}