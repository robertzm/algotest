public class Solution {
    public String intToRoman(int num) {
        String result = "";
        result += test(num, 1000, 500, 100);
        num %= 100;
        result += test(num, 100, 50, 10);
        num %= 10;
        result += test(num, 10, 5, 1);
        return result;
    }
    
    private String test(int num, int larger, int half, int smaller){
        String result = "";
        while(num >= larger){
            result += match(larger);
            num -= larger;
        }
        if(num + smaller >= larger){
            result += match(smaller);
            result += match(larger);
            num %= smaller;
        }else{
            while(num >= half){
                result += match(half);
                num -= half;
            }
            if(num + smaller >= half){
                result += match(smaller);
                result += match(half);
                num %= smaller;
            }else{
                while(num >= smaller){
                    result += match(smaller);
                    num -= smaller;
                }
            }
        }
        return result;
    }
    
    private String match(int num){
        switch(num){
            case 1000: 
                return "M";
            case 500:
                return "D";
            case 100:
                return "C";
            case 50:
                return "L";
            case 10:
                return "X";
            case 5:
                return "V";
            case 1:
                return "I";
            default:
                return "";
        }
    }
}