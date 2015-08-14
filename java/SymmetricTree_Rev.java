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
        return isSubSymm(root.left, root.right);
    }
    private boolean isSubSymm(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if((root1 != null && root2 == null) || (root1 == null && root2 != null)){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        if(!isSubSymm(root1.left, root2.right)){
            return false;
        }
        if(!isSubSymm(root1.right, root2.left)){
            return false;
        }
        return true;
    }
}