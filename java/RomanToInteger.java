public class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int result = 0;
        int tmp = singleRoman(s.charAt(0));
        if(tmp == 0){
            return 0;
        }
        char last = s.charAt(0);
        for(int i = 1; i <  len; i ++){
            int cur = singleRoman(s.charAt(i));
            if(cur == 0){
                return 0;
            }else{
                if(cur < singleRoman(s.charAt(i-1))){
                    result += tmp;
                    tmp = cur;
                    continue;
                }else if(cur == singleRoman(s.charAt(i-1))){
                    tmp += cur;
                    continue;
                }else{
                    result = result + cur - tmp;
                    tmp = 0;
                    continue;
                }
            }
        }
        if(tmp != 0){
            result += tmp;
        }
        return result;
    }
    
    private int singleRoman(char c){
        if(c == 'M'){
            return 1000;
        }else if(c == 'D'){
            return 500;
        }else if(c == 'C'){
            return 100;
        }else if(c == 'L'){
            return 50;
        }else if(c == 'X'){
            return 10;
        }else if(c == 'V'){
            return 5;
        }else if(c == 'I'){
            return 1;
        }else{
            return 0;
        }
    }
}