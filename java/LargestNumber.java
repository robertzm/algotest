public class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        int tmp, index = 0;
        if(len == 0){
            return "";
        }
        for(int j = 0; j < len-1; j++){
            for(int i = len-1; i > j; i --){
                 if(comparator(nums[i-1], nums[i])){
                     tmp = nums[i];
                     nums[i] = nums[i-1];
                     nums[i-1] = tmp;
                 }
            }
        }
        String result = "";
        if(nums[0] == 0){
            return "0";
        }
        while(index < len){
            result += nums[index];
            index ++;
        }
        return result;
        
    }
    
    private boolean comparator(int num1, int num2){
        if(Long.parseLong(""+num1+num2) < Long.parseLong(""+num2+num1)){
            return true;
        }else{
            return false;
        }
    }
}