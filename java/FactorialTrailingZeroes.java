public class Solution {
    public int trailingZeroes(int n) {
        int zeros = 0;
        for(int i = 1; ; i ++){  
            if(Math.pow(5, i) > n){
                break;
            }
            zeros += (n / Math.pow(5, i));
        }
        return zeros;
    }
}