public class Solution {
    public boolean isNumber(String s) {
        while(s.charAt(0) == ' '){
            s = s.substring(1, s.length());
            if(s.length() == 0) return false;
        }
        while(s.charAt(s.length()-1) == ' '){
            s = s.substring(0, s.length()-1);
            if(s.length() == 0) return false;
        }

        int e = s.indexOf('e');
        if(e == -1) return isFloat(s);
        else if(e == 0 || e == s.length()-1) return false;
        else
            return isFloat(s.substring(0, e)) && isInt(s.substring(e+1, s.length()));
    }
    
    public boolean isFloat(String s){
        if(s.length() == 0) return false;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1, s.length());
        if(s.length() == 0) return false;
        
        int p = s.indexOf('.');
        if(p == -1) return isInt(s);
        else if(p == 0 && p == s.length()-1) return false;
        else{
            if(p == 0) return isUnsignedInt(s.substring(p+1, s.length()));
            else if(p == s.length()-1) return isInt(s.substring(0, p));
            else
                return isInt(s.substring(0, p)) && isUnsignedInt(s.substring(p+1, s.length()));
        }
    }
    
    public boolean isInt(String s){
        if(s.length() == 0) return false;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1, s.length());
        if(s.length() == 0) return false;
        return isUnsignedInt(s);
    }
    
    public boolean isUnsignedInt(String s){
        String numeric = "1234567890";
        for(int i = 0; i < s.length(); i ++){
            if(numeric.indexOf(s.charAt(i)) == -1) return false;
        }
        return true;
    }
}