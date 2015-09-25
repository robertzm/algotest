public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        result.add(tmp);
        
        Arrays.sort(nums);
        ArrayList<Integer> cur = (ArrayList<Integer>) tmp.clone();
        for(int i: nums){
            cur.add(i);
            result.add(tmp = (ArrayList<Integer>) cur.clone());
        }
        while(cur.size() != 0){
            int t = cur.remove(cur.size()-1);
            for(int i: nums){
                if(i > t){
                    cur.add(i);
                    result.add(tmp = (ArrayList<Integer>) cur.clone());
                }
            }
        }
        return result;
    }
}