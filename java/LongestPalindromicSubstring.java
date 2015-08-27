public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0){
            return "";
        }
        String res = s.substring(0, 1);
        String tmp;
        int len = 1, i = 0;
        for(; i < s.length() - 1; i ++){
            tmp = testPalindrome(s, i, i);
            if(tmp.length() > len){
                res = tmp;
                len = tmp.length();
            }
            if(s.charAt(i) == s.charAt(i+1)){
                tmp = testPalindrome(s, i, i+1);
                if(tmp.length() > len){
                    res = tmp;
                    len = tmp.length();
                }
            }
        }
        tmp = testPalindrome(s, i, i);
        if(tmp.length() > len){
            res = tmp;
            len = tmp.length();
        }        
        return res;
    }
    
    private String testPalindrome(String s, int start, int end){
        int n = s.length();
        while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)){
            start --;
            end ++;
        }
        return s.substring(start + 1, end);
    }
}