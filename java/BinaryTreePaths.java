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
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }else if(root.left == null && root.right == null){
            List<String> result = new ArrayList<String>();
            result.add(""+root.val);
            return result;
        }else if(root.left != null && root.right == null){
            return addRoot1(root.val, binaryTreePaths(root.left));
        }else if(root.left == null && root.right != null){
            return addRoot1(root.val, binaryTreePaths(root.right));
        }else{
            return addRoot2(root.val, binaryTreePaths(root.left), binaryTreePaths(root.right));
        }
    }
    
    private List<String> addRoot1(int val, List<String> childPaths){
        int size = childPaths.size();
        for(int i = 0; i < size; i ++){
            childPaths.set(i, val + "->" + childPaths.get(i));
        }
        return childPaths;
    }
    
    private List<String> addRoot2(int val, List<String> leftPaths, List<String> rightPaths){
        int size = leftPaths.size();
        for(int i = 0; i < size; i ++){
            leftPaths.set(i, val + "->" + leftPaths.get(i));
        }
        size = rightPaths.size();
        for(int i = 0; i < size; i ++){
            leftPaths.add(val + "->" + rightPaths.get(i));
        }
        return leftPaths;
    }
}