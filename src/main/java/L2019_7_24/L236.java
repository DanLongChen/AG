package L2019_7_24;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by DanLongChen on 2019/7/24
 * 二叉树的最近公共祖先
 **/
public class L236 {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    private TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //使用递归
        handler(root,p,q);
        return result;
    }
    public boolean handler(TreeNode current,TreeNode p,TreeNode q){
        if(current==null){
            return false;
        }
        int left=handler(current.left,p,q)?1:0;
        int right=handler(current.right,p,q)?1:0;
        int mid=(current==q || current==p)?1:0;
        if((left+right+mid)>=2){
            result=current;
        }
        return (left+right+mid)>0;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //使用非递归，用一个map记录子节点和父节点的关系，然后就是从p，q一直往上找，这样也就是在链表中找公共节点
        if(root==null){
            return null;
        }
        Map<TreeNode,TreeNode> map = new HashMap<>();
        map.put(root,null);
        helper(map,root);
        System.out.println(map);
        Set<TreeNode> set = new HashSet<>();
        while (p!=null){
            set.add(p);
            p=map.get(p);
        }

        while (q!=null){
            if(set.contains(q)){
                return q;
            }
            q=map.get(q);
        }
        return null;
    }
    private void helper(Map<TreeNode,TreeNode> map,TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null)
            map.put(root.left,root);
        if(root.right!=null)
            map.put(root.right,root);
        helper(map,root.left);
        helper(map,root.right);
    }
}
