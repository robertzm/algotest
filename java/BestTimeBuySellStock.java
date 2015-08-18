public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1){
            return 0;
        }
        int bday = 0, sday = 0, fday = 0;
        for(int i = 1; i < len; i ++){
            if(prices[i] > prices[sday]){
                sday = i;
            }
            if((prices[i] - prices[fday]) > (prices[sday] - prices[bday])){
                bday = fday;
                sday = i;
            }
            if(prices[i] < prices[fday]){
                fday = i;
            }

        }
        return (int)(prices[sday] - prices[bday]);
    }
}