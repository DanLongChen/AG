package L2019_5_29;

/**
 * Created by DanLongChen on 2019/5/29
 * 从中序后续中恢复二叉树
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 **/
public class L106 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0 || postorder.length==0){
            return null;
        }
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        if (inStart>inEnd || postStart>postEnd){
            return null;
        }
        int rootVal=postorder[postEnd];
        int inIndex=0;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==rootVal){
                inIndex=i;
                break;
            }
        }
        int length=inIndex-inStart;//表示中序中的左子树的长度（用此来划分左右子树的后序遍历）
        TreeNode root=new TreeNode(rootVal);
        root.left=build(inorder,inStart,inIndex-1,postorder,postStart,postStart+length-1);
        root.right=build(inorder,inIndex+1,inEnd,postorder,postStart+length,postEnd-1);
        return root;

    }
}
