package 二叉树的题2;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树的层序遍历
public class levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //用一个队列来形成先进先出的效果
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 先取出一个结点 创建一个链表 加入这个结点的值
        // 看这个结点是否有左右孩子
        // 若是有孩子 则把孩子加入到这个队列中
        // 我们也要判断当前队列的长度，也就是当前这个链表应该有几个值
        // 每一层都是由一个链表组成，然后把这个链表加入到这个链表中也就是树中
        while (!queue.isEmpty()) {
            // 新建一个链表
            List<Integer> curList = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                Integer x = node.val;
                curList.add(x);
            }
            list.add(curList);
        }
        return list;
    }
}
