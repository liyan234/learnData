package 二叉树的题;


// 遍历二叉树的最大深度
public class maxDepth {
    public int maxDepth(TreeNode root) {
        return help(root);
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(help(root.left) + 1, help(root.right) + 1 );
    }
}
