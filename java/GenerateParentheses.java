public class Solution {
    List<String> result = new ArrayList<String>();
    
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return result;
        }
        helper(n,n,"");
        return result;
    }
    
    private void helper(int left, int right, String str){
        if(left == 0 && right  == 0){
            result.add(str);
            return;
        }
        if(left > 0){
            helper(left - 1, right, str+"(");
        }
        if(right > left){
            helper(left, right - 1, str+")");
        }
    }
}