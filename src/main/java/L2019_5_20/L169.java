package L2019_5_20;

/**
 * Created by DanLongChen on 2019/5/20
 **/

import java.util.Arrays;

/**
 * 找到多次出现的几个元素(出现次数>nums.lemgth/2取下线)
 */
public class L169 {
    public static void main(String[] args) {
        int[] nums={-1,1,1,1,2,1};
        System.out.println(new L169().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int half=(int)Math.floor((double)nums.length/2);
        int temp=nums[0];//用于记录当前的类的数值
        int count=1;
        for (int i=1;i<nums.length;i++){
            if (temp==nums[i]){
                count++;
                if (count>half){
                    return temp;
                }
            }else{
                temp=nums[i];
                count=1;
            }
        }
        return temp;
    }
}
