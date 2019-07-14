package L2019_7_14;

/**
 * Created by Paser on 2019/7/14.
 * 柱状图中最大矩形
 */
public class L84 {
    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(new L84().largestRectangleArea1(heights));
    }
    public int largestRectangleArea(int[] heights) {
        //暴力
        if(heights==null || heights.length==0){
            return 0;
        }
        int max=0;
        for(int i=0;i<heights.length;i++){
            for(int j=i;j<heights.length;j++){
                int min=heights[i];
                for(int k=i;k<=j;k++){
                    if(heights[k]<min){
                        min=heights[k];
                    }
                }
                max=Math.max(max,min*(j-i+1));
            }
        }
        return max;
    }
    public int largestRectangleArea1(int[] heights) {
        //暴力优化
        if(heights==null || heights.length==0){
            return 0;
        }
        int max=0;
        for(int i=0;i<heights.length;i++){
            int min=heights[i];//两个两个比较
            for(int j=i;j<heights.length;j++){
                min=Math.min(min,heights[j]);
                max=Math.max(max,min*(j-i+1));
            }
        }
        return max;
    }
}
