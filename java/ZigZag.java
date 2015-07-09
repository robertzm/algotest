public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        // return original string case
        if(len <= numRows || numRows == 1)
            return s;
        // return new string
        String newS = "";
        for( int i = 0; i < numRows; i ++){
            // first and last row characters
            if(i == 0 || i == numRows - 1){
                for( int j = 0; i+(numRows-1)*2*j < len; j++){
                    newS += s.charAt(i+(numRows-1)*2*j);   
                }
            }else{
                // others
                for(int j = 0; ; j++){
                    int tmp = i+(numRows-1)*2*j;
                    if(tmp >= len)
                        break;
                    else
                        newS += s.charAt(tmp);
                    tmp += (numRows-i-1)*2;
                    if(tmp >= len)
                        break;
                    else
                        newS += s.charAt(tmp);
                }
            }
        }
        return newS;
    }
}