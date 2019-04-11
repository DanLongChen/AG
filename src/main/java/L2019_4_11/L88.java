package L2019_4_11;

import java.util.Arrays;

/**给定两个排序好的数组，其中每个数组的元素个数为m,n。假设nums1有足够的容量来存放nums1和nums2.要求合并两个数组
 * Created by DanLongChen on 2019/4/11
 **/
public class L88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        int[] result=new int[m+n];
        int index=0;
        while (j<n && i<m){
            if(nums1[i]<=nums2[j]){
                result[index++]=nums1[i++];
            }else{
                result[index++]=nums2[j++];
            }
        }
        while (j<n){
            result[index++]=nums2[j++];
        }
        while(i<m){
            result[index++]=nums1[i++];
        }
        for (int i1 = 0;i1<index;i1++){
            nums1[i1]=result[i1];
        }
    }

    public static void main(String[] args) {
        int[] num1={1,2,3,4,5,0,0,0};
        int[] num2={3,5,7};
        new L88().merge(num1,5,num2,3);
        System.out.println(Arrays.toString(num1));
    }
}
