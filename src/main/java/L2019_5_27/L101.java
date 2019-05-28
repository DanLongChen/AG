package L2019_5_27;

/**
 * Created by DanLongChen on 2019/5/27
 **/

import com.sun.deploy.panel.ITreeNode;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一颗二叉树，判断其是否为镜像二叉树
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class L101 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSymmetric(TreeNode root) {
        /**
         * 使用层次便利，首先判断其为第几层，每一层的节点数为2^(i-1)
         */
        if (root==null){
            return false;
        }
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();
        queue1.offer(root);
        boolean flag=false;
        int height=0;
        while (!queue1.isEmpty()){
            int length=queue1.size();
            for (int i=0;i<length;i++){
                TreeNode temp=queue1.poll();
                queue2.offer(temp.val);//记录下当前层次节点的数值
                if(temp.left!=null){
                    queue1.offer(temp.left);
                }
                if(temp.right!=null){
                    queue1.offer(temp.right);
                }
            }
            height++;
            if (flag==false){
                flag=true;
                continue;
            }else{
                if (queue2.size()!=Math.pow(2,(height-1))){
                    return false;
                }
                while (!queue2.isEmpty()){
                    int a=((LinkedList<Integer>) queue2).removeFirst();
                    int b=((LinkedList<Integer>) queue2).removeLast();
                    if (a!=b){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isSymmetric1(TreeNode root) {
        /**
         * 深搜
         */
        if(root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode n1,TreeNode n2){
        if (n1==null && n2==null){
            return true;
        }
        if (n1==null || n2==null){
            return false;
        }
        if (n1.val!=n2.val){
            return false;
        }
        return isMirror(n1.left,n2.right) && isMirror(n1.right,n2.left);
    }

}
