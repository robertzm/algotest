public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        // check last digit of "9"
        while(i >= 0){
            if(digits[i] != 9){
                digits[i] ++;
                break;
            }
            digits[i--] = 0;
        }
        // not necessary for more digit
        if(i >= 0){
            return digits;
        }else{
            // one more digit
            int[] newDigits = new int[len + 1];
            newDigits[0] = 1;
            i = 1;
            while(i < len + 1){
                newDigits[i++] = 0;
            }
            return newDigits;
        }
    }
}