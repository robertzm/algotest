/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n <= 0 || isBadVersion(n) == false){
            return 0;
        }
        if(isBadVersion(1)){
            return 1;
        }
        int i, j;
        for(i = 1, j = n; i < j-1;){
            int tmp = i + (j-i) / 2;
            if(isBadVersion(tmp)){
                j = tmp;
            }else{
                i = tmp;
            }
        }
        return j;
    }
}