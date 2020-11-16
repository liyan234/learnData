package 二叉树的题;


// 一棵树是另一颗的子树
// 遍历两棵树
public class isSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return judge(s, t);
    }

    private boolean judge(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        // 必须递归这个树的左子树和右子树
        // 然后来判断根节点

        return judge(s.left, t) ||judge(s.right, t) ||
                helpJudge(s, t);
    }

    private boolean helpJudge(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return helpJudge(s.left, t.left) && helpJudge(s.right, t.right);
    }
}
