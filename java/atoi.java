public class Solution {
    public int myAtoi(String str) {
        // in case of empty string
        if(str.length() == 0)
            return 0;
        // ignore the pre-space character
        while(str.charAt(0) == ' '){
            str = str.substring(1);
        }
        int i;
        // +/- symbol 
        if(str.charAt(0) == '+' || str.charAt(0) == '-'){
            for(i = 1; i < str.length(); i ++){
                if(str.charAt(i) < '0' || str.charAt(i) >'9')
                    break;
            }
            // in case of empty string
            if(i == 1)
                return 0;
            String strnum = str.substring(1, i);
            // double in case of overflow
            double test = Double.parseDouble(strnum);
            if(str.charAt(0) == '-'){
                test = test * (-1);
            }
            // return MIN_VALUE and MAX_VALUE in case of overflow
            if(test < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else if(test > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return (int)test;
            }
        }else{
            for(i = 0; i < str.length(); i ++){
                if(str.charAt(i) < '0' || str.charAt(i) >'9')
                    break;
            }
            // in case of empty string
            if(i == 0)
                return 0;
            String strnum = str.substring(0, i);
            // double in case of overflow
            double test = Double.parseDouble(strnum);
            // return MAX_VALUE in case of overflow
            if(test > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return (int)test;
            }
        }
    }
}