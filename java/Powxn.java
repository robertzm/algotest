public class Solution {
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        if(n == 0 || x == 1){
            return 1;
        }
        if(x<0){
            if(n%2 == 1){
                return -myPow(-x, n);
            }else{
                return myPow(-x, n);
            }
        }
        if(n<0){
            return 1/myPow(x, -n);
        }
        double result = 1;
        while(n-- > 0){
            if(result >= Double.POSITIVE_INFINITY){
                return Double.POSITIVE_INFINITY;
            }
            if(result <= Double.MIN_VALUE){
                return Double.MIN_VALUE;
            }
            result *= x;
        }
        return result;
    }
}