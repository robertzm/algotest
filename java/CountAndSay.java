public class Solution {
    public String countAndSay(int n) {
        if(n <= 0){
            return "";
        }
        String cur = "1";
        for(int i = 1; i < n; i++){
            cur = getNext(cur);
        }
        return cur;
    }
    private String getNext(String str){
        String result = "";
        int len = str.length(), num = 1;
        char digit = str.charAt(0);
        for(int i = 1; i < len; i ++){
            if(str.charAt(i) != digit){
                result = result + num + digit;
                digit = str.charAt(i);
                num = 1;
            }else{
                num ++;
            }
        }
        result = result + num + digit;
        return result;
    }
}