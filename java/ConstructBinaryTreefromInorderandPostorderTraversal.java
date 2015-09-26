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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        int t = postorder[postorder.length-1];
        TreeNode root = new TreeNode(t);
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == t){
                root.left = buildTree( Arrays.copyOfRange(inorder, 0, i),  Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree( Arrays.copyOfRange(inorder, i+1, inorder.length),  Arrays.copyOfRange(postorder, i, postorder.length-1));
                return root;
            }
        }
        return null;
    }
}