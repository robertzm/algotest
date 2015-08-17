public class Solution {
    public void rotate(int[] nums, int k) {
        int t = 0;
        int len = nums.length;
        int tmp1, tmp2;
        for(int i = 0; i < k; i ++){
            int j = i;
            tmp1 = nums[j];
            do{
                tmp2 = nums[(j+k)%len];
                nums[(j+k)%len] = tmp1;
                tmp1 = tmp2;
                j = (j+k) % len;
                t ++;
            }while(j != i);
            if(t >= len){
                break;
            }
        }
    }
}