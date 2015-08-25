public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String result = "";
        int pn = 0;
        long n, dn, r;
        if(denominator == 0){
            return "";
        }else if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)){
            result += "-";
        }
        n = Math.abs((long)numerator);
        dn = Math.abs((long)denominator);
        r = n % dn;
        n = n / dn;
        int flag = 0;
        int start = 0;
        result += n;
        if(r != 0){
            result += ".";
            HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
            int i = 0;
            while(r != 0){
                r *= 10;
                if(hm.containsKey(r)){
                    flag = 1;
                    start = hm.get(r);
                    break;
                }else{
                    hm.put(r, i);
                }
                n = r / dn;
                result += n;
                r %= dn;
                i++;
            }
            if(flag == 1){
                result = result.substring(0, result.indexOf(".") + 1 +start) + "(" + result.substring(result.indexOf(".") + 1 +start) + ")";
            }
        }
        return result;
    }
}