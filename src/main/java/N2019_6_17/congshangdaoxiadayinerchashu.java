package N2019_6_17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by DanLongChen on 2019/6/17
 * 从上到下打印二叉树（层次遍历）
 **/
public class congshangdaoxiadayinerchashu {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        /**
         * 基本思路就是层次遍历，遍历的结果输入到List中
         */
        ArrayList<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return null;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int length=queue.size();
            for(int i=0;i<length;i++){
                TreeNode temp=queue.poll();
                result.add(temp.val);
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
        return result;
    }
}
