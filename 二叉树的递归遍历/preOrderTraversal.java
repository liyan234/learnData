package 二叉树的递归遍历;

import java.util.ArrayList;
import java.util.List;



// 二叉树的前序遍历
// 父 左 右
public class preOrderTraversal {

    // 父左 右
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    // 父左右
    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //先添加父亲结点
        list.add(root.val);
        //然后遍历左子树
        preOrder(root.left, list);
        //然后遍历右子树
        preOrder(root.right, list);
    }

}
