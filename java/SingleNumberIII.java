public class Solution {
    public int[] singleNumber(int[] nums) {
        int a = 0, b = 0;
        for(int i: nums){
            a ^= i;
        }
        for(int i: nums){
            if((i&a&(-a))!=0){
                b^=i;
            }
        }
        int[] result = new int[2];
        result[0] = b;
        result[1] = a^b;
        return result;
    }
}