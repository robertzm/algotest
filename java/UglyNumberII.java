public class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0){
            return 0;
        }
        TreeSet<Long> ts = new TreeSet<Long>();
        long tmp = 1;
        ts.add((long)1);
        for(int i = 0; i < n; i ++){
            tmp = ts.pollFirst();
            ts.add(tmp * 2);
            ts.add(tmp * 3);
            ts.add(tmp * 5);
        }
        return (int)tmp;
    }
}