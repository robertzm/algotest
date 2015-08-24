/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> st = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        while(root != null){
            st.push(root);
            root = root.left;
        }    
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.empty();
    }

    /** @return the next smallest number */
    public int next() {
        if(st.empty()){
            return 0;
        }
        TreeNode cur = st.pop();
        int result = cur.val;
        TreeNode tmp = cur.right;
        while(tmp != null){
            st.push(tmp);
            tmp = tmp.left;
        }
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */