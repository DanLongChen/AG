package L2019_5_24;

/**
 * Created by DanLongChen on 2019/5/24
 **/

import java.util.Arrays;

/**
 * 给定一个整形数组，找出其中最少需要排序的子数组元素值，使得整体的数组是有序的
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class L581 {
    public static void main(String[] args) {
        int[] nums={2,6,4,8,10,9,15};
        System.out.println(new L581().findUnsortedSubarray2(nums));
    }
    public int findUnsortedSubarray(int[] nums) {
        /**这种方法好像不行
         * 使用两个指针向中间移动，如果符合当前值>前面的值，并且<后面的值，则进行移动,当找到不符合规定的位置的时候对应的指针不再移动
         */
        if (nums.length==0 || nums.length==1){
            return 0;
        }
        int left=0;
        int right=nums.length-1;
        int flagL=0,flagR=0;
        while (left<right){
            System.out.println(left+" "+right);
            if (left==0 && nums[left]<=nums[left+1]){
                left++;
            }else{
                if (left==0 && nums[left]>nums[left+1]){
                    flagL=1;
                }else{
                    if (nums[left]>=nums[left-1] && nums[left]<=nums[left+1]){
                        left++;
                    }else{
                        flagL=1;
                    }
                }
            }

            if (right==nums.length-1 && nums[right-1]<=nums[right]){
                right--;
            }else{
                if (right==nums.length-1 && nums[right-1]>nums[right]){
                    flagR=1;
                }else{
                    if(nums[right]>=nums[right-1] && nums[right]<=nums[right+1]){
                        right--;
                    }else{
                        flagR=1;
                    }
                }
            }
            if(flagL+flagR==2){
                break;
            }

//            System.out.println(flagL+flagR);
        }
        if (left==right){
            return 0;
        }
        return right-left+1;
    }
    public int findUnsortedSubarray2(int[] nums){
        /**
         * 先排序，然后在和原来的比较，标识下标
         */
        int[] temp=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            temp[i]=nums[i];
        }
        Arrays.sort(nums);
        int left=0,right=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=temp[i]){
                left=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if (nums[i]!=temp[i]){
                right=i;
                break;
            }
        }
        if (left==0 && right==0){
            return 0;
        }
       return right-left+1;
    }
}
