public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++){
            if(map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            }else{
                map1.put(s.charAt(i), 1);
            }
        }
        for(int i = 0; i < t.length(); i ++){
            if(map1.containsKey(t.charAt(i))){
                if(map1.get(t.charAt(i)) > 1){
                    map1.put(t.charAt(i), map1.get(t.charAt(i)) - 1);
                }else{
                    map1.remove(t.charAt(i));
                }
            }else{
                return false;
            }
        }
        for(int i = 0; i < s.length(); i ++){
            if(map1.get(s.charAt(i)) != null){
                return false;
            }
        }
        return true;
    }
}