public class Solution {
    List<List<String>> map = new ArrayList<List<String>>();
    List<String> result = new ArrayList<String>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return result;
        }
        genMap();
        addChar("", digits);
        return result;
    }
    
    private void genMap(){
        String[] num1 = {""};
        String[] num2 = {"a", "b", "c"};
        String[] num3 = {"d", "e", "f"};
        String[] num4 = {"g", "h", "i"};
        String[] num5 = {"j", "k", "l"};
        String[] num6 = {"m", "n", "o"};
        String[] num7 = {"p", "q", "r", "s"};
        String[] num8 = {"t", "u", "v"};
        String[] num9 = {"w", "x", "y", "z"};
        String[] num0 = {" "};
        
        map.add(0, Arrays.asList(num0));
        map.add(1, Arrays.asList(num1));
        map.add(2, Arrays.asList(num2));
        map.add(3, Arrays.asList(num3));
        map.add(4, Arrays.asList(num4));
        map.add(5, Arrays.asList(num5));
        map.add(6, Arrays.asList(num6));
        map.add(7, Arrays.asList(num7));
        map.add(8, Arrays.asList(num8));
        map.add(9, Arrays.asList(num9));
    }
    
    private void addChar(String cur, String digits){
        if(digits.length() == 0){
            result.add(cur);
        }else{
            List<String> tmp = map.get(Integer.parseInt(digits.substring(0,1)));
            for(String str: tmp){
                addChar(cur+str, digits.substring(1));
            }
        }
    }
}