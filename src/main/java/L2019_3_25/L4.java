package L2019_3_25;

import java.util.Arrays;

/**Median of Two Sorted Arrays
 * Created by DanLongChen on 2019/3/25
 **/
public class L4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median=0;
        if(nums1.length==0 && nums2.length==0){
            return 0;
        }
        if(nums1.length==0 && nums2.length!=0){
            if(nums2.length%2==0){
                int temp=nums2.length/2;
                median=(double)(nums2[temp-1]+nums2[temp])/2;
            }else{
                int temp=(int) Math.floor(nums2.length/2);
                median=(double)nums2[temp];
            }
        }
        if(nums1.length!=0 && nums2.length==0){
            if(nums1.length%2==0){
                int temp=nums1.length/2;
                median=(double)(nums1[temp-1]+nums1[temp])/2;
            }else{
                int temp=(int) Math.floor(nums1.length/2);
                median=(double)nums1[temp];
            }
        }
        int[] result=new int[nums1.length+nums2.length];
        int i=0,j=0,r=0;
        /**
         * while循环将两个非空的数组组织为一个数组
         */
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                result[r++]=nums1[i];
                i++;
            }else{
                result[r++]=nums2[j];
                j++;
            }
        }
        while (i<nums1.length){
            result[r++]=nums1[i++];
        }
        while (j<nums2.length){
            result[r++]=nums2[j++];
        }
        if(result.length%2==0){
            int temp=result.length/2;
            median=(double) (result[temp-1]+result[temp])/2;
        }else{
            int temp=(int) Math.floor(result.length/2);
            median= (double) result[temp];
        }
        return median;
    }

    public static void main(String[] args) {
        L4 l4=new L4();
        int[] a={};
        int[] b={2};
        System.out.println(l4.findMedianSortedArrays(a,b));
    }
}
