package L2019_6_27;

/**
 * Created by DanLongChen on 2019/6/27
 * 盛水最多的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L11 {
    public int maxArea(int[] height) {
        /**
         * 使用暴力破解，两次循环，找到每两条线的组合
         */
        int max=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int length=j-i;
                if(length*Math.min(height[i],height[j])>max){
                    max=length*Math.min(height[i],height[j]);
                }
            }
        }
        return max;
    }
    public int maxArea1(int[] height) {
        /**
         * 使用双指针：这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
         * 最初我们考虑由最外围两条线段构成的区域。现在，为了使面积最大化，我们需要考虑更长的两条线段之间的区域。
         * 如果我们试图将指向较长线段的指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。
         * 但是，在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大。
         * 因为移动较短线段的指针会得到一条相对较长的线段，这可以克服由宽度减小而引起的面积减小。
         */
        int max=0;
        int left=0,right=height.length-1;
        while(left<right){
            int length=Math.min(height[left],height[right]);//查看哪一个更加小，那么他就是制约因素
            if(length*(right-left)>max){
                max=length*(right-left);
            }
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;

    }
}
