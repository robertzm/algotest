// test valid sudoku
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean result = true;
        
        List<Map<Character, Integer>> myMap  = new ArrayList<Map<Character, Integer>>();
        for(int i = 0; i < 27; i++){
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            myMap.add(i, map);
        }
        
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j ++){
                if(board[i][j] == '.'){
                    continue;
                }else{
                    if(myMap.get(i).containsKey(board[i][j])){
                        return false;
                    }else{
                        myMap.get(i).put(board[i][j], Character.getNumericValue(board[i][j]));
                    }
                    if(myMap.get(9+j).containsKey(board[i][j])){
                        return false;
                    }else{
                        myMap.get(9+j).put(board[i][j], Character.getNumericValue(board[i][j]));
                    } 
                    if(myMap.get(18+(i/3)*3+j/3).containsKey(board[i][j])){
                        return false;
                    }else{
                        myMap.get(18+(i/3)*3+j/3).put(board[i][j], Character.getNumericValue(board[i][j]));
                    } 
                }
            }
        }
        return true;
    }
}