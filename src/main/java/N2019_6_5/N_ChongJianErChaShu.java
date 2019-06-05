package N2019_6_5;

/**
 * Created by DanLongChen on 2019/6/5
 * 根据先序和中序重建二叉树
 **/
public class N_ChongJianErChaShu {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        /**
         * 使用递归，不断划分二叉树
         */
        int pstart=0;
        int pend=pre.length-1;
        int instart=0;
        int inend=in.length-1;
        return handler(pre,pstart,pend,in,instart,inend);

    }
    public TreeNode handler(int[] pre,int pstart,int pend,int[] in,int instart,int inend){
        if (pstart>pend || instart>inend){
            return null;
        }
        int rootVal=pre[pstart];
        /**
         * 然后在in中找到rootVal的下标
         */
        int inIndex=0;
        for (int i=instart;i<=inend;i++){
            if(in[i]==rootVal){
                inIndex=i;
                break;
            }
        }
        int len=inIndex-instart;//左子树的长度
        TreeNode root=new TreeNode(rootVal);
        root.left=handler(pre,pstart+1,pstart+len,in,instart,inIndex-1);
        root.right=handler(pre,pstart+len+1,pend,in,inIndex+1,inend);
        return root;
    }
}
