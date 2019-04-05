package L2019_4_5;

/**寻找给定的target能否在nums中找到，若不能则返回应该插入的位置
 * Created by Paser on 2019/4/5.
 */
public class L35 {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }else{
                if(nums[i]<target){
                    continue;
                }else{
                    return i;
                }
            }
        }
        return nums.length;//需要插入最后一个
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        System.out.println(new L35().searchInsert(nums,7));
    }
}
