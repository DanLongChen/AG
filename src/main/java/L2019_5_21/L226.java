package L2019_5_21;

/**
 * Created by DanLongChen on 2019/5/21
 **/

/**
 * 反转二叉树，将二叉树的左右子树互换
 */
public class L226 {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode treeNode){
        if (treeNode!=null){
            TreeNode temp=treeNode.left;
            treeNode.left=treeNode.right;
            treeNode.right=temp;
            dfs(treeNode.left);
            dfs(treeNode.right);
        }else{
            return;
        }
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
