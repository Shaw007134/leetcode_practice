class binary_tree_maximum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if(node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where node is the highest node
        int new_path = node.val + left_gain + right_gain;

        // update the max_sum
        max_sum = Math.max(max_sum, new_path);

        // return the max_gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root){
        max_gain(root);
        return max_sum;
    }
}
