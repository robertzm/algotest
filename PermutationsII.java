public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0) return result;
        ArrayList<Integer> cur = new ArrayList<>();
        ArrayList<Integer> left = new ArrayList<>();
        
        Arrays.sort(nums);
        for(int i: nums){
            cur.add(i);
        }
        result.add((ArrayList<Integer>)cur.clone());
        while(cur.size() > 0){
            int t = cur.get(cur.size()-1);
            cur.remove(cur.size()-1);
            if(left.size() == 0 || t >= left.get(left.size()-1)){
                left.add(t);
                continue;
            }
            left.add(t);
            Collections.sort(left);
            for(int i: left){
                if(i > t){
                    cur.add(i);
                    left.remove(new Integer(i));
                    break;
                }
            }
            for(int i: left){
                cur.add(i);
            }
            left.clear();
            result.add((ArrayList<Integer>)cur.clone());
        }
        return result;
    }
}