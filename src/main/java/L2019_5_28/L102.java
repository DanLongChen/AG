package L2019_5_28;

/**
 * Created by DanLongChen on 2019/5/28
 **/

import L2019_5_27.L101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 逐层将二叉树放入列表中
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class L102 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
         * 层次遍历
         */
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root==null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int length=queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<length;i++){
                TreeNode temp=queue.poll();
                list.add(temp.val);
                if (temp.left!=null)
                    queue.offer(temp.left);
                if (temp.right!=null)
                    queue.offer(temp.right);
            }
            result.add(list);
        }
        return result;
    }
}
