package 二叉树的递归遍历;


import java.util.ArrayList;
import java.util.List;

// 中序遍历
// 左 父 右
public class inOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        help(list, root);
        return list;
    }

    private void help(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        // 遍历左子树 当结点没有左孩子的时候 就会返回
        help(list, root.left);
        // 添加父亲结点
        list.add(root.val);
        // 遍历右子树 当节点没有右孩子的时候 就会返回
        help(list, root.right);
    }


}
