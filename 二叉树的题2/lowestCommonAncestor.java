package 二叉树的题2;

// 公共祖先
// 两个结点交叉到一起最近的那个点
// 公共祖先可以是其中一个结点的他本身

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p, TreeNode q) {

        // 终止条件
        if (root == null) {
            return null;
        }
        if (root == p) {
            return root;
        }
        if (root == q) {
            return root;
        }
        // 遍历这个根结点的左子树
        // 当返回的时候 不是 p q 本身就是 root
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 遍历这个根结点的右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 当左子树为空的时候 则两个结点都在右子树中
        if (left == null) {
            return right;
        }
        // 当右子树为空的时候 两个结点都在左子树中
        if (right == null) {
            return left;
        }
        // 左右子树都不为空的时候 根结点就是我们最近公共祖先
        return root;
    }
}
