package 二叉树的非递归遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inOrderTraversal {

    // 中序遍历
    // 中序遍历就是 左 右 父
    // 也是利用栈来实现
    // 先添加右子树的

    // 后添加左子树的
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        TreeNode cur = root;

        //只要结点不为空，栈不为空
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 左子树遍历完了 之后 要出栈
            cur = stack.pop();
            // 将其加入到列表中
            list.add(cur.val);
            // 看他的右子树是否为空,遍历右子树
            cur = cur.right;
        }
        return list;
    }

}
