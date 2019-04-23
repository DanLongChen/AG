package L2019_4_22;

import java.util.Stack;

/**给定两个二叉树，判断两者是否相等
 * Created by DanLongChen on 2019/4/22
 **/
public class L100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;//直接返回，免去申请栈
        }
        /**
         * 使用栈代替递归
         */
        Stack<TreeNode[]> stack=new Stack<>();
        stack.push(new TreeNode[]{p,q});
        while (!stack.isEmpty()){
            TreeNode[] temp=stack.pop();
            if (temp[0]==null && temp[1]==null){
                continue;
            }
            if(temp[0]==null || temp[1]==null){
                return false;
            }
            if(temp[0].val!= temp[1].val){
                return false;
            }
            stack.push(new TreeNode[]{temp[0].left,temp[1].left});
            stack.push(new TreeNode[]{temp[0].right,temp[1].right});
        }
        return stack.isEmpty();

    }
    public boolean handler(TreeNode p,TreeNode q){
        if (p.val!=q.val){
            return false;
        }
        /**
         * 两者都有左子树，那么继续比较
         */
        if (p.left!=null && q.left!=null){
            handler(p.left,q.left);
        }else{
            if(p.left==null&&q.left!=null || p.left!=null&&q.left==null)
            return false;//否则，判定两棵树不相等
        }
        /**
         * 两者都有右子树，那么继续比较
         */
        if (p.right!=null && q.right!=null){
            handler(p.right,q.right);
        }else{
            if (p.right==null&&q.right!=null || p.right!=null&&q.right==null)
            return false;
        }
        return true;
    }
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
}
