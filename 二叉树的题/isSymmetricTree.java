package 二叉树的题;

// 这个二叉树是否镜像对称
//
public class isSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helpJudge(root.left, root.right);
    }

    private boolean helpJudge(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null) {
            return false;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helpJudge(left.left, right.right) && helpJudge(left.right, right.left);
    }
}
