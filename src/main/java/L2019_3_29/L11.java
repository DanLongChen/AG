package L2019_3_29;

/**成最多水的容器
 * Created by DanLongChen on 2019/3/29
 **/
public class L11 {
    /**
     * 暴力破解法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        /**
         * 暴力
         */
        int max=0;
        for(int i=0;i<height.length;i++){
            for(int j=i;j<height.length;j++){
                int h=Math.min(height[i],height[j]);
                if(h*(j-i)>max){
                    max=h*(j-i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(new L11().maxArea(arr));
    }
}
