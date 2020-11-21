package 二叉树的题2;

import java.util.HashMap;

public class buildTreeAboutPreAndIn {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 二叉树的前序遍历 父 左 右 3，9，20，15，7
        // 二叉树的中序遍历 左 父 右 9，3，15，20，7
        // 二叉树的后序遍历 左 右 父 9，15，7，20，3


        //  获取到了二叉树的前序遍历和中序遍历
        //  然后取构建一个树
        if (preorder == null || inorder == null) {
            return null;
        }
        // 我们每次所需要做的就是找出数组中的根节点
        // 然后根据中序遍历的特点 区分出左右子树
        // 区分出左右子树之后然后可以做的就是递归构建左右子树
        // 我们构建一个hashMap来存储 中序遍历 数组的下标
        // 我们就可以知道所得到的根结点的下标 以此来区分数组中的值应该是在左边还是右边
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helpBuildTree(preorder, 0 , preorder.length,
                inorder, 0, inorder.length, map);
    }

    private TreeNode helpBuildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iBefore, int iAfter, HashMap<Integer, Integer> map) {
        // 当前序遍历的数组开始下标和结束下标相等的时候
        // 证明这一部分数组遍历完毕
        if (pStart == pEnd) {
            return null;
        }
        // 前序遍历的开始就是树的根节点
        int val = preorder[pStart];
        TreeNode root = new TreeNode(val);
        // 获取这个根节点 应该在中序遍历的哪个位置
        int index = map.get(val);
        // 获取中序遍历的时候 其左边有几个数
        int num = index - iBefore;
        // 左子树在那个位置
        root.left = helpBuildTree(preorder, pStart + 1, pStart + num + 1,
                inorder, iBefore, index + 1, map);
        // 右子树在哪个位置
        root.right = helpBuildTree(preorder, pStart + num + 1, pEnd,
                inorder, index + 1, iAfter, map);

        return root;
    }
}
