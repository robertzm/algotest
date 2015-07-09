public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character, Integer> sHashMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tHashMap = new HashMap<Character, Integer>();
        int i = 0, j = 0;
        
        for(int k = 0; k < s.length(); k ++){
            if(sHashMap.get(s.charAt(k)) != tHashMap.get(t.charAt(k)))
                return false;
            if(sHashMap.get(s.charAt(k)) == null){
                sHashMap.put(s.charAt(k), i);
                i++;
            }
            if(tHashMap.get(t.charAt(k)) == null){
                tHashMap.put(t.charAt(k), j);
                j++;
            }
        }
        return true;
    }
}
