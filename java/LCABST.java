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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if((root == p && containNode(root, q)) || (root == q && containNode(root, p))){
            return root;
        }else if((containNode(root.left, p) && containNode(root.right, q)) || (containNode(root.left, q) && containNode(root.right, p))){
            return root;
        }else if(containNode(root.left, p) && containNode(root.left, q)){
            return lowestCommonAncestor(root.left, p, q);
        }else if(containNode(root.right, p) && containNode(root.right, q)){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return null;
        }
    }
    
    private boolean containNode(TreeNode root, TreeNode p){
        if(root == null){
            return false;
        }else if(root == p){
            return true;
        }else if(root.left == null && root.right == null){
            return false;
        }else if(root.left != null && root.right == null){
            return containNode(root.left, p);
        }else if(root.left == null && root.right != null){
            return containNode(root.right, p);
        }else{
            return containNode(root.left, p) || containNode(root.right, p);
        }
    }
}