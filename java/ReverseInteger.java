public class Solution {
    public int reverse(int x) {
        // in case of |Integer.MIN_VALUE| != |Integer.MAX_VALUE|
        if(x == Integer.MIN_VALUE)
            return 0;
        // nagetive integer
        if(x < 0){
            x = x * (-1);
            String string = Integer.toString(x);
            String reverse = new StringBuffer(string).reverse().toString();
            // in case of overflow
            if( Double.parseDouble(reverse) > Integer.MAX_VALUE) {
                return 0;
            }else{
                int rint = Integer.parseInt(reverse);
                return (-1) * rint;
            }
        }else{
            // positive integer
            String string = Integer.toString(x);
            String reverse = new StringBuffer(string).reverse().toString();
            // in case of overflow
            if( Double.parseDouble(reverse) > Integer.MAX_VALUE) {
                return 0;
            }else{
                int rint = Integer.parseInt(reverse);
                return rint;
            }
        }
    }
}