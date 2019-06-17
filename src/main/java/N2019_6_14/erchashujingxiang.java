package N2019_6_14;

/**
 * Created by DanLongChen on 2019/6/14
 **/
public class erchashujingxiang {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public void Mirror(TreeNode root) {
        /**
         * 先序遍历，依次交换
         */
        if (root==null){
            return;
        }
        if (root.left==null && root.right==null){
            return;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
}
