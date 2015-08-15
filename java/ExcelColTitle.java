public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0){
            return "";
        }
        String result = "";
        do{
            n--;
            result = (char)((int)'A' + n % 26) + result;
            n /= 26;
        }while(n != 0);
        return result;
    }
}