package L2019_7_22;

/**
 * Created by DanLongChen on 2019/7/22
 * 打家劫舍3
 **/
public class L337 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int rob(TreeNode root) {
        /**
         * 可以分为两类：一类是包含root节点的，一类是不包含root节点的
         */
        if(root==null){
            return 0;
        }
        int[] result=dfs(root);
        return Math.max(result[0],result[1]);
    }
    private int[] dfs(TreeNode root){
        int[] res=new int[2];//用来存放不包含root的，和包含root的结果值(res[0]不包含根节点，res[1]包含根节点)
        if(root==null){
            return res;
        }
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1]=left[0]+right[0]+root.val;
        return res;
    }
}
