package didi;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by DanLongChen on 2019/8/27
 **/
public class L1 {

    public static int i = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner is = new Scanner(System.in);
        int n = Integer.parseInt(is.nextLine());
        String target = is.nextLine();
        i = 0;
        TreeNode<String> exp = null;
        String[] c = target.split(" ");
        System.out.println(Arrays.toString(c));
        exp = preMake(exp, c);
        StringBuilder sb = new StringBuilder();
        toPostExp(exp, sb);
        System.out.println(calcuPost(sb.toString()));
    }


    private static void toInExp(TreeNode<String> root, StringBuilder sb) {
        if (root != null) {
            toInExp(root.left, sb);
            sb.append(root);
            toInExp(root.right, sb);
        }
    }

    private static void toPostExp(TreeNode<String> root, StringBuilder sb) {
        if (root != null) {
            toPostExp(root.left, sb);
            toPostExp(root.right, sb);
            sb.append(root + " ");
        }
    }

    private static int calcuPost(String post) {
        Stack<Integer> stk = new Stack<>();
        String[] ss = post.split(" ");
        for (String s : ss) {
            if (s.matches("-?\\d+")) {
                int a = Integer.parseInt(s);
                System.out.println(a);
                stk.push(a);
            } else {
                char c = s.charAt(0);
                int b = stk.pop();
                int a = stk.pop();
                int t;
                if (c == '+')
                    t = a + b;
                else if (c == '-')
                    t = a - b;
                else if (c == '*')
                    t = a * b;
                else
                    t = a / b;
                stk.push(t);
            }
        }
        return stk.pop();
    }

    private static TreeNode<String> preMake(TreeNode<String> root, String[] c) {
        if (i == c.length)
            return null;
        if (c[i].matches("-?\\d+"))
            return new TreeNode<String>(c[i++]);
        else {
            root = new TreeNode<String>(c[i++]);
            root.left = preMake(root.left, c);
            root.right = preMake(root.right, c);
            return root;
        }
    }

}

class TreeNode<E> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E e) {
        this.element = e;
    }

    public String toString() {
        return element.toString();
    }
}

