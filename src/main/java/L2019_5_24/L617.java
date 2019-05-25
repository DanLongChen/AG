package L2019_5_24;

/**
 * Created by DanLongChen on 2019/5/24
 **/

import javax.print.attribute.HashDocAttributeSet;

/**
 * 合并二叉排序树
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class L617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null && t2==null){
            return null;
        }
        int val=(t1==null?0:t1.val)+(t2==null?0:t2.val);
        TreeNode node = new TreeNode(val);
        node.left=mergeTrees(t1==null?t1 : t1.left,t2==null?t2 : t2.left);
        node.right=mergeTrees(t1==null?t1 : t1.right,t2==null?t2 : t2.right);
        return node;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
