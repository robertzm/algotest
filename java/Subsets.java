public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0; i <= nums.length; i ++){
            result.addAll(subsetsN(nums, i));
        }
        return result;
    }
    
    public List<List<Integer>> subsetsN(int[] nums, int n){
        Stack st = new Stack();
        List<Integer> cur = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp;
        int len = nums.length;
        
        for(int i = 0; i < n; i ++){
            st.push(i);
            cur.add(i);
        }
        tmp = new ArrayList<Integer>();
        for(int i: cur){
            tmp.add(nums[i]);
        }
        result.add(tmp);
        while(!st.empty()){
            int t = (int) st.pop();
            cur.remove(new Integer(t));
            if(len - t <= n - cur.size() ){
                continue;
            }
            while(true){
                if(cur.size() == n){
                    tmp = new ArrayList<Integer>();
                    for(int i: cur){
                        tmp.add(nums[i]);
                    }
                    result.add(tmp);
                    break;
                }
                if(++t > len){
                    break;
                }
                st.push(t);
                cur.add(t);
            }
        }
        return result;
    }
}