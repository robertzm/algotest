public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return reverseByLen(n, 32);
    }
    
    private int reverseByLen(int n, int len){
        if(len == 1){
            return n;
        }
        int left = (n >>> len/2) & 0xffffffff;
        int right = n & (0xffffffff >>> (32 - len/2)) ;
        left = reverseByLen(left, len/2);
        right = reverseByLen(right, len/2);
        return ((right << (len/2)) + left);
    }
}