public class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int tmp;
        for(int i = 0; i < size/2; i ++){
            for(int j = i; j < size - i - 1; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[size-j-1][i];
                matrix[size-j-1][i] = matrix[size-i-1][size-j-1];
                matrix[size-i-1][size-j-1] = matrix[j][size-i-1];
                matrix[j][size-i-1] = tmp;
            }
        }
    }
}