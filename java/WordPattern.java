public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if(pattern.length() != strArray.length) return false;
        HashMap<Character, String> hm = new HashMap<Character, String>();
        for(int i = 0; i < pattern.length(); i ++){
            if(hm.containsKey(pattern.charAt(i))){
                if(!hm.get(pattern.charAt(i)).equals(strArray[i])) return false;
            }else{
                if(hm.containsValue(strArray[i])) return false;
                hm.put(pattern.charAt(i), strArray[i]);
            }
        }
        return true;
    }
}