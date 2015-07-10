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
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        findDepth(root, 1);
        return balanced;
    }
    
    private int findDepth (TreeNode node, int level){
        if(!balanced || node == null){
            return level - 1;
        }
        int depthL = findDepth(node.left, level+1);
        int depthR = findDepth(node.right, level+1);
        int max = Math.max(depthL, depthR);
        int min = Math.min(depthL, depthR);
        if(max - min > 1){
            balanced = false;
        }
        return max;
    }
}