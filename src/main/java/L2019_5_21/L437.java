package L2019_5_21;

/**
 * Created by DanLongChen on 2019/5/21
 **/

import sun.security.krb5.internal.rcache.DflCache;

/**
 * 给定一颗二叉树，在二叉树中寻找路径，路径上的元素相加为给定的sum，要求返回这样的路径数
 */
public class L437 {
    public int pathSum(TreeNode root, int sum) {
        /**
         * 使用DFS,分为两种情况（以root为开头的，不以root为开头的<root左子树，root右子树></>）
         */
        if (root==null){
            return 0;
        }
        return DFS(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    public int DFS(TreeNode root,int sum){
        if (root==null){
            return 0;
        }
        return (sum-root.val==0?1:0)+DFS(root.left,sum-root.val)+ DFS(root.right,sum-root.val);
    }
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
