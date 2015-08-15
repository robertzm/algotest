public class Solution {
    public List<Integer> getRow(int k) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <= k; i ++){
            result.add((int)nChoosek(k, i));
        }
        return result;
    }
    
    public long nChoosek(int n, int k){
        if(k == 0){
            return 1;
        }
        return nChoosek(n, k-1) * (n-k+1) / k;
    }
}