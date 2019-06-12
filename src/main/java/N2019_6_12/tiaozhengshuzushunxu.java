package N2019_6_12;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/6/12
 * 调整数组顺序，使得奇数位于数组的前半部分，偶数位于数组的后半部分
 * 保证奇数和奇数，偶数和偶数之间的相对位置不变。
 **/
public class tiaozhengshuzushunxu {
    /**
     * 可以使用两个指针，一个指向开头，一个指向最后；如果第一个指针是偶数，并且第二个指针是偶数，那么就进行调换
     * 有点快速排序的味道（指针交换）
     * @param array
     */
    public void reOrderArray(int [] array) {
        int left=0,right=array.length-1;
        while (left<right){
            if ((array[left] & 1)!=1 && (array[right] &1) ==1){
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;
                left++;
                right--;
            }
            if((array[left] & 1)==1){
                left++;
            }
            if((array[right] &1) !=1){
                right--;
            }
        }
    }
    public void reOrderArray1(int [] array) {//如果是要保持奇数偶数其各自的先后顺序不变的话，可以使用挖坑法，遇到偶数就往后移动
        int temp=0;
        int length=array.length;
        for (int i=0;i<length;i++){
            if((array[i] & 1) ==0){
                temp=array[i];
                for (int j=i;j<array.length-1;j++){
                    array[j]=array[j+1];
                }
                array[array.length-1]=temp;
                length--;//长度减少是为了不重复处理已经排在最后的那部分偶数
                i--;//后面的数移动过来的时候还是指向当前的位置
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        new tiaozhengshuzushunxu().reOrderArray1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
