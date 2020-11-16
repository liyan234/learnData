package 二叉树的递归遍历;

import java.util.ArrayList;
import java.util.List;

// 二叉树的后序遍历
public class postOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        help(list, root);
        return list;
    }

    // 左 右 父
    private void help(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        // 遍历左子树 直到没有左孩子的时候 返回
        help(list, root.left);
        // 遍历右子树 直到没有右孩子的时候 返回
        help(list, root.right);
        //
        list.add(root.val);
    }
}
