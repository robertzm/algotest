public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len;
        if((len = gas.length) != cost.length || len == 0){
            return -1;
        }
        int cur = 0, sum = 0, index = 0;
        for(int i = 0; i < len;){
            sum += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if(cur < 0){
                index = ++i;
                cur = 0;
                continue;
            }
            i++;
        }
        if(sum >= 0){
            return index;
        }else{
            return -1;
        }
        
    }
}