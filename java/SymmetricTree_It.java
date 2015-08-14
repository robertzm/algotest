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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        String left = "", right = "";
        left += root.val;
        right += root.val;
        
        q.add(root);
        while(q.peek() != null){
            if(q.peek().left != null){
                q.add(q.peek().left);
                left += q.peek().left.val;
            }else{
                left += "#";
            }
            if(q.peek().right != null){
                q.add(q.peek().right);
                left += q.peek().right.val;
            }else{
                left += "#";
            }
            q.remove();
        }
        
        q.add(root);
        while(q.peek() != null){
            if(q.peek().right != null){
                q.add(q.peek().right);
                right += q.peek().right.val;
            }else{
                right += "#";
            }
            if(q.peek().left != null){
                q.add(q.peek().left);
                right += q.peek().left.val;
            }else{
                right += "#";
            }
            q.remove();
        }
        
        return left.equals(right);
    }

}