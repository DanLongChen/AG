package L2019_4_13;

/**某个排序后的数组可能以某个轴进行了旋转，要做的是在旋转之后的数组中找到给定的target（返回false or true）
 * Created by Paser on 2019/4/13.
 */
public class L81 {
    public boolean search(int[] nums, int target) {
        if (nums.length==0){
            return false;
        }
        if(nums.length==1){
            return nums[0]==target?true:false;
        }
        /**
         * 初步思想：首先找到分段点（也就是那个旋转点），然后二分法查找
         */
        int fenge=0;//找到分割点(考虑分割点为0的情况)
        for (int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                fenge=i;
                break;
            }
        }
        int left=0,right=0;
        if(target>=nums[0]){
            left=0;
            right=fenge==0?nums.length-1:fenge-1;
        }else {
            left=fenge;
            right=nums.length-1;
        }
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                return true;
            }else{
                if(target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={2,5,6,0,0,1,2};
        System.out.println(new L81().search(nums,3));
    }
}
