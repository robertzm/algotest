public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m, n;
        if((m = matrix.length) == 0 || (n = matrix[0].length) == 0){
            return false;
        }
        int up = 0, bottom = m, left = 0, right = n, i;
        while(up < bottom && left < right){
            for(i = up; i < bottom; i++){
                if(matrix[i][right-1] == target){
                    return true;
                }else if(matrix[i][right-1] > target){
                    break;
                }
            }
            up = i;
            if(up >= bottom || left >= right) break;
            for(i = bottom - 1; i >= up; i--){
                if(matrix[i][left] == target){
                    return true;
                }else if(matrix[i][left] < target){
                    break;
                }
            }
            bottom = i+1;
            if(up >= bottom || left >= right) break;
            for(i = left; i < right; i++){
                if(matrix[bottom-1][i] == target){
                    return true;
                }else if(matrix[bottom-1][i] > target){
                    break;
                }
            }
            left = i;
            if(up >= bottom || left >= right) break;
            for(i = right - 1; i >= left; i--){
                if(matrix[up][i] == target){
                    return true;
                }else if(matrix[up][i] < target){
                    break;
                }
            }
            right = i+1;
        }
        return false;
    }
}