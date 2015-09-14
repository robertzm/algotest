public class Solution {
    HashMap<Integer, Integer> hm  = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        for(int i = 0; i < n+1; i ++){
            setHashMap(i);
        }
        return hm.get(n);
    }
    
    public void setHashMap(int n){
        if(n == 0){
            hm.put(0, 1);
        }else{
            int tmp = 0;
            for(int i = 0; i < n; i ++){
                tmp += hm.get(i) * hm.get(n-1-i);
            }
            hm.put(n, tmp);
        }
    }
}