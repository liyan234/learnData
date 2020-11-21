package 二叉树的题2;

public class treeToStr {

    // 根据二叉树的前序遍历  构建出一个字符串

    public static String tree2str(TreeNode t) {
        // 解题思路

        // t == null 为终止条件
        if (t == null) {
            return "";
            // 返回的为空字符串
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
            // 左右子树为空的时候
        }
        //只有左子树为空的时候
        if (t.left == null) {
            return t.val + "()" + "(" + tree2str(t.right) + ")";
        }
        //只有右子树为空的时候
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        // 左右子树都不为空的时候
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }


    // 第二种 解法
    StringBuilder str = new StringBuilder();
    public String tree3Str(TreeNode t) {

            if (t == null) {
                return"" ;
            }

            helpBuild(t);

            // 删除第一个 "("
            str.deleteCharAt(str.length() - 1);
            // 删除结尾的 ")"
            str.deleteCharAt(0);
            return String.valueOf(str);
    }

    private void helpBuild(TreeNode t) {

        if (t == null) {
            return;
        }

        str.append("(");
        str.append(t.val);

        helpBuild(t.left);
        if(t.left == null && t.right != null) {
            str.append("()");
        }

        helpBuild(t.right);
        str.append(")");
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

        System.out.println(  tree2str(t1));
    }
}
