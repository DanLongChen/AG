package L2019_4_23;

/**唯一的二叉搜索树（给定一个数，求唯一的二叉搜索树的数目）
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * Created by DanLongChen on 2019/4/23
 **/
public class L96 {
    public int numTrees(int n) {
        /**
         * 使用递归，以i为根节点的时候，总的二叉排序树的总个数为左右两边的子树个数相乘
         */
        if (n<=1){
            return 1;
        }
        int sum=0;
        for (int i=1;i<=n;i++){
            sum+=numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }
    public int DP(int n){
        /**
         * 使用DP算法，当有n个数的时候，以其中一个数为根节点，剩下的数划分为两拨
         * 当祖先（根为数值为i时），左子树最大的数为i-1。于是左子树的元素个数可以从0增加到i-1。左边子树有i-1个节点，右边子树有
         */
        int[] DP=new int[n+1];
        DP[0]=1;
        for (int i=1;i<=n;i++){//总的节点数（当有一个节点的时候，两个节点的时候）
            for (int j=0;j<i;j++){//以第几个作为根节点(也就是左子树的个数)
                DP[i]+=DP[j]*DP[i-j-1];//除去左子树的节点个数还需要再除去根节点
            }
            System.out.println(DP[i]);
        }
        return DP[n];
    }

    public static void main(String[] args) {
        System.out.println(new L96().DP(3));
    }
}
