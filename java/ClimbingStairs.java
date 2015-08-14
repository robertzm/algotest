public class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int a1 = 1, a2 = 2, tmp;
        for(int i = 2; i < n; i ++){
            tmp = a1 + a2;
            a1 = a2;
            a2 = tmp;
        }
        return a2;
    }
}