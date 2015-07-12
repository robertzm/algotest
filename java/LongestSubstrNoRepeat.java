public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> substr = new HashMap<Character, Integer>();
        int i = 0, len = s.length();
        int p1 = 0, res = 0, tmp;
        for(; i < len; i++){
            if(substr.get(s.charAt(i)) != null && (tmp = substr.get(s.charAt(i))) >= p1){
                res = ((i-p1) > res)? (i-p1): res;
                p1 = tmp + 1;
                substr.put(s.charAt(i), i);
            }else{
                substr.put(s.charAt(i), i);
            }
        }
        res = ((i-p1) > res)? (i - p1): res;
        return res;
    }
}