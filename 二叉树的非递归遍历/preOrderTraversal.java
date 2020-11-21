package 二叉树的非递归遍历;



import java.util.*;

public class preOrderTraversal {
    // 二叉树的前序遍历  父 左  右
    // 迭代实现
    // 原理怎木说呢
    // 就是用一个栈去递归实现
    public static List<Integer> preorderTraversal(TreeNode root) {
        // 用栈的思路
        // 把右子树先压入栈中 ，然后把左子树压入栈中
        // 然后顺序出栈
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        //
        if (root == null) {
            return null;
        }

        // 栈是先进后出 所以右子树在前， 左子树在后
        stack.push(root);
        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }



    // 优化
    public List<Integer> preorderTraversal2(TreeNode root) {
        // 用栈的思路
        // 把右子树先压入栈中 ，然后把左子树压入栈中
        // 然后顺序出栈
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        //
        if (root == null) {
            return list;
        }

        // 栈是先进后出 所以右子树在前， 左子树在后
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {

            // 一直从左边下去
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            // 左边循环完了
            // 这个结点 出栈的时候 判断一下右边是否有值
            node = stack.pop();
            node = node.right;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1) ;
        TreeNode t2 = new TreeNode(2) ;
        TreeNode t3 = new TreeNode(3) ;
        TreeNode t4 = new TreeNode(4) ;

        t1.left = t2;
        t2.left = t3;
        t1.right = t4;

        List<Integer> list = preorderTraversal(t1);
        System.out.println(list);

    }
}
