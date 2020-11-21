package 二叉树的题2;

import java.util.HashMap;
import java.util.Map;

public class buildTreeAboutPostAndIn {

    // 一个后序遍历和中序遍历 构建一个二叉树
    // 后序遍历就是 左 右 父
    // 中序遍历就是 左 父 右

    // 引入一个值 来确定 父亲结点是啥
    public int par;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) {
            return null;
        }

        // 根据数据找到下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        par = postorder.length - 1;
        // 返回一个树
        return helpBuildTree(inorder, postorder, 0, inorder.length, map);
    }

    private TreeNode helpBuildTree(int[] inorder, int[] postorder, int i_start, int i_end, Map<Integer, Integer> map) {
        if (i_start >= i_end) {
            return null;
        }
        if (par < 0) {
            return null;
        }
        // 获取到父亲结点
        int val = postorder[par];
        TreeNode root = new TreeNode(val);
        // 获取到父亲结点在中序遍历的位置
        Integer index = map.get(val);
        // 左子树的长度
        int len = index - i_start;
        // 父亲结点应该减一
        par = par - 1;

        // 我们先得父亲结点 然后获取到右孩子 再获取到左孩子  若是左右颠倒的话 获取到的结果一定错误
        // 后序遍历 时 左 右 父 递归就是到着来嘛
        // 一定安顺寻来  先获取右子树
        root.right = helpBuildTree(inorder, postorder, len+ i_start + 1, i_end, map);
        // 然后获取左子树
        root.left = helpBuildTree(inorder, postorder, i_start, len + i_start, map);
        return root;

    }
}
