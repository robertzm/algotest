public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0 || dungeon[0].length == 0) return 1;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] minHP = new int[m][n];
        int i = m-1, j = n-1;
        minHP[i][j] = dungeon[i][j] >= 0? 1: 1-dungeon[i][j];
        for(j = n-2; j >= 0; j --){
            minHP[i][j] = dungeon[i][j] >= minHP[i][j+1]? 1: minHP[i][j+1] - dungeon[i][j];
        }
        for(j = n-1, i = m-2; i >= 0; i --){
            minHP[i][j] = dungeon[i][j] >= minHP[i+1][j]? 1: minHP[i+1][j] - dungeon[i][j];
        }
        for(i = m-2; i >= 0; i--){
            for(j = n-2; j >= 0; j--){
                int tmp = Math.min(minHP[i+1][j], minHP[i][j+1]);
                minHP[i][j] = dungeon[i][j] >= tmp? 1: tmp - dungeon[i][j];
            }
        }
        return minHP[0][0];

    }
}