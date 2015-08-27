public class Solution {
    public String longestPalindrome(String s) {
        String manacherStr = preProcess(s);
    
        int center = 0;
        int radius = 0;
        int[] manacherP = new int[manacherStr.length()];
        for(int i = 1; i < manacherStr.length() - 1; i++){
            int iMirror = 2 * center - i;
    
            if(iMirror >= 0 && iMirror < manacherStr.length()){
                manacherP[i] = radius > i ? Math.min(radius - i, manacherP[iMirror]) : 0;
            }
    
            int left = i - 1 - manacherP[i];
            int right = i + 1 + manacherP[i];
            while(manacherStr.charAt(left) == manacherStr.charAt(right)){
                left--;
                right++;
                manacherP[i]++;
    
                if(left < 0 || right >= manacherStr.length()){
                    break;
                }
            }
    
            if(i + manacherP[i] > radius){
                center = i;
                radius = i + manacherP[i];
            }
        }
    
        int maxLen = 0;
        int centerIndex = 0;
        for(int i = 1; i < manacherStr.length() - 1; i++){
            if(manacherP[i] > maxLen){
                maxLen = manacherP[i];
                centerIndex = i;
            }
        }
    
        int start = (centerIndex - maxLen - 1) / 2;
        int end = start + maxLen;
        return s.substring(start, end);
    }

    private String preProcess(String s){
        if(s.length() == 0){
            return "^$";
        }
    
        StringBuilder sb = new StringBuilder("^");
    
        for(int i = 0; i < s.length(); i++){
            sb.append("#" + s.charAt(i));
        }
    
        sb.append("#$");
    
        return sb.toString();
    }
}