package N2019_6_18;

import java.util.ArrayList;

/**
 * Created by DanLongChen on 2019/6/18
 * 二叉树中和为某一值的路径
 **/
public class erchashuzhongheweimouyilujing {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        handler(result,root,target,0,new ArrayList<>());
        return result;
    }
    public void handler(ArrayList<ArrayList<Integer>> result,TreeNode root,int target,int count,ArrayList<Integer> list){
        list.add(root.val);
        count+=root.val;
        if (count==target && root.left==null && root.right==null){
            result.add(new ArrayList<>(list));
        }
        if (root.left!=null){
            handler(result,root.left,target,count,list);
        }
        if(root.right!=null){
            handler(result,root.right,target,count,list);
        }
        list.remove(list.size()-1);
        return;
    }
}
