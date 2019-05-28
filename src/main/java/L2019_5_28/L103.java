package L2019_5_28;

/**
 * Created by DanLongChen on 2019/5/28
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定二叉树，返回其节点值的Z字形级别遍历。 （即，从左到右，然后从右到左进行下一级别并在之间交替）
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class L103 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /**
         * 层次遍历，设置一个标记，用来判断是从左到右还是从右到左
         */
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int flag=-1;//true的话是从左到右，否则是从右到左
        if (root==null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int length=queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i=0;i<length;i++){
                TreeNode temp=queue.poll();
                if (flag==-1){
                    list.add(temp.val);
                }else{
                    list.addFirst(temp.val);
                }
                if (temp.left!=null)
                    queue.offer(temp.left);
                if (temp.right!=null)
                    queue.offer(temp.right);
            }
            flag=-flag;
            result.add(list);
        }
        return result;
    }
}
