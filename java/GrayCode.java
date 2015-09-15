public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(n == 0){
            result.add(0);
            return result;
        }
        List<Integer> tmp = grayCode(n-1);
        result.addAll(tmp);
        Collections.reverse(tmp);
        int shift = (int)Math.pow(2, n-1);
        for(int i: tmp){
            result.add(shift + i);
        }
        return result;
    }
}