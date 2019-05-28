package L2019_5_28;

/**
 * Created by DanLongChen on 2019/5/28
 **/

/**
 * 从前序和中序遍历构造二叉树
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class L105 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * 使用递归，不断划分左右子树
         */
        int prelength=preorder.length;
        int inlength=inorder.length;
        return buildTree(preorder,0,prelength-1,inorder,0,inlength-1);
    }
    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if (preStart>preEnd || inStart>inEnd){
            return null;
        }
        int rootVal=preorder[preStart];
        int orderIndex=0;
        int len=0;
        for (int i=inStart;i<=inEnd;i++){//找到子树的根节点在中序中的位置，并且记录其查找的长度（从inStart到index的长度）
            if (inorder[i]==rootVal){
                orderIndex=i;//记录下当前子树的根节点在中序中的位置（为了划分子树）
                break;
            }
        }
        len=orderIndex-inStart;//记录当前子树的左子树的长度
        TreeNode root=new TreeNode(rootVal);
        root.left=buildTree(preorder,preStart+1,preStart+len,inorder,inStart,orderIndex-1);
        root.right=buildTree(preorder,preStart+len+1,preEnd,inorder,orderIndex+1,inEnd);
        return root;
    }
}
