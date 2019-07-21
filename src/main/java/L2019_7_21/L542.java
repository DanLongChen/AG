package L2019_7_21;

/**
 * Created by Paser on 2019/7/21.
 * 二叉树的直径
 */
public class L542 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    private int result=0;
    public int diameterOfBinaryTree(TreeNode root) {
        //就是计算左右两边树的高度，然后加起来
        if(root==null){
            return 0;
        }
        dfs(root);
        return result;
    }
    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        result=Math.max(left+right,result);
        return Math.max(left,right)+1;

    }
}
