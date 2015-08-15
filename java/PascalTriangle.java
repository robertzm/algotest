public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        result.add(cur);
        for(int i = 1; i < numRows; i ++){
            List<Integer> last = cur;
            cur = new ArrayList<Integer>();
            cur.add(1);
            for(int j = 0; j < last.size()-1; j++){
                cur.add(last.get(j) + last.get(j+1));
            }
            cur.add(1);
            result.add(cur);
        }
        return result;
    }
}