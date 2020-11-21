package 二叉树的非递归遍历;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树的后序遍历
// 左 右 父
// 这个就有一点不一样了
public class postOrderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 取出 判断这个右子树是否为空
            // 为空则将其压入栈中
            cur = stack.pop();
            if (cur.right == null || cur.right == pre) {
                list.add(cur.val);
                pre = cur;
                // 让cur为null 则 不会进入第二个while循环
                // 就会直接从栈中取出接下来的结点
                // 并且用pre记忆这个结点
                cur = null;
            } else {
                stack.push(cur);
                cur = cur.right;
            }
        }
        return list;
    }
}
