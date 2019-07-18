package L2019_7_18;

/**
 * Created by DanLongChen on 2019/7/18
 * 二叉树转链表
 **/
public class L114 {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    private TreeNode last=null;
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        if(last!=null){
            last.left=null;
            last.right=root;
        }
        last=root;
        TreeNode copyRight=last.right;//有节点需要被保存一下，因为last.right=root
        flatten(last.left);
        flatten(copyRight);
    }
}
