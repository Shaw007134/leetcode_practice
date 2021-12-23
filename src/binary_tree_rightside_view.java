import java.util.ArrayList;
import java.util.List;

class binary_tree_rightside_view {
    public class TreeNode {
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

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();;
        List<Integer> left = this.rightSideView(root.left);
        List<Integer> right = this.rightSideView(root.right);
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        for(int i = 0; i < right.size(); i++){
            res.add(right.get(i));
        }
        for(int i = right.size(), sz = left.size(); i < sz; i++){
            res.add(left.get(i));
        }
        return res;
    }
}

