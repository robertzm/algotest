public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0){
            return 0;
        }
        Arrays.sort(citations);
        int len = citations.length;
        int hIndex = 0;
        for(int i = 1; i <= len; i ++){
            hIndex = ((int)Math.min(citations[len-i], i) > hIndex)? (int) Math.min(citations[len-i], i) : hIndex;
        }
        return hIndex;
    }
}