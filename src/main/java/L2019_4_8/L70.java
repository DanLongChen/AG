package L2019_4_8;

/**爬阶梯，每一次只能爬一或者二，输入给定的是阶梯的高度
 * Created by DanLongChen on 2019/4/8
 **/
public class L70 {
    public int climbStairs(int n) {
        int[] result=new int[1];
        handler(result,n);
        return result[0];
    }

    /***
     * DP
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        /**
         * 通过观察可以知道，跳一级台阶的时候有1种跳法，二级的时候有两种，三级的时候有三种，四级的时候有五种
         */
        int[] result=new int[n+1];
        for(int i=1;i<=n;i++){
            if(i==1){
                result[i]=1;
                continue;
            }
            if(i==2){
                result[i]=2;
                continue;
            }
            result[i]=result[i-1]+result[i-2];
        }
        return result[n];
    }

    /**
     *迭代法 TODO 迭代答案是对的，但是有点慢
     * @param result    一共有多少种方法
     * @param n         还剩下多少台阶数
     * @return
     */
    public void handler(int[] result,int n){
        if(n==0){
            result[0]++;
            return;
        }
        if (n<0){
            return;
        }
        /**
         * 只能爬一阶或者二阶
         */
        for(int i=1;i<=2;i++){
            result[0]++;
            handler(result,n-i);
            result[0]--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new L70().climbStairs2(44));
    }
}
