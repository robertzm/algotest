public class Solution {
    public int titleToNumber(String s) {
        double result = 0;
        for(int i = 0; i < s.length(); i ++){
            result *= 26;
            if(s.charAt(i) < 'A' || s.charAt(i) > 'Z'){
                return 0;
            }
            result += (int)(s.charAt(i) - 'A' + 1);
        }
        return Math.min((int)result, Integer.MAX_VALUE);
    }
}