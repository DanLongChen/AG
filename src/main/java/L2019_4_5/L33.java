package L2019_4_5;

/**寻找对应target所在的下标
 * Created by Paser on 2019/4/5.
 */
public class L33 {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
