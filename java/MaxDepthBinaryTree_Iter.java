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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int depth = 1, upper = 1, lower = 0;
        while(q.peek() != null){
            if(q.peek().left != null){
                q.add(q.peek().left);
                lower++;
            }
            if(q.peek().right != null){
                q.add(q.peek().right);
                lower++;
            }
            q.remove();
            upper --;
            if(upper == 0){
                if(lower != 0){
                    depth++;
                    upper = lower;
                    lower = 0;
                }
            }
        }
        return depth;
    }
}