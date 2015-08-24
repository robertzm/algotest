public class Solution {
    public int countDigitOne(int n) {
        long result = 0;
        if(n <= 0){
            return 0;
        }
        String nStr = String.valueOf(n);
        int len = nStr.length();
        int p = 1;
        int tmp = 0;
        
        for(int i = len - 1; i >= 0; i-- ){
            int val = nStr.charAt(i) - '0';
            if(val >= 2){
                result +=  p;
            }else if(val == 1){
                result += (tmp + 1);
            }
            tmp += val * p;
            n /= 10;
            result += n * p;
            p *= 10;
        }

        return (int)result;
    }
}