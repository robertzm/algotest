public class Solution {
    public void sortColors(int[] nums) {
        int red=0, white=0, blue=0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 2){
                blue++;
            }else if(nums[i] == 1){
                nums[red + white] = 1;
                if(blue != 0){
                    nums[i] = 2;
                }
                white++;
            }else{
                nums[red] = 0;
                if(white != 0){
                    nums[red + white] = 1;
                }
                if(blue != 0){
                    nums[i] = 2;
                }
                red ++;
            }
        }
    }
}