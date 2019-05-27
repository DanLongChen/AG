package L2019_5_27;

/**
 * Created by DanLongChen on 2019/5/27
 **/

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树的深度
 */
public class L104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        /**
         * 递归，或者层次便利
         */
        if (root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;//计数从第一层开始
    }
    public int maxDepth1(TreeNode root) {
        /**
         * 层次便利
         */
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height=1;
        while (!queue.isEmpty()){
            int length=queue.size();//记录下当前层的宽度，然后把该层的子节点全部放入队列
            for (int i=0;i<length;i++){
                TreeNode temp=queue.peek();
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
                queue.poll();
            }
            height++;
        }
        return height;

    }
}
