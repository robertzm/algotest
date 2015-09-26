/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cur = 1, next = 0;
        boolean even = true;
        ArrayList<Integer> tmp = new ArrayList<>();
        int i = 0;
        while(q.peek() != null){
            TreeNode tTmp  = q.poll();
            if(tTmp.left != null) {q.add(tTmp.left);next++;}
            if(tTmp.right != null) {q.add(tTmp.right);next++;}
            
            if(even){
                tmp.add(tTmp.val);
            }else{
                tmp.add(0, tTmp.val);
            }
            i++;
            if(i == cur){
                result.add(tmp);
                cur = next;
                next = 0;
                i = 0;
                tmp = new ArrayList<>();
                even = !even;
            }
        }
        return result;
    }
}