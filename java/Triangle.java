public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return 0;
        }
        for(int i = 1; i < triangle.size(); i++){
            triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i-1).get(0));
            int j = 1;
            for(; j < triangle.get(i).size()-1; j++){
                triangle.get(i).set(j, Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)) + triangle.get(i).get(j));
            }
            triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
        }
        int result = Integer.MAX_VALUE;
        for(int i: triangle.get(triangle.size()-1)){
            result = (i < result)? i : result;
        }
        return result;
    }
}