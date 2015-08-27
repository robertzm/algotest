public class Solution {
    int[] result;
    Stack s = new Stack();
    List<List<String>> f = new ArrayList<List<String>>();
    
    public List<List<String>> solveNQueens(int n) {
        result = new int[n];
        Arrays.fill(result, 0);
        
        boolean[][] t = new boolean[n][n];
        for (boolean[] row: t){
            Arrays.fill(row, true);
        }

        s.push(t);
        
        determine(n, 0);
        return f;
    }
    
    private void determine(int n, int q){
        boolean[][] base = (boolean[][]) s.peek();
        if(q == n){
            insertANS(result);
            return;
        }
        for(int i = 0; i < n; i ++){
            boolean[][] tmp;
            if(base[q][i]){
                result[q] = 1 << (n - i - 1);
                tmp = setFalse(base, q, i);
                s.push(tmp);
                determine(n, q+1);
            }
        }
        s.pop();
        return;
    }
    
    private boolean[][] setFalse(boolean[][] t, int r, int c){
        int n = t.length;
    	boolean[][] result = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            result[i] = Arrays.copyOf(t[i], n);
        }
        for(int i = 0; i < n; i ++){
            result[r][i] = false;
        }
        for(int i = 0; i < n; i ++){
            result[i][c] = false;
        }
        for(int i = 0; r - i >= 0 && c + i < n; i ++){
            result[r-i][c+i] = false;
        }
        for(int i = 0; r - i >= 0 && c - i >= 0; i ++){
            result[r-i][c-i] = false;
        }
        for(int i = 0; r + i < n && c + i < n; i ++){
            result[r+i][c+i] = false;
        }
        for(int i = 0; r + i < n && c - i >= 0; i ++){
            result[r+i][c-i] = false;
        }
        return result;
    }
    
    private void insertANS(int[] r){
        List<String> tmp = new ArrayList<String>();
        for(int i = 0; i < r.length; i ++){
            String line = "";
            for(int j = 0; j < r.length; j++){
                int t = r[i] >> j;
                if(t == 1){
                    line = "Q" + line;
                }else{
                    line = "." + line;
                }
            }
            tmp.add(line);
        }
        f.add(tmp);
    }
}