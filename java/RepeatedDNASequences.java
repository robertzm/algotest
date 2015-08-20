public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() <= 10){
            return result;
        }
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        for(int i = 0; i <= s.length() - 10; i ++){
            int subint = dnaToInt(s.substring(i, i+10));
            if(hm.containsKey(subint)){
                if(!hm.get(subint)){
                    result.add(s.substring(i, i+10));
                    hm.put(subint, true);
                }
            }else{
                hm.put(subint, false);
            }
        }
        return result;
    }
    
    private int dnaToInt(String s){
        String result = "";
        for(int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == 'A') result += "0";
            if (s.charAt(i) == 'C') result += "1";
            if (s.charAt(i) == 'G') result += "2";
            if (s.charAt(i) == 'T') result += "3";
        }
        return Integer.parseInt(result, 4);
    }
}