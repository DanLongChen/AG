package N2019_6_13;

/**
 * Created by DanLongChen on 2019/6/13
 * 树的子结构，判断一棵树是不是另外一棵树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 **/
public class shudezijiegou {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null || root1==null&& root2!=null){
            return false;
        }
        boolean flag=false;
        if(root1.val==root2.val){
            flag=handler(root1,root2);
        }
        if (!flag){
            flag=HasSubtree(root1.left,root2);//判断左子树
            if(!flag){
                flag=HasSubtree(root1.right,root2);//再判断右子树
            }
        }
        return flag;
    }
    public boolean handler(TreeNode root1,TreeNode root2){
        if (root2==null){
            return true;
        }
        if(root1==null && root2!=null){
            return false;
        }
        if(root1.val==root2.val){
            return handler(root1.left,root2.left) && handler(root1.right,root2.right);
        }else{
            return false;
        }
    }
}
