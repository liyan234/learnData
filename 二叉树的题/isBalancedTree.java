package 二叉树的题;

// 判断平衡二叉树
// 左右子树的高度差不超过1
public class isBalancedTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.right) &&
                isBalanced(root.left) &&
                Math.max(help(root.left), help(root.right))
                - Math.min(help(root.left), help(root.right)) <= 1;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归出子树中深度最大的一个
        return Math.max(help(root.left), help(root.right)) + 1;

    }
}
