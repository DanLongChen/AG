package L2019_6_26;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/6/26
 *  寻找两个有序数组的中位数
 *  给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L4 {
    public static void main(String[] args) {
        int[] num1={1,2};
        int[] num2={3,4};
        System.out.println(new L4().findMedianSortedArrays(num1,num2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 解法：因为两个数组是有序的，所以给定两个指针，指向两个数组的下标，然后比较其大小值，小的插入数组，当到达mid（中位数位置）的时候就可以停止了，然后判断奇偶，返回结果
         */
        int length1=nums1.length;
        int length2=nums2.length;
        int[] nums=new int[length1+length2];
        int mid=(length1+length2)/2;
        int index=0,i=0,j=0;
        while (index<=mid){
            if(i<length1 && j<length2){//两个数组都没有读到末尾的情况
                if (nums1[i]<nums2[j]){
                    nums[index]=nums1[i];
                    i++;
                }else{
                    nums[index]=nums2[j];
                    j++;
                }
            }
            else if(i>=length1 && j<length2){
                nums[index]=nums2[j];
                j++;
            }else{
                nums[index]=nums1[i];
                i++;
            }
            index++;
        }
        if(((length1+length2)&1)==1){//表明是奇数
            return nums[mid];
        }else{
            return (nums[mid-1]+nums[mid])/2D;
        }
    }
}
