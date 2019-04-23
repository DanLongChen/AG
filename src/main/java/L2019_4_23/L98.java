package L2019_4_23;

import javafx.scene.transform.Rotate;

import java.util.List;

/**给定一棵树，判断其是否是二叉搜索树
 * Created by DanLongChen on 2019/4/23
 **/
public class L98 {
    public boolean isValidBST(TreeNode root) {
        /**
         * 使用递归，每一个子树需要记下最开始的那个root的值，后面的值需要与这个值也进行比较
         */
        return handler(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean handler(TreeNode root,long low,long high){
        return root==null || root.val>low && root.val<high && handler(root.left,low,root.val) && handler(root.right,root.val,high);
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode p = root;
        p.left = new TreeNode(1);
//        p = p.left;
//        p.left = new TreeNode(4);
//        p.right = new TreeNode(5);
//        p = root;
        p.right = new TreeNode(3);
        System.out.println(new L98().isValidBST(root));
    }
}
