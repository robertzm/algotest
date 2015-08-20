public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if(len <= 1){
            return 0;
        }
        int start = 0, end = len - 1;
        int area = 0;
        while(start < end){
            int tmp = calArea(height[start], height[end], end - start);
            if( tmp > area){
                area = tmp;
            }
            if(height[start] > height[end]){
                end --;
            }else{
                start ++;
            }
        }
        return area;
    }
    
    private int calArea(int h1, int h2, int w){
        return Math.min(h1, h2) * w;
    }
}