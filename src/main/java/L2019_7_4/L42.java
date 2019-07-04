package L2019_7_4;

/**
 * Created by DanLongChen on 2019/7/4
 * 接雨水
 **/
public class L42 {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new L42().trap2(height));
    }
    public int trap(int[] height) {
        /**
         * 按照每一列来求能接的雨水的多少，算当前求的列的左右两边的最大的高度，然后取两边高度的较小值，比较这个值与当前列的高度的差值，就是当前列能接的雨水的数量
         */
        int result=0;
        for(int i=1;i<height.length-1;i++){//两端的列都不用求，因为其不可能存在雨水
            int maxLeft=0,maxRight=0;
            int left=i-1,right=i+1;//从左右两端开始
            while(left>=0){
                maxLeft=Math.max(maxLeft,height[left]);
                left--;
            }
            while(right<height.length){
                maxRight=Math.max(maxRight,height[right]);
                right++;
            }
            int finalHeight=Math.min(maxLeft,maxRight);
            if(finalHeight>height[i]){
                result+=finalHeight-height[i];
            }
        }
        return result;
    }
    public int trap1(int[] height) {
        //使用DP，因为在暴力法中每一次都要向前（向后）搜索最大高度，那么我们可以将这个最大高度记录下来，使用两个数组来记录
        int result=0;
        int[] leftMaxDP=new int[height.length];//记录当前值i左边的最高的高墙的高度（不包括本身）
        int[] rightMaxDP=new int[height.length];//leftMaxDP[i]=Max(height[i-1],leftMaxDP[i-1]),rightMaxDP[i]=Max(height[i+1],rightMaxDP[i+1])
        for(int i=1;i<height.length;i++){//先求出两个DP数组中的值
            leftMaxDP[i]=Math.max(height[i-1],leftMaxDP[i-1]);
        }
        for(int i=height.length-2;i>=0;i--){
            rightMaxDP[i]=Math.max(height[i+1],rightMaxDP[i+1]);
        }
        for(int i=1;i<height.length-1;i++){
            int maxLeft=leftMaxDP[i],maxRight=rightMaxDP[i];
            int finalHeight=Math.min(maxLeft,maxRight);
            if(finalHeight>height[i]){
                result+=finalHeight-height[i];
            }
        }
        return result;
    }
    public int trap2(int[] height) {
        //使用双指针来记录当前位置左右两边的墙的最大值,当前i的最大高度值取决于left或者right中较小的值
        int righMax=0,leftMax=0;
        int result=0;
        int left=1,right=height.length-2;
        for(int i=1;i<height.length-1;i++){
            if(height[left-1]<height[right+1]){//当前以left为准
                leftMax=Math.max(leftMax,height[left-1]);//当前这个柱子能装多少水取决于这个柱子两端最高的柱子的高度
                if(leftMax>height[left]){
                    result+=leftMax-height[left];//当前的left柱子能装多少水进行更新
                }
                left++;
            }else{
                righMax=Math.max(righMax,height[right+1]);
                if(righMax>height[right]){
                    result+=righMax-height[right];
                }
                right--;
            }
        }
        return result;
    }
}
