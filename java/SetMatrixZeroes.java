public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        int flag = -1;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(flag == -1){
                        flag = i;
                        for(int k = 0; k < n; k ++){
                            matrix[i][k] = (matrix[i][k] == 0)? 1: 0;
                        }
                    }else{
                        for(int k = 0; k < n; k ++){
                            if(matrix[i][k] == 0){
                                matrix[flag][k] = 1;
                            }
                            matrix[i][k] = 0;
                        }
                    }
                    break;
                }
            }
        }
        if(flag == -1){
            return;
        }
        for(int j = 0; j < n; j ++){
            if(matrix[flag][j] == 1){
                for(int i = 0; i < m; i ++){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}