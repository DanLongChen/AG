package L2019_7_4;

/**
 * Created by DanLongChen on 2019/7/4
 * 跳跃游戏
 *
 **/
public class L55 {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(new L55().canJump2(nums));
    }
    public boolean canJump(int[] nums) {
        /**
         * 顺藤摸瓜（贪心）：从先往后进行查找，查找当前点可以到达的最远距离
         */
        //贪心法：每一次跳跃从自己能调到的范围内再选一个跳跃到最远的节点落下
        if(nums==null || nums.length==0){
            return false;
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(max>=nums.length-1){
                return true;
            }
            if(i<=max){//因为已经可以到max这个位置了，所以之前的i都是可以更新的（查看是否可以到达更远）
                max=Math.max(max,i+nums[i]);
            }
        }
        return false;
    }
    public boolean canJump1(int[] nums) {
        /**
         * 动态规划:DP[i]表示下标i起跳可以到达的最远的点
         * DP[i]=Max(Dp[i-1],i+nums[i])  前一种情况是在当前点起跳还不如前面一个点起跳来的远
         */
        if(nums.length==1){
            return true;
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]<i){//i-1步不能到达当前点(前一步不能到达当前点)
                return false;
            }
            dp[i]=Math.max(dp[i-1],i+nums[i]);
            if(dp[i]>=nums.length-1){
                return true;
            }
        }
        return false;
    }
    public boolean canJump2(int[] nums) {
        //顺瓜摸藤
        //从后面开始判断，找到可以跳到当前点的前一个点，然后以当前点作为重点再继续往前找
        int position=nums.length-1;
        boolean flag;//表示可以跳到
        while(position>0){
            flag=false;
            for(int i=position-1;i>=0;i--){
                if(i+nums[i]>=position){
                    position=i;
                    flag=true;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
}
