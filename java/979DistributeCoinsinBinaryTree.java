class Solution {
    private int moves;
    public int distributeCoins(TreeNode root) {
        this.moves = 0;
        traverse(root);
        return moves;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftExcess = traverse(node.left);
        int rightExcess = traverse(node.right);
        int totalExcess = node.val + leftExcess + rightExcess - 1;
        moves += Math.abs(totalExcess);
        return totalExcess;
    }

}
