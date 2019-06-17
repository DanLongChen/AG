package N2019_6_17;

import sun.util.resources.cldr.ebu.LocaleNames_ebu;

import java.util.ArrayList;

/**
 * Created by DanLongChen on 2019/6/17
 * 之字形按层顺序打印二叉树
 **/
public class zhizixingdayinerchashu {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        /**
         * 之字形顺序打印二叉树，第一层从左到右打印，第二层从右到左打印，依次进行
         * 也是使用队列来记录，添加一个标记用来标识当前是第几层，如果是奇数层，那么存进queue的顺序和list的顺序相同，否则存进queue的顺序为0~length，存进list的为length~0
         */
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(pRoot==null){
            return result;
        }
        ArrayList<TreeNode> queue=new ArrayList<>();
        queue.add(pRoot);
        int level=1;
        while (!queue.isEmpty()){
            int length=queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<TreeNode> newQueue=new ArrayList<>();
            if ((level & 1)==0){//标识偶数
                int index=length-1;
                for (int i = 0; i< length; i++){
                    TreeNode temp=queue.get(i);
                    list.add(queue.get(index--).val);
                    if(temp.left!=null){
                        newQueue.add(temp.left);
                    }
                    if(temp.right!=null){
                        newQueue.add(temp.right);
                    }
                }
                queue=newQueue;
            }else{
                for (int i = 0; i< length; i++){
                    TreeNode temp=queue.get(i);
                    list.add(temp.val);
                    if(temp.left!=null){
                        newQueue.add(temp.left);
                    }
                    if(temp.right!=null){
                        newQueue.add(temp.right);
                    }
                    temp=null;
                }
                queue=newQueue;
            }
            result.add(list);
            level++;
        }
        return result;
    }
}
