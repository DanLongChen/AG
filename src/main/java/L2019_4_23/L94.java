package L2019_4_23;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代实现中序
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * Created by DanLongChen on 2019/4/23
 **/
public class L94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            /**
             * 一直向左子树寻找
             */
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                stack.pop();
                result.add(p.val);
                p = p.right;
            }
        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p = root;
        p.left = new TreeNode(2);
        p = p.left;
        p.left = new TreeNode(4);
        p.right = new TreeNode(5);
        p = root;
        p.right = new TreeNode(3);
        List<Integer> result = new L94().inorderTraversal(root);
        System.out.println(result);
    }
}
