public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n){
            return result;
        }
        Stack st = new Stack();
        List<Integer> cur = new ArrayList<Integer>();
        
        for(int i = 1; i <= k; i++){
            st.push(i);
            cur.add(i);
        }
        List<Integer> tmp = new ArrayList<Integer>();
        for(Integer i: cur){
            tmp.add(i);
        }
        result.add(tmp);
        while(!st.empty()){
            int t = (int)st.pop();
            cur.remove(new Integer(t));
            if((n - t) < (k - cur.size())){
                continue;
            }
            while(true){
                if(cur.size() == k){
                    tmp = new ArrayList<Integer>();
                    for(int i: cur){
                        tmp.add(i);
                    }
                    result.add(tmp);
                    break;
                }
                if(++t > n){
                    break;
                }
                st.push(t);
                cur.add(t);
            }
        }
        return result;
    }
}