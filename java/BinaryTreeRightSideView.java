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
    List<Integer> result = new ArrayList<Integer>();
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        result.add(root.val);
        
        int upper = 1, lower = 0;
        while(q.peek() != null){
            TreeNode cur = q.remove();
            upper --;
            if(cur.right != null){
                q.add(cur.right);
                lower ++;
            }
            if(cur.left != null){
                q.add(cur.left);
                lower ++;
            }
            if(upper == 0){
                upper = lower;
                lower = 0;
                if(q.peek() != null){
                    result.add(q.peek().val);
                }
            }
        }
        return result;
    }
}