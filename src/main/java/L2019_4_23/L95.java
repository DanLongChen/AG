package L2019_4_23;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanLongChen on 2019/4/23
 **/
public class L95 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<>();
        if (n == 0) return ret;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = i+1;
        return build(nums, 0, n-1);
    }

    private List<TreeNode> build(int[] nums, int l, int r) {
        List<TreeNode> list = new ArrayList<>();
        if (l >= r) { // bug - 2 => Arrays.asList(null) is illegal, we use list directly here;
            if (l > r) list.add(null); // sentry node used to reduce complexity;
            else list.add(new TreeNode(nums[l]));
            return list;
        }
        for (int i = l; i <= r; ++i) {
            List<TreeNode> lList = build(nums, l, i-1);
            List<TreeNode> rList = build(nums, i+1, r);
            for (TreeNode lNode: lList) {
                for (TreeNode rNode: rList) {
                    TreeNode root = new TreeNode(nums[i]);
                    root.left = lNode;
                    root.right = rNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
