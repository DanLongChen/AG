package L2019_7_21;

/**
 * Created by Paser on 2019/7/21.
 * 二叉排序树转化为累加树
 */
public class L538 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        /**
         * 先往右搜索，搜索到最后返回值作为当前结点的值，再往左搜索
         */
        convertBST(root.right);
        sum+=root.val;
        root.val=sum;
        convertBST(root.left);
        return root;
    }
}
