public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if(m == 0 || n == 0 || matrix[0][0] > target){
            return false;
        }
        int i = 0, j = matrix.length;
        while(j - i > 1){
            int tmp = matrix[(i+j)/2][0];
            if(tmp > target){
                j = (i+j)/2;
            }else if(tmp < target){
                i = (i+j)/2;
            }else{
                return true;
            }
        }
        int row = i;
        i = 0;
        j = matrix[0].length-1;
        do{
            if(matrix[row][i] == target || matrix[row][j] == target){
                return true;
            }else{
                int tmp = matrix[row][(i+j)/2];
                if(tmp > target){
                    j = (i+j)/2;
                }else if(tmp < target){
                    i = (i+j)/2;
                }else{
                    return true;
                }
            }
        }while(j - i > 1);
        return false;
    }
}